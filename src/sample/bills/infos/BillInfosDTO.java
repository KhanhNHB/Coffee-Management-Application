/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bills.infos;

/**
 *
 * @author hello
 */
public class BillInfosDTO {
    
    private int id;
    private int idBills;
    private int idFoods;
    private int count;

    public BillInfosDTO() {
    }

    public BillInfosDTO(int id, int idBills, int idFoods, int count) {
        this.id = id;
        this.idBills = idBills;
        this.idFoods = idFoods;
        this.count = count;
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
     * @return the idBills
     */
    public int getIdBills() {
        return idBills;
    }

    /**
     * @param idBills the idBills to set
     */
    public void setIdBills(int idBills) {
        this.idBills = idBills;
    }

    /**
     * @return the idFoods
     */
    public int getIdFoods() {
        return idFoods;
    }

    /**
     * @param idFoods the idFoods to set
     */
    public void setIdFoods(int idFoods) {
        this.idFoods = idFoods;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    
}
