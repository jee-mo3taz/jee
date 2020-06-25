import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Salle } from 'src/app/models/salle';
@Component({
  selector: 'app-edit-cours',
  templateUrl: './edit-cours.component.html',
  styleUrls: ['./edit-cours.component.scss']
})
export class EditCoursComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/cours';
  readonly apiUrl2= ' http://localhost:8089/salle';
  public data = [];
  selectedvalue:Salle;
  
  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditCoursComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data1: any) {
      this.createForm();
      this.getSalle();
     }


  
    createForm() {
      this.angForm = this.fb.group({
        code_C: ['',],
        libelle: ['', Validators.required],
        salle: new FormControl(null)


      });
      this.angForm.setValue({

        code_C: this.data1.code_C ,
        libelle: this.data1.libelle ,
        salle:this.data,
       

      });
    }
    getSelectedSalle(): Salle {
      return this.angForm ? this.angForm.get('salle').value : '';
    }
    getSalle(){
      this.CrudService.getList(this.apiUrl2).subscribe(
        result=>{this.data=result
        console.log("get s "+this.data)
        }
      );
    } 
    
edit(angForm){
  this.CrudService.edit(this.apiUrl,angForm.value).subscribe(
    res =>console.log("res"+res)
  );
}
onClose(){
  this.dialogRef.close();
 
}
ngOnInit() {
console.log(this.data);
}
}



