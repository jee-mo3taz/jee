import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Cours } from 'src/app/models/cours';
import { Salle } from 'src/app/models/salle';

@Component({
  selector: 'app-edit-salle',
  templateUrl: './edit-salle.component.html',
  styleUrls: ['./edit-salle.component.scss']
})
export class EditSalleComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/salle';
  readonly apiUrl2= ' http://localhost:8089/cours';

  selectedvalue:Cours;
  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditSalleComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.createForm();

     }
   
     createForm() {
       this.angForm = this.fb.group({
        numS: ['', ],
         nomS: ['', Validators.required],
         capacite: ['', Validators.required],
       });
       this.angForm.setValue({

        numS: this.data.numS ,
        nomS: this.data.nomS,
        capacite: this.data.capacite ,
  
      });
     }

     edit(form){
       let salle :Salle;
       salle  = new Salle(form.nomS,form.capacite,null);  
       let body = JSON.stringify({ salle });            
       this.CrudService.edit(this.apiUrl,form).subscribe(
         result=>console.log("post :"+result)
       );
     }
     ngOnInit() {
   
     }
   }
