import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
@Component({
  selector: 'app-edit-etudiant',
  templateUrl: './edit-etudiant.component.html',
  styleUrls: ['./edit-etudiant.component.scss']
})
export class EditEtudiantComponent implements OnInit {

  readonly apiUrl= ' http://localhost:8089/etudiant';

  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditEtudiantComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.createForm();
     }


  
    createForm() {
      this.angForm = this.fb.group({
        numinsc: ['',],
        nometu: ['', Validators.required],
        prenometu: ['', Validators.required],
        adresseetu: ['', Validators.required],
        dateentee:['', Validators.required],
      });
      this.angForm.setValue({

        numinsc: this.data.numinsc ,
        nometu: this.data.nometu ,
        prenometu: this.data.prenometu ,
        adresseetu: this.data.adresseetu ,
        dateentee:this.data.dateentee,

      });
    }
    
    edit( angForm){

      this.CrudService.edit(this.apiUrl,angForm ).subscribe(
        data =>console.log(data)
      );
}
onClose(){
  this.dialogRef.close();
 
}
ngOnInit() {
console.log(this.data);
}
}

