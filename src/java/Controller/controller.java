/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import beans.produit;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Beintech
 */

@Named(value = "controller")
@javax.enterprise.context.SessionScoped

public class controller implements Serializable{
private static final long serialVersionUID = -1;
        
    private List<produit> list;
    private produit item = new produit();
    private produit beforeEditItem = null;
    private boolean edit;
    
    @PostConstruct
    public void init() {
        list = new ArrayList<produit>();
    }
    
    public void add() {
    	// DAO save the add
        //item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new produit();
    }

    public void resetAdd() {
    	item = new produit();
    }

    public void edit(produit item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new produit();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new produit();
        edit = false;
    }

    public void delete(produit item) throws IOException {
    	// DAO save the delete
        list.remove(item);
    }

    public List<produit> getList() {
        return list;
    }

    public produit getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
    
}
