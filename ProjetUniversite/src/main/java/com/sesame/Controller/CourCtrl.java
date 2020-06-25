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

import com.sesame.DAO.Cours;
import com.sesame.DAO.Departements;
import com.sesame.DAO.Enseignant;
import com.sesame.DAO.Universite;
import com.sesame.Interface.CourInterface;

@RestController
@RequestMapping("/cours")
@CrossOrigin("*")
public class CourCtrl {

	@Autowired
	private CourInterface f;
	
	@PostMapping("/add")
	Cours ajoutCour(@RequestBody Cours cours) {
		
		if(cours !=null) {
			return f.Add(cours);
		}
		return cours;
	}
	
	@GetMapping("/get")
	Collection<Cours> listeCours() {
		
			return f.getAll();	
	}
	@GetMapping("/getcs")
	Collection<Object> listeCourssalle() {
		
			return f.findAllCoursBySalle();
	}
	@GetMapping("/get/{id}")
	public Cours Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	

	@PutMapping("/edit")  
	public void Update(@RequestBody Cours c){
		
		f.Edit(c);
	}
	
	/*@DeleteMapping("/delete")
	public void deleteCour(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	
	@PutMapping("/update")
	Cour Update (@RequestBody Cour c) {
		
		long id = c.getCodeC();
		String libelle = c.getLibelleC();
		
		
		
		if(f.findId(id)==true) {
			Cour cours =new Cour(id,libelle);
			
			return  f.Edit(cours);
			}
		else {
			return null;}
		}*/
	

}
