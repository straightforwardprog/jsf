/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Beintech
 */
public class produit  implements Serializable {
private static final long serialVersionUID = 1L;
private int id;
private String Titre;
private double prix;

    public produit(int id, String Titre, double prix) {
        this.id = id;
        this.Titre = Titre;
        this.prix = prix;
    }

    public produit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
	public produit clone() {
		return new produit(id, Titre,prix);
	}
        
     public void restore(produit p) {
		this.id = p.getId();
		this.Titre = p.getTitre();
                this.prix= p.getPrix();
     }
}
