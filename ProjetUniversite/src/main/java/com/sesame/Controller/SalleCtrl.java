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
import com.sesame.DAO.Universite;
import com.sesame.Interface.SalleInterface;

@RestController
@RequestMapping("/salle")
@CrossOrigin("*")
public class SalleCtrl {

	@Autowired
	private SalleInterface f;
	
	@PostMapping("/add")
	Salle ajoutSalle(@RequestBody Salle Salle) {
		
		if(Salle !=null) {
			return f.Add(Salle);
		}
		return Salle;
	}
	
	@GetMapping("/get")
	Collection<Salle> listeSalle() {
		
			return f.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Salle Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		f.Delete(id);
	}
	

	@PutMapping("/edit")  
	public void Update(@RequestBody Salle s){
		
	f.Edit(s);
	}
	
	/*@DeleteMapping("/delete")
	public void deleteSalle(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	
	@PutMapping("/update")
	Salle Update (@RequestBody Salle s) {
		
		long id = s.getNumS();
		long capacite =s.getCapacite();
		String nom = s.getNomS();
		
		if(f.findId(id)==true) {
			Salle salle =new Salle (id,nom,capacite);
			
			return  f.Edit(salle);
			}
		else {
			return null;}
		}*/
	
}
