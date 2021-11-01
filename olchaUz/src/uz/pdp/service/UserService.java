package uz.pdp.service;

import uz.pdp.enums.GenderEnum;
import uz.pdp.enums.RoleEnum;
import uz.pdp.model.User;

import java.util.ArrayList;

public class UserService {
    ArrayList<User> users=new ArrayList<>();

    public UserService() {
        User admin = new User("Admin", "+9981", 1, "1", GenderEnum.MALE);
        admin.setRole(RoleEnum.ADMIN);
        users.add(admin);
    }

    public boolean existUserFromPhone(String phone){
        for (User user : users) {
            if(user.getPhone().equals(phone))
                return true;
        }
        return false;
    }
    public User existUserFromPhoneAndPassword(String phone,String password){
        for (User user : users) {
            if(user.getPhone().equals(phone) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }



    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public void changeUser(User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(user.getId())){
                users.remove(users.get(i));
            }
        }
        users.add(user);
    }

    public String generateSmsCode(){
        String code;
        do {
            code=String.valueOf((int) (Math.random()*100000));
        }while (code.length()!=5);
        return code;
    }
}
