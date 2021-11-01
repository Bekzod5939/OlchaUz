package uz.pdp.model;

import uz.pdp.enums.GenderEnum;
import uz.pdp.enums.RoleEnum;
import uz.pdp.model.base.BaseModel;

import java.time.LocalDate;

public class User extends BaseModel {
    private String name;
    private String phone;
    private int smsCode;
    private String password;
    private LocalDate birthDate;
    private GenderEnum gender;
    private RoleEnum role;

    public User(String name, String phone, int smsCode, String password, GenderEnum gender) {
        this.name = name;
        this.phone = phone;
        this.smsCode = smsCode;
        this.password = password;
        this.gender = gender;
        this.role = RoleEnum.USER;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(int smsCode) {
        this.smsCode = smsCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
