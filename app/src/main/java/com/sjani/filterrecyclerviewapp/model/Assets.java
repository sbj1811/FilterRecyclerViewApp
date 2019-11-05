
package com.sjani.filterrecyclerviewapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assets {

    @SerializedName("menu")
    @Expose
    private List<Menu> menu = null;
    @SerializedName("product_details_page")
    @Expose
    private List<ProductDetailsPage> productDetailsPage = null;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<ProductDetailsPage> getProductDetailsPage() {
        return productDetailsPage;
    }

    public void setProductDetailsPage(List<ProductDetailsPage> productDetailsPage) {
        this.productDetailsPage = productDetailsPage;
    }

    @Override
    public String toString() {
        return "Assets{" +
                "menu=" + menu.toString() +
                ", productDetailsPage=" + productDetailsPage +
                '}';
    }
}
