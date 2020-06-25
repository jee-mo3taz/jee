import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Salle } from 'src/app/models/salle';
import { Cours } from 'src/app/models/cours';
@Component({
  selector: 'app-ajouter-cours',
  templateUrl: './ajouter-cours.component.html',
  styleUrls: ['./ajouter-cours.component.scss']
})
export class AjouterCoursComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/cours';
  readonly apiUrl2= ' http://localhost:8089/salle';
  public data = [];
  selectedvalue:Salle;
  angForm: FormGroup;
  constructor(private CrudService:CrudService,private fb: FormBuilder,) { 
    this.createForm();
 this.getSalle();
    console.log(this.getSelectedSalle()); 

  }
  createForm() {
    this.angForm = this.fb.group({
      libelle: ['', Validators.required],
      salle: new FormControl(null)

    });
  }
   getSelectedSalle(): Salle {
    return this.angForm ? this.angForm.get('salle').value : '';
  }
  getSalle(){
    this.CrudService.getList(this.apiUrl2).subscribe(
      result=>{this.data=result
      console.log(this.data)
      }
    );
  } 
  add(form){
    let cours :Cours;
    cours  = new Cours(form.libelle,this.getSelectedSalle());  
    let body = JSON.stringify({ cours });            
    this.CrudService.add(this.apiUrl,cours).subscribe(
      result=>console.log("post :"+result)
    );
  }
  ngOnInit() {

  }
}