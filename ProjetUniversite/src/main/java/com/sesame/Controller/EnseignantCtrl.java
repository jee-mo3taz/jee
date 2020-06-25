package com.sesame.Controller;

import java.util.Collection;

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
import com.sesame.DAO.Salle;
import com.sesame.Interface.EnseignantInterface;

@RestController
@RequestMapping("/enseignant")
@CrossOrigin("*")
public class EnseignantCtrl {

	@Autowired
	private EnseignantInterface f;
	
	@PostMapping("/add")
	Enseignant ajoutEnseignant(@RequestBody Enseignant Enseignant) {
		
		if(Enseignant !=null) {
			return f.Add(Enseignant);
		}
		return Enseignant;
	}
	
	@GetMapping("/get")
	Collection<Enseignant> listeEnseignant() {
		
			return f.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Enseignant Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	

	@PutMapping("/edit")  
	public void Update(@RequestBody Enseignant e){

		f.Edit(e);
	}
	
	/*@DeleteMapping("/delete")
	public void deleteEnseignant(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	
	@PutMapping("/update")
	Enseignant Update (@RequestBody Enseignant e) {
		
		long id = e.getMatricule();
		String nom = e.getNomENS();
		String prenom = e.getPrenomENS();
		String adresse =e.getAdresseENS();
		String diplome = e.getDiplome();
		
		
		if(f.findId(id)==true) {
			Enseignant ens =new Enseignant (id,nom,prenom,adresse,diplome);
			
			return  f.Edit(ens);
			}
		else {
			return null;}
		}*/
	
}
