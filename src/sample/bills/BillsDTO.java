/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bills;

import java.sql.Date;

/**
 *
 * @author hello
 */
public class BillsDTO {
    private int id;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private int idTableFoods;
    private int status;
    private int discount;
    

    public BillsDTO() {
    }

    public BillsDTO(int id, Date dateCheckIn, Date dateCheckOut, int idTableFoods, int status, int discount) {
        this.id = id;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.idTableFoods = idTableFoods;
        this.status = status;
        this.discount = discount;
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
     * @return the dateCheckIn
     */
    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    /**
     * @param dateCheckIn the dateCheckIn to set
     */
    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    /**
     * @return the dateCheckOut
     */
    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    /**
     * @param dateCheckOut the dateCheckOut to set
     */
    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    /**
     * @return the idTableFoods
     */
    public int getIdTableFoods() {
        return idTableFoods;
    }

    /**
     * @param idTableFoods the idTableFoods to set
     */
    public void setIdTableFoods(int idTableFoods) {
        this.idTableFoods = idTableFoods;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    
    
}
