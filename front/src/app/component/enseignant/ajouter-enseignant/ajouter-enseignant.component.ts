import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Departements } from 'src/app/models/departements';
import { Cours } from 'src/app/models/cours';
import { Enseignant } from 'src/app/models/enseignant';
@Component({
  selector: 'app-ajouter-enseignant',
  templateUrl: './ajouter-enseignant.component.html',
  styleUrls: ['./ajouter-enseignant.component.scss']
})
export class AjouterEnseignantComponent implements OnInit {

 
  readonly apiUrl= ' http://localhost:8089/enseignant';
  readonly apiUrl2= ' http://localhost:8089/cours';
  readonly apiUrl3= ' http://localhost:8089/departement';
  public data = [];
  public data2 = [];

  selectedvalue:Departements;
  selectedvalue2:Cours;

  angForm: FormGroup;
  
  constructor(private CrudService:CrudService,private fb: FormBuilder,) { 
    this.createForm();
    this.getDepartements();
    this.getCours();


    console.log(this.getSelecteddepartements());
 console.log(this.getSelectedcours());


  }
 
 
     createForm() {
      this.angForm = this.fb.group({
    
        codeens: ['', Validators.required],
        nomens: ['', Validators.required],
        prenomens: ['', Validators.required],
        adresseens: ['', Validators.required],
        diplom: ['', Validators.required],
        departement: new FormControl(null),
        cours: new FormControl(null)




            
        
      });
    }
    getSelecteddepartements(): Departements {
      return this.angForm ? this.angForm.get('departement').value : '';
    }
   
    getSelectedcours(): Cours {
      return this.angForm ? this.angForm.get('cours').value : '';
    }
    getDepartements(){
      this.CrudService.getList(this.apiUrl3).subscribe(
        result=>{this.data2=result
        console.log(this.data2)
        }
      );
    }
      getCours(){
        this.CrudService.getList(this.apiUrl2).subscribe(
          result=>{this.data=result
          console.log(this.data)
          }
        );
    }
    add(form){
      let enseignant :Enseignant;
      enseignant  = new Enseignant(form.nomens,form.prenomens,form.adresseens,form.diplom,this.getSelectedcours(),this.getSelecteddepartements());  
      let body = JSON.stringify({ enseignant });            
      this.CrudService.add(this.apiUrl,form).subscribe(
        result=>console.log("post :"+result) 
      );
    }
    ngOnInit() {
      this.getCours();
      this.getDepartements();
  
    } 
  }