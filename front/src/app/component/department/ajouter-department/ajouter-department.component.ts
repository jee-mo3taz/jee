import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Universite } from 'src/app/models/universite';
import { Departements} from 'src/app/models/departements';
@Component({
  selector: 'app-ajouter-department',
  templateUrl: './ajouter-department.component.html',
  styleUrls: ['./ajouter-department.component.scss']
})
export class AjouterDepartmentComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/universite';
  readonly apiUrl2= ' http://localhost:8089/departement';
  public data = [];
  selectedvalue:Universite;
  angForm: FormGroup;
  constructor(private CrudService:CrudService,private fb: FormBuilder,) { 
    this.createForm();
    this.getUniversite();
    console.log(this.getSelecteduniversites());

  }
  createForm() {
    this.angForm = this.fb.group({
      nomdep: ['', Validators.required],
      universite: new FormControl(null)
    });
  }
  getSelecteduniversites(): Universite {
    return this.angForm ? this.angForm.get('universite').value : '';
  }
  getUniversite(){
    this.CrudService.getList(this.apiUrl).subscribe(
      result=>{this.data=result
      console.log(this.data)
      }
    );
  }
  add(form){
    let departement :Departements;
    departement  = new Departements(form.nomdep,this.getSelecteduniversites());  
    let body = JSON.stringify({ departement });            
    this.CrudService.add(this.apiUrl2,departement).subscribe(
      result=>console.log("post :"+result)
    );
  }
  ngOnInit() {
    this.getUniversite();

  }
}
