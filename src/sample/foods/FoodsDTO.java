/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.foods;

/**
 *
 * @author hello
 */
public class FoodsDTO {
    
    private int id;
    private String name;
    private String idFoodCategory;
    private float price;

    public FoodsDTO() {
    }

    public FoodsDTO(int id, String name, String idFoodCategory, float price) {
        this.id = id;
        this.name = name;
        this.idFoodCategory = idFoodCategory;
        this.price = price;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idFoodCategory
     */
    public String getIdFoodCategory() {
        return idFoodCategory;
    }

    /**
     * @param idFoodCategory the idFoodCategory to set
     */
    public void setIdFoodCategory(String idFoodCategory) {
        this.idFoodCategory = idFoodCategory;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

  
    
}
