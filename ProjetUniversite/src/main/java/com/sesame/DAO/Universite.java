package com.sesame.DAO;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Universite implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Long codeuniv;
public String nomuniv;
public String adresseSite;

@OneToMany(mappedBy="universite",fetch=FetchType.LAZY)
private Collection<Departements> Departements;
public Universite() {
	super();
}

public Universite(String nomuniv, String adresseSite) {
	super();

	this.nomuniv = nomuniv;
	this.adresseSite = adresseSite;
}

public Universite(Long id, String nomuniv, String adresseSite) {
	super();
	this.codeuniv=id;
	this.nomuniv = nomuniv;
	this.adresseSite = adresseSite;
}

public Universite(Long id) {
	super();
	this.codeuniv=id;
}

public Long getCodeuniv() {
	return codeuniv;
}

public void setCodeuniv(Long codeuniv) {
	this.codeuniv = codeuniv;
}

public String getNomuniv() {
	return nomuniv;
}

public void setNomuniv(String nomuniv) {
	this.nomuniv = nomuniv;
}

public String getAdresseSite() {
	return adresseSite;
}

public void setAdresseSite(String adresseSite) {
	this.adresseSite = adresseSite;
}
/*
public Collection<Departement> getDepartements() {
	return Departements;
}

public void setDepartements(Collection<Departement> departements) {
	Departements = departements;
}*/



}
