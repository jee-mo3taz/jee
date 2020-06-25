import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
@Component({
  selector: 'app-ajouter-universite',
  templateUrl: './ajouter-universite.component.html',
  styleUrls: ['./ajouter-universite.component.scss']
})
export class AjouterUniversiteComponent implements OnInit {

  angForm: FormGroup;
  readonly apiUrl= ' http://localhost:8089/universite';
  constructor(private fb: FormBuilder,
     private CrudService:CrudService,
    ) {
      this.createForm();
     }
    createForm() {
      this.angForm = this.fb.group({
        nomuniv: ['', Validators.required],
        adresseSite: ['', Validators.required],        
        
       });
      }
     /* add(nomuniv,ardesseSite){
        const obj = {
          "nomuniv": nomuniv, 
          "ardesseSite": ardesseSite,
      }; */
      add(angForm){
      this.CrudService.add(this.apiUrl,angForm ).subscribe( 
        data =>console.log(data)
      );  
    //  this.gotoList();

    }
 ngOnInit() {
 }

}
