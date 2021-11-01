package uz.pdp.service;

import uz.pdp.enums.CategoryEnum;
import uz.pdp.model.Category;

import java.util.ArrayList;

public class CategoryService {
    private ArrayList<Category> categories=new ArrayList<>();
    int id=33;

    public CategoryService() {
        categories.add(new Category(CategoryEnum.TV.getId(),CategoryEnum.TV.name()));
        categories.add(new Category(CategoryEnum.SONY.getId(),CategoryEnum.SONY.name(),CategoryEnum.TV.getId()));
        categories.add(new Category(CategoryEnum.LG.getId(),CategoryEnum.LG.name(),CategoryEnum.TV.getId()));
        categories.add(new Category(CategoryEnum.ARTEL.getId(),CategoryEnum.ARTEL.name(),CategoryEnum.TV.getId()));
        categories.add(new Category(CategoryEnum.SAMSUNG.getId(),CategoryEnum.SAMSUNG.name(),CategoryEnum.TV.getId()));

        categories.add(new Category(CategoryEnum.PHONE.getId(),CategoryEnum.PHONE.name()));
        categories.add(new Category(CategoryEnum.XIAOMI.getId(),CategoryEnum.XIAOMI.name(),CategoryEnum.PHONE.getId()));
        categories.add(new Category(CategoryEnum.NOKIA.getId(),CategoryEnum.NOKIA.name(),CategoryEnum.PHONE.getId()));
        categories.add(new Category(CategoryEnum.VIVO.getId(),CategoryEnum.VIVO.name(),CategoryEnum.PHONE.getId()));

        categories.add(new Category(CategoryEnum.NOTEBOOK.getId(),CategoryEnum.NOTEBOOK.name()));
        categories.add(new Category(CategoryEnum.APPLE.getId(),CategoryEnum.APPLE.name(),CategoryEnum.NOTEBOOK.getId()));
        categories.add(new Category(CategoryEnum.LENOVO.getId(),CategoryEnum.LENOVO.name(),CategoryEnum.NOTEBOOK.getId()));
        categories.add(new Category(CategoryEnum.ACER.getId(),CategoryEnum.ACER.name(),CategoryEnum.NOTEBOOK.getId()));
        categories.add(new Category(CategoryEnum.ASUS.getId(),CategoryEnum.ASUS.name(),CategoryEnum.NOTEBOOK.getId()));
        categories.add(new Category(CategoryEnum.DELL.getId(),CategoryEnum.DELL.name(),CategoryEnum.NOTEBOOK.getId()));

        categories.add(new Category(CategoryEnum.TECHNIQUE.getId(),CategoryEnum.TECHNIQUE.name()));
        categories.add(new Category(CategoryEnum.HOFFMAN.getId(),CategoryEnum.HOFFMAN.name(),CategoryEnum.TECHNIQUE.getId()));
        categories.add(new Category(CategoryEnum.SHIVAKI.getId(),CategoryEnum.SHIVAKI.name(),CategoryEnum.TECHNIQUE.getId()));
        categories.add(new Category(CategoryEnum.GOODWELL.getId(),CategoryEnum.GOODWELL.name(),CategoryEnum.TECHNIQUE.getId()));
        categories.add(new Category(CategoryEnum.AVALON.getId(),CategoryEnum.AVALON.name(),CategoryEnum.TECHNIQUE.getId()));

        categories.add(new Category(CategoryEnum.SPORT.getId(),CategoryEnum.SPORT.name()));
        categories.add(new Category(CategoryEnum.FOOTBALL.getId(),CategoryEnum.FOOTBALL.name(),CategoryEnum.SPORT.getId()));
        categories.add(new Category(CategoryEnum.TENNIS.getId(),CategoryEnum.TENNIS.name(),CategoryEnum.SPORT.getId()));
        categories.add(new Category(CategoryEnum.BASKETBALL.getId(),CategoryEnum.BASKETBALL.name(),CategoryEnum.SPORT.getId()));
        categories.add(new Category(CategoryEnum.SWIM.getId(),CategoryEnum.SWIM.name(),CategoryEnum.SPORT.getId()));

        categories.add(new Category(CategoryEnum.FOOTBALL_UNIFORM.getId(),CategoryEnum.FOOTBALL_UNIFORM.name(),CategoryEnum.FOOTBALL.getId()));
        categories.add(new Category(CategoryEnum.TENNIS_UNIFORM.getId(),CategoryEnum.TENNIS_UNIFORM.name(),CategoryEnum.TENNIS.getId()));
        categories.add(new Category(CategoryEnum.BASKETBALL_UNIFORM.getId(),CategoryEnum.BASKETBALL_UNIFORM.name(),CategoryEnum.BASKETBALL.getId()));
        categories.add(new Category(CategoryEnum.SWIM_UNIFORM.getId(),CategoryEnum.SWIM_UNIFORM.name(),CategoryEnum.SWIM.getId()));

        categories.add(new Category(CategoryEnum.BOOK.getId(),CategoryEnum.BOOK.name()));
        categories.add(new Category(CategoryEnum.RELIGIOUS.getId(),CategoryEnum.RELIGIOUS.name(),CategoryEnum.BOOK.getId()));
        categories.add(new Category(CategoryEnum.WORLD.getId(),CategoryEnum.WORLD.name(),CategoryEnum.BOOK.getId()));
    }

    public void getAllCategory(){
        for (Category category : categories) {
            if(category.getParentCategoryId()==-1){
                System.out.println(category.getId()+".## "+category.getName()+" ##");
                getCategoryFromParent(category.getId());
                System.out.println("-------------------------------");
            }
        }
    }

    public boolean getCategoryFromParent(int parentId){
        boolean has=false;
        for (Category category : categories) {
            if(category.getParentCategoryId()==parentId){
                System.out.println(category.getId()+"."+category.getName());
                getCategoryFromParent(category.getId());
                has=true;
            }
        }
        return has;
    }

    public boolean getParents(int categoryId){
        for (Category category : categories) {
            if(category.getId()==categoryId){
                getParents(category.getParentCategoryId());
                System.out.print(category.getName()+" > ");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategories(Category category) {
        category.setId(id++);
        categories.add(category);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
