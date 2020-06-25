import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Cours } from 'src/app/models/cours';
import { Salle } from 'src/app/models/salle';
@Component({
  selector: 'app-ajouter-salle',
  templateUrl: './ajouter-salle.component.html',
  styleUrls: ['./ajouter-salle.component.scss']
})
export class AjouterSalleComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/cours';
  readonly apiUrl2= ' http://localhost:8089/salle';
  public data = [];
  selectedvalue:Cours;
  angForm: FormGroup;
  constructor(private CrudService:CrudService,private fb: FormBuilder,) { 
    this.createForm();
/*     this.getCours();
    console.log(this.getSelectedCours()); */

  }
  createForm() {
    this.angForm = this.fb.group({
      nomS: ['', Validators.required],
      capacite: ['', Validators.required],
     // cours: new FormControl(null)
    });
  }
/*   getSelectedCours(): Cours {
    return this.angForm ? this.angForm.get('cours').value : '';
  }
  getCours(){
    this.CrudService.getList(this.apiUrl).subscribe(
      result=>{this.data=result
      console.log(this.data)
      }
    );
  } */
  add(form){
    let salle :Salle;
    salle  = new Salle(form.nomS,form.capacite,null);  
    let body = JSON.stringify({ salle });            
    this.CrudService.add(this.apiUrl2,salle).subscribe(
      result=>console.log("post :"+result)
    );
  }
  ngOnInit() {

  }
}