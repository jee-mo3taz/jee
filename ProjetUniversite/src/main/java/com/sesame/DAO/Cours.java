package com.sesame.DAO;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cours implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long code_C;
private String libelle;

@OneToOne
@JoinColumn(name="numS")
private Salle salle;

@OneToMany(mappedBy="cours")
private Collection<Enseignant> enseignant;

@ManyToMany(mappedBy="cours")
private Collection <Etudiant> etudiant;


public Cours(String libelle) {
	super();
	this.libelle = libelle;
}
public Cours(long code_C ,String libelle,Salle s) {
	super();
	this.code_C=code_C;
	this.libelle = libelle;
	this.salle=s;
}
public Cours() {
	super();
}
public long getCode_C() {
	return code_C;
}
public void setCode_C(long code_C) {
	this.code_C = code_C;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Salle getSalle() {
	return salle;
}
public void setSalle(Salle salle) {
	this.salle = salle;
}

}
