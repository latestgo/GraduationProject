package cn.isohard.campus.entities;

public class Category {

    private Integer categoryid;

    private String description;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(Integer categoryid, String description) {
        this.categoryid = categoryid;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", description='" + description + '\'' +
                '}';
    }
}
