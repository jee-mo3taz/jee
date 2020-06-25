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


import com.sesame.DAO.Departements;
import com.sesame.DAO.Enseignant;
import com.sesame.Interface.DepartementInterface;

@RestController
@RequestMapping("/departement")
@CrossOrigin("*")
public class DepartementCtrl {

	@Autowired
	private DepartementInterface f;
	
	@PostMapping("/add")
	Departements ajoutDepartement(@RequestBody Departements dep) {
		
		if(dep !=null) {
			return f.Add(dep);
		}
		return dep;
	}
	
	@GetMapping("/get")
	Collection<Departements> listeDepartements() {
		
			return f.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Departements Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	

	@PutMapping("/edit")  
	public void Update(@RequestBody Departements d){
		
		
		f.Edit(d);
	}
	
	/*
	@DeleteMapping("/delete")
	public void deleteDep(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}
	
	@PutMapping("/update")
	Departement Update (@RequestBody Departement d) {
		
		long id = d.getCodeDEP();
		String nom = d.getNomDEP();
		
		
		if(f.findId(id)==true) {
			Departement dep =new Departement(id,nom);
			
			return  f.Edit(dep);
			}
		else {
			return null;}
		}*/
	
}
