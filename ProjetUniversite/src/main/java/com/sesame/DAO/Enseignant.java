package com.sesame.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;


@Entity
public class Enseignant implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long matricul;
	private String nomens;
	private String prenomens;
	private String adresseens;
	private String diplom;

	@ManyToOne
	@JoinColumn(name="codedep")
	private Departements departements;

	@ManyToOne
	@JoinColumn(name="code_C")
	private Cours cours;

	@ManyToMany
	@JoinTable(name="etudiant_enseignant" ,joinColumns=@JoinColumn(name="enseignant_id"), inverseJoinColumns=@JoinColumn(name="etudiant_id"))
	private Collection <Etudiant> etudiants;
	
	
	public Enseignant() {}

	public Enseignant(Long matricul, String nomens, String prenomens, String adresseens, String diplom,
			Departements departement) {
		super();
		this.matricul = matricul;
		this.nomens = nomens;
		this.prenomens = prenomens;
		this.adresseens = adresseens;
		this.diplom = diplom;
		this.departements = departements;
	}

	public Enseignant(Long matricul, String nomens, String prenomens, String adresseens, String diplom) {
		super();
		this.matricul = matricul;
		this.nomens = nomens;
		this.prenomens = prenomens;
		this.adresseens = adresseens;
		this.diplom = diplom;
	}

	public Long getMatricul() {
		return matricul;
	}

	public void setMatricul(Long matricul) {
		this.matricul = matricul;
	}

	public String getNomens() {
		return nomens;
	}

	public void setNomens(String nomens) {
		this.nomens = nomens;
	}

	public String getPrenomens() {
		return prenomens;
	}

	public void setPrenomens(String prenomens) {
		this.prenomens = prenomens;
	}

	public String getAdresseens() {
		return adresseens;
	}

	public void setAdresseens(String adresseens) {
		this.adresseens = adresseens;
	}

	public String getDiplom() {
		return diplom;
	}

	public void setDiplom(String diplom) {
		this.diplom = diplom;
	}

	public Departements getDepartements() {
		return departements;
	}

	public void setDepartements(Departements departements) {
		this.departements = departements;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
	
	
	
	
	
	


}
