import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Cours } from 'src/app/models/cours';
import { Etudiant } from 'src/app/models/etudiant';
@Component({
  selector: 'app-ajouter-etudiant',
  templateUrl: './ajouter-etudiant.component.html',
  styleUrls: ['./ajouter-etudiant.component.scss']
})
export class AjouterEtudiantComponent implements OnInit {

  angForm: FormGroup;
  readonly apiUrl= ' http://localhost:8089/etudiant';
  readonly apiUrl2= ' http://localhost:8089/cours';
  public data = [];
  selectedvalue:Cours;




  constructor(private fb: FormBuilder,
    private CrudService:CrudService,
    ) {
      this.createForm();
      this.getCours();

     }
     createForm() {
      this.angForm = this.fb.group({
        nometu: ['', Validators.required],
        prenometu: ['', Validators.required],
        adresseetu: ['', Validators.required],
        dateentee : ['', Validators.required],
        cours: new FormControl(null)


      });
    }
    getSelectedcours(): Cours {
      return this.angForm ? this.angForm.get('cours').value : '';
    }

    getCours(){
      this.CrudService.getList(this.apiUrl2).subscribe(
        result=>{this.data=result
        console.log(this.data)
        }
      );
  }
  add(form){
    let etudiant :Etudiant;
    etudiant  = new Etudiant(form.nometu,form.prenometu,form.adresseetu,form.dateentee,this.getSelectedcours());  
    let body = JSON.stringify({ etudiant });            
    this.CrudService.add(this.apiUrl,etudiant).subscribe(
      result=>console.log("post :"+result) 
      );
    }
    ngOnInit() {
      this.getCours();
  
    } 
  }