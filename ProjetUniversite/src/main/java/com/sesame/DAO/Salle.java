package com.sesame.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Salle implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numS;
	private String nomS;
	private long capacite;
	
	@OneToOne
	@JoinColumn(name="code_C")
	private Cours cours;

	
	public Salle( String nomS, long capacite,Cours cours) {
		this.nomS = nomS;
		this.capacite = capacite;
		this.cours=cours;
	}
	
	
	public Salle(long numS, String nomS, long capacite) {
		super();
		this.numS = numS;
		this.nomS = nomS;
		this.capacite = capacite;
	}


	public Salle() {
	}
	public long getNumS() {
		return numS;
	}
	public void setNumS(long numS) {
		this.numS = numS;
	}
	public String getNomS() {
		return nomS;
	}
	public void setNomS(String nomS) {
		this.nomS = nomS;
	}
	public long getCapacite() {
		return capacite;
	}
	public void setCapacite(long capacite) {
		this.capacite = capacite;
	}

	
}
