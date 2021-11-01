package uz.pdp.model;



public class Category{
    private int id;
    private String name;
    private int parentCategoryId;


    public Category() {
    }

    public Category(int id, String name, int parentCategoryId) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.parentCategoryId=-1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

}
