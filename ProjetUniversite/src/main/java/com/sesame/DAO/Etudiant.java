package com.sesame.DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numinsc;
	private String nometu;
	private String prenometu;
	private String adresseetu;

	private Date dateentee;
	
	@ManyToMany(mappedBy="etudiants")
	private Collection <Enseignant> enseignants;
	
	@ManyToMany
	@JoinTable(name="etudiant_cours" ,joinColumns=@JoinColumn(name="etudiant_id"), inverseJoinColumns=@JoinColumn(name="cour_id"))
	private Collection <Cours> cours;
	
	public Etudiant(String nometu, String prenometu, String adresseetu, Date dateentee) {
		
		this.nometu = nometu;
		this.prenometu = prenometu;
		this.adresseetu = adresseetu;
		this.dateentee = dateentee;
	}
	
	public Etudiant(long numinsc, String nometu, String prenometu, String adresseetu, Date dateentee) {
		super();
		this.numinsc = numinsc;
		this.nometu = nometu;
		this.prenometu = prenometu;
		this.adresseetu = adresseetu;
		this.dateentee = dateentee;
	}

	public Etudiant() {
		super();
	}

	public long getNuminsc() {
		return numinsc;
	}

	public void setNuminsc(long numinsc) {
		this.numinsc = numinsc;
	}

	public String getNometu() {
		return nometu;
	}

	public void setNometu(String nometu) {
		this.nometu = nometu;
	}

	public String getPrenometu() {
		return prenometu;
	}

	public void setPrenometu(String prenometu) {
		this.prenometu = prenometu;
	}

	public String getAdresseetu() {
		return adresseetu;
	}

	public void setAdresseetu(String adresseetu) {
		this.adresseetu = adresseetu;
	}

	public Date getDateentee() {
		return dateentee;
	}

	public void setDateentee(Date dateentee) {
		this.dateentee = dateentee;
	}

	public Collection<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

}
