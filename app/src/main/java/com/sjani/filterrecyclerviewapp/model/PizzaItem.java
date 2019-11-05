
package com.sjani.filterrecyclerviewapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(tableName = "pizzaitems")
public class PizzaItem implements Serializable
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private Integer id;
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;
    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    private String price;
    @ColumnInfo(name = "category")
    private Integer category;
    @ColumnInfo(name = "menu_description")
    @SerializedName("menu_description")
    @Expose
    private String menuDescription;
    @ColumnInfo(name = "classifications")
    @SerializedName("classifications")
    @Expose
    private Classifications classifications;
    @ColumnInfo(name = "assets")
    @SerializedName("assets")
    @Expose
    private Assets assets;
    @ColumnInfo(name = "toppings")
    @SerializedName("toppings")
    @Expose
    private List<Topping> toppings = null;
    @ColumnInfo(name = "quantity")
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @ColumnInfo(name = "spicy")
    @SerializedName("spicy")
    @Expose
    private Boolean spicy;
    private final static long serialVersionUID = -3730342938816156154L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public Classifications getClassifications() {
        return classifications;
    }

    public void setClassifications(Classifications classifications) {
        this.classifications = classifications;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getQuantity() {
            return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    public void setSpicy() {
        for (Topping topping: this.getToppings()) {
            if(topping.getName().toLowerCase().contains("pepper")){
                spicy = true;
            }
        }
    }

    @Override
    public String toString() {
        return "PizzaItem{" +
                "\n id=" + id +
                ",\n price='" + price + '\'' +
                ",\n category=" + category +
                ",\n menuDescription='" + menuDescription + '\'' +
                ",\n classifications=" + classifications.toString() +
                ",\n assets=" + assets.toString() +
                ",\n toppings=" + toppings.toArray().toString() +
                ",\n quantity='" + quantity + '\'' +
                ",\n spicy=" + spicy +
                '}';
    }
}
