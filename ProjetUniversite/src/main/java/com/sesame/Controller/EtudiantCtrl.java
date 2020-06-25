package com.sesame.Controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.DAO.Enseignant;
import com.sesame.DAO.Etudiant;
import com.sesame.DAO.Salle;
import com.sesame.Interface.EtudiantInterface;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin("*")
public class EtudiantCtrl {

	@Autowired
	private EtudiantInterface f;
	
	@PostMapping("/add")
	Etudiant ajoutEtudiant(@RequestBody Etudiant Etudiant) {
		
		if(Etudiant !=null) {
			return f.Add(Etudiant);
		}
		return Etudiant;
	}
	
	@GetMapping("/get")
	Collection<Etudiant> listeEtudiant() {
		
			return f.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Etudiant Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		f.Delete(id);
	}
	

	@PutMapping("/edit")  
	public void Update(@RequestBody Etudiant e){
		
		f.Edit(e);
	}
	
	/*@DeleteMapping("/delete")
	public void deleteEtudiant(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	
	@PutMapping("/update")
	Etudiant Update (@RequestBody Etudiant e) {
		
		long id = e.getNumInscription();
		String nom = e.getNomETU();
		String prenom = e.getPrenomETU();
		String adresse =e.getAdresseETU();
		Date diplome = e.getDateEntre();
		
		
		
		if(f.findId(id)==true) {
			Etudiant etud =new Etudiant (id,nom,prenom,adresse,diplome);
			
			return  f.Edit(etud);
			}
		else {
			return null;}
		}*/
	
}
