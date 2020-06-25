package com.sesame.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Etudiant;
import com.sesame.Interface.EtudiantInterface;
import com.sesame.Repository.EtudiantRepository;

@Service
public class EtudiantService implements EtudiantInterface{
	@Autowired
	private EtudiantRepository etud;
	@Transactional
	@Override
	public Collection<Etudiant> getAll() {
		// TODO Auto-generated method stub
		return etud.findAll();
	}

	@Override
	public Etudiant getId(Long id) {
		// TODO Auto-generated method stub
		return etud.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
	etud.deleteById(id);	
	}

	@Override
	public Etudiant Add(Etudiant c) {
		// TODO Auto-generated method stub
		return etud.save(c);
	}

	@Override
	public Etudiant Edit(Etudiant c) {
		// TODO Auto-generated method stub
		return etud.saveAndFlush(c);
	}

	@Override
	public Boolean findId(Long id) {
		// TODO Auto-generated method stub
		boolean res=false;
		if (etud.findByNuminsc(id)==null){
				res=false;	
				}
		else {
		res=true;
		}
		return res;
	}
}
