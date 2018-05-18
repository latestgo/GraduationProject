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

    @Override
    public String toString() {
        return "category{" +
                "categoryid=" + categoryid +
                ", description='" + description + '\'' +
                '}';
    }
}
