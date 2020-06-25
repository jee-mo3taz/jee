package com.sesame.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sesame.DAO.Universite;

@Entity
public class Departements implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codedep;
	private String nomdep;


	@ManyToOne
	@JoinColumn(name="codeuniv")
	private Universite universite;

	
	public Departements(long codedep, String nomdep, Universite universite) {
		super();
		this.codedep = codedep;
		this.nomdep = nomdep;
		this.universite = universite;
	}
	public Departements(long codedep, String nomdep) {
		super();
		this.codedep = codedep;
		this.nomdep = nomdep;
	}
	public Departements(long codedep, String nom,long codeuniv) {
		super();
		this.codedep = codedep;
		this.nomdep = nomdep;
		this.universite.codeuniv=codeuniv;
	}
	public Departements(String nomdep) {
		super();
		this.nomdep = nomdep;
	}
	public Departements() {
		super();
	}
	public long getCodedep() {
		return codedep;
	}
	public void setCodedep(long codedep) {
		this.codedep = codedep;
	}
	public String getNomdep() {
		return nomdep;
	}
	public void setNomdep(String nomdep) {
		this.nomdep = nomdep;
	}
	public Universite getUniversite() {
		return universite;
	}
	public void setUniversite(Universite universite) {
		this.universite = universite;
	}

	
	
}
