package uz.pdp;

import uz.pdp.enums.GenderEnum;
import uz.pdp.enums.RoleEnum;
import uz.pdp.model.*;
import uz.pdp.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();
    static UserService userService = new UserService();
    static User crtUser;
    static BasketService basketService;
    static BasketProductService basketProductService = new BasketProductService();

    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static int option = -1;
    static String wrongOption = "\n------------ Wrong option! --------------\n";
    static String arrow = "------------------ > ";

    public static void main(String[] args) {
        while (option != 0) {
            System.out.println("/-/-/-/-/\tOLCHA.UZ\t/-/-/-/-/");
            if (crtUser == null)
                System.out.println("\n1.Enter\t|\t2.Catalog\t|\t0.Exit");
            else{
                if(crtUser.getRole().equals(RoleEnum.ADMIN))
                    System.out.println("\n1.Enter\t|\t2.Catalog\t|\t3.Basket\t|\t4.Cabinet\t|\t5.Add Category\t|\t6.Add Product\t|\t0.Exit");
                else
                    System.out.println("\n1.Enter\t|\t2.Catalog\t|\t3.Basket\t|\t4.Cabinet\t|\t0.Exit");
            }

            System.out.print("\n\n" + arrow);
            option = scannerInt.nextInt();
            switch (option) {
                case 1:
                    enterToSystem();
                    option = -1;
                    break;
                case 2:
                    getCatalog();
                    option = -1;
                    break;
                case 3:
                    if (crtUser == null) {
                        System.out.println(wrongOption);
                        break;
                    }
                    getBasket();
                    break;
                case 4:
                    if (crtUser == null) {
                        System.out.println(wrongOption);
                        break;
                    }
                    getCabinet();
                    option=-1;
                    break;
                case 5:
                    if (crtUser == null || crtUser.getRole().equals(RoleEnum.USER)) {
                        System.out.println(wrongOption);
                        break;
                    }
                    addCategory();
                    break;
                case 6:
                    if (crtUser == null || crtUser.getRole().equals(RoleEnum.USER)) {
                        System.out.println(wrongOption);
                        break;
                    }
                    addProduct();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(wrongOption);
            }
        }
    }

    private static void addProduct() {
        categoryService.getAllCategory();
        System.out.println("\n\tCHOOSE CATEGORY of PRODUCT");
        System.out.print(arrow);
        int categoryId=scannerInt.nextInt();
        while (categoryService.getCategoryFromParent(categoryId)) {
            System.out.println("---------------------------------- 0.Back");
            System.out.print(arrow);
            categoryId = scannerInt.nextInt();
            if(categoryId==0)break;
        }
        if(categoryId>=categoryService.getId() || categoryId<1){
            System.out.println(wrongOption);
            return;
        }
        Product product=new Product();
        product.setCategoryId(categoryId);

        scannerStr=new Scanner(System.in);
        System.out.println("\nNAME");
        System.out.print(arrow);
        product.setName(scannerStr.nextLine());
        System.out.println("\nPRICE($)");
        System.out.print(arrow);
        product.setPrice(scannerInt.nextDouble());
        System.out.println("\nWARRANTY(Month)");
        System.out.print(arrow);
        product.setWarranty(scannerInt.nextInt());
        System.out.println("\nDESCRIPTION");
        System.out.print(arrow);
        product.setDescription(scannerStr.nextLine());
        productService.addProduct(product);
        System.out.println("\n--------------- SUCCESS --------------\n");

    }

    private static void addCategory() {
        categoryService.getAllCategory();
        System.out.println("\n\tCHOOSE PARENT CATEGORY if YOUR CATEGORY IS PARENT, ENTER -1");
        System.out.print(arrow);
        option=scannerInt.nextInt();
        if(option>=categoryService.getId() || option==0 || option<-1){
            System.out.println(wrongOption);
            return;
        }
        Category category=new Category();
        category.setParentCategoryId(option);
        System.out.println("NAME");
        System.out.print(arrow);
        category.setName(scannerStr.next());
        categoryService.addCategories(category);
        System.out.println("\n--------------- SUCCESS --------------\n");
    }

    private static void getCabinet() {
       while (option!=0){
           System.out.println("ID ------> "+crtUser.getId());
           System.out.println("Name ------> "+crtUser.getName());
           System.out.println("Phone ------> "+crtUser.getPhone());
           System.out.println("Birth date ------> "+crtUser.getBirthDate());
           System.out.println("Gender ------> "+crtUser.getGender());
           System.out.println("\n1.Change password\t|\t2.Change birth date\t|\t3.Basket\t|\t0.Back");
           System.out.print("\n"+arrow);
           option=scannerInt.nextInt();
           switch (option){
               case 1:
                   changePassword();
                   break;
               case 2:
                   changeBirthDate();
                   break;
               case 3:
                   getBasket();
                   break;
               case 0:
                   break;
               default:
                   System.out.println(wrongOption);
           }
       }

    }

    private static void changeBirthDate() {
        System.out.println("BIRTH DATE(YYYY-MM-dd)");
        System.out.print(arrow);
        scannerStr=new Scanner(System.in);
        String s = scannerStr.nextLine();
        try {
            LocalDate date = LocalDate.parse(s);
            crtUser.setBirthDate(date);
            userService.changeUser(crtUser);
            System.out.println("\n --------------- SUCCESS ---------------\n");
        }catch (Exception e){
            System.out.println("\n--------- Please use this pattern -> 'YYYY-MM-dd' -----------\n");
        }
    }

    private static void changePassword() {
        System.out.println("OLD PASSWORD");
        System.out.print(arrow);
        String oldPassword=scannerStr.next();
        if(!oldPassword.equals(crtUser.getPassword())){
            System.out.println("\n----------- Passwords don't match --------------\n");
            return;
        }
        System.out.println("NEW PASSWORD");
        System.out.print(arrow);
        String newPassword=scannerStr.next();
        System.out.println("NEW PASSWORD AGAIN");
        System.out.print(arrow);
        String prePassword=scannerStr.next();
        if(!newPassword.equals(prePassword)){
            System.out.println("\n----------- Passwords don't match --------------\n");
            return;
        }
        crtUser.setPassword(newPassword);
        userService.changeUser(crtUser);
        System.out.println("\n --------------- SUCCESS ---------------\n");
    }

    public static void enterToSystem() {
        while (option != 0) {
            System.out.println("1.SIGN IN\t|\t2.SIGN UP\t|\t0.Back");
            System.out.print("\n\n" + arrow);
            option = scannerInt.nextInt();
            switch (option) {
                case 1:
                    if (signIn()) return;
                    break;
                case 2:
                    signUp();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(wrongOption);
            }
        }
    }

    private static boolean signUp() {
        System.out.println("PHONE NUMBER");
        System.out.print(arrow + "\t+998 ");
        String phone = "+998"+scannerStr.next();
        if (userService.existUserFromPhone(phone)) {
            System.out.println("\n---------- Already exist! -------------\n");
            return false;
        }

        String code = userService.generateSmsCode();
        System.out.println("SMS CODE("+code+")");
        System.out.print(arrow + "\t ");
        String next = scannerStr.next();
        if(!code.equals(next)){
            System.out.println("------------------- Codes don't match! -------------------");
            return false;
        }
        System.out.println("PASSWORD");
        System.out.print(arrow + "\t ");
        String password = scannerStr.next();
        System.out.println("ENTER PASSWORD AGAIN");
        System.out.print(arrow + "\t ");
        String prePassword = scannerStr.next();
        if(!prePassword.equals(password)){
            System.out.println("\n----------- Passwords don't match -------------\n");
            return false;
        }

        System.out.println("NAME");
        System.out.print(arrow + "\t");
        String name = scannerStr.next();
        User user = new User(name, phone, Integer.parseInt(code), password, GenderEnum.MALE);
        userService.addUsers(user);
        if(basketService==null){
            basketService=new BasketService(user.getId());
        }else {
            basketService.addBaskets(new Basket(user.getId()));
        }
        crtUser=user;
        System.out.println("--------------- WELCOME! ---------------");
        return true;
    }

    public static boolean signIn() {
        ArrayList<User> users = userService.getUsers();
        System.out.println("PHONE NUMBER");
        System.out.print(arrow + "\t+998 ");
        String phone = "+998"+scannerStr.next();
        if (!userService.existUserFromPhone(phone)) {
            System.out.println("\n---------- User not found! -------------\n");
            return false;
        }
        System.out.println("PASSWORD");
        System.out.print(arrow);
        String password = scannerStr.next();
        User user = userService.existUserFromPhoneAndPassword(phone, password);
        if (user == null) {
            System.out.println("Password doesn't match");
            return false;
        }
        crtUser = user;
        if(basketService==null){
            basketService=new BasketService(user.getId());
        }else {
            basketService.addBaskets(new Basket(user.getId()));
        }
        System.out.println("--------------- WELCOME! ---------------");
        return true;
    }


    public static void getCatalog() {
        while (option != 0) {
            categoryService.getAllCategory();
            System.out.println("\n--------------------------------------------------- 0.Back");
            System.out.print("\n" + arrow);
            option = scannerInt.nextInt();
            if (option == 0) break;

            boolean parents = categoryService.getParents(option);
            System.out.println();
            if (!parents) System.out.println(wrongOption);


            while (categoryService.getCategoryFromParent(option)) {
                System.out.println("---------------------------------- 0.Back");
                System.out.print(arrow);
                option = scannerInt.nextInt();
                if(option==0)break;
            }

            if(option!=0)
            getProductFromCategory(option);
            option = -1;


        }
    }

    public static void getProductFromCategory(int categoryId) {
        Product[] products = new Product[0];
        products = productService.getProducts().toArray(products);
        while (option != 0) {
            boolean has = false;
            for (int i = 0; i < products.length; i++) {
                if (products[i].getCategoryId() == categoryId) {
                    System.out.println("------------------------------------");
                    System.out.println((i + 1) + "." + products[i].getName());
                    System.out.println("Price: " + products[i].getPrice() + " $");
                    System.out.println("Warranty: " + products[i].getWarranty() + " month");
                    System.out.println("Description: " + products[i].getDescription());
                    System.out.println("---------------------------------------------------------");
                    has = true;
                }
            }
            System.out.println("\n------------------------------------- 0.Back");
            if (!has) {
                System.out.println("\n-------------- Products not found! -------------------\n");
                break;
            }
            has = false;
            System.out.println("------------ Choose to buy -----------------");
            System.out.print("\n" + arrow);
            option = scannerInt.nextInt();
            if (crtUser == null) {
                System.out.println("\n---------------- Please sign in ------------------\n");
                option = 0;
            } else {
                for (int i = 0; i < products.length; i++) {
                    if (i + 1 == option && products[i].getCategoryId() == categoryId) {
                        has = true;
                        System.out.println("\n\tYou want to add " + products[i].getName() + " to your basket(yes/no)");
                        System.out.print("\n" + arrow);
                        String ans = scannerStr.next().toLowerCase();
                        if (ans.equals("yes")) {
                            UUID basketId = basketService.findByUserId(crtUser.getId());
                            basketProductService.addBasketProducts(
                                    new BasketProduct(basketId, products[i].getId())
                            );
                            System.out.println("\n----- Product successfully added to basket -----\n");
                        } else if (!ans.equals("no"))
                            System.out.println(wrongOption);
                    }
                }
                if (!has) System.out.println(wrongOption);
            }
        }
    }


    private static void getBasket() {
        double fullPrice = 0;
        UUID basket = basketService.findByUserId(crtUser.getId());
        HashMap<UUID, Integer> productsIdFromBasket = basketProductService.getProductsIdFromBasket(basket);
        if (productsIdFromBasket.isEmpty()) {
            System.out.println("\n---------------------- Basket is empty! ----------------------\n");
        } else {
            for (UUID id : productsIdFromBasket.keySet()) {
                categoryService.getParents(productService.getProductById(id).getCategoryId());
                System.out.println("\n--------------------------------------");
                System.out.println();
                fullPrice += productService.getProductFromId(id,productsIdFromBasket.get(id))*productsIdFromBasket.get(id);
            }
            System.out.println("\nPrice: " + fullPrice + "\n");
        }

    }

}
