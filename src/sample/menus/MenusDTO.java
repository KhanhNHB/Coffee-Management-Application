/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.menus;

/**
 *
 * @author hello
 */
public class MenusDTO {
    
    private String name;
    private int quatity;
    private float price;
    private float totalPrice;

    public MenusDTO() {
    }

    public MenusDTO(String name, int quatity, float price, float totalPrice) {
        this.name = name;
        this.quatity = quatity;
        this.price = price;
        this.totalPrice = totalPrice;
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
     * @return the quatity
     */
    public int getQuatity() {
        return quatity;
    }

    /**
     * @param quatity the quatity to set
     */
    public void setQuatity(int quatity) {
        this.quatity = quatity;
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

    /**
     * @return the totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
