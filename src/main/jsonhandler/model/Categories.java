package main.jsonhandler.model;

public class Categories {
    private Category[] categories;

    public Categories() {
    }

    public void isAllInitialized() {
        for (Category obj : categories) {
            obj.isAllInitialized();
        }
    }

    public Categories(Category[] categories) {
        this.categories = categories;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }
}
