package com.sesame.Controller;

import java.util.Collection;

import javax.validation.Valid;

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

import com.sesame.DAO.Universite;
import com.sesame.Interface.UniversiteInterface;

@RestController
@RequestMapping("/universite")
@CrossOrigin("*")
public class UniversiteCtrl {

	@Autowired
	private UniversiteInterface f;
	
	@PostMapping("/add")
	public Universite ajoutUniversite(@RequestBody Universite universite) {
		
		if(universite !=null) {
			return f.Add(universite);
		}
		return universite;
	}
	
	@GetMapping("/get")
	public Collection<Universite> listeUniversite() {
		
			return f.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Universite Afficher(@PathVariable long id) {
		
		return f.getId(id);
	}

	
	
	/*@DeleteMapping("/delete")
	public void deleteUniversity(@RequestParam long id) {
		
		if(f.findId(id)==true) {
			 f.Delete(id);
		}
	}*/
	@DeleteMapping("/delete/{id}")
	public void Supprimer(@PathVariable Long id) {
	
		f.Delete(id);
	}

	@PutMapping("/edit")  
	public void Update(@RequestBody Universite u){
		
		f.Edit(u);
			
	}

	
	/*@PutMapping("/update")  
	public void Update(@RequestBody Universite u){
		
		Long id = u.getCodeUNV();
		u.setCodeUNV(id);
		f.Add(u);
	}*/
	
	/*@PutMapping("/update")
	Universite Update (@RequestBody Universite c) {
		
		long id=c.getCodeUNV();
		String adr=c.getAdresseUNV();
		String nom=c.getNomUNV();

		
		if(f.findId(id)==true) {
			Universite u=new Universite(id,nom,adr);
			
			return  f.Edit(c);
			}
		else {
			return null;}
		}*/
	
	
}
