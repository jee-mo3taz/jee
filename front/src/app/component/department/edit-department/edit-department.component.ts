import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Universite } from 'src/app/models/universite';
import { Departements } from 'src/app/models/departements';
@Component({
  selector: 'app-edit-department',
  templateUrl: './edit-department.component.html',
  styleUrls: ['./edit-department.component.scss']
})
export class EditDepartmentComponent implements OnInit {

  
  readonly apiUrl= ' http://localhost:8089/universite';
  readonly apiUrl2= ' http://localhost:8089/departement';
  public data2= [];

  selectedvalue:Universite;
  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditDepartmentComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data: any) {   
       this.createForm();
    this.getUniversite();
    console.log(this.getSelecteduniversites());

  }
  createForm() {
    this.angForm = this.fb.group({
      codedep: ['',],
      nomdep: ['', Validators.required],
      universite: new FormControl(null)

    });
    this.angForm.setValue({

      codedep: this.data.codedep ,
      nomdep: this.data.nomdep ,
      universite:this.data2, 

    });
  }
  getSelecteduniversites(): Universite {
    return this.angForm ? this.angForm.get('universite').value : '';
  }
  getUniversite(){
    this.CrudService.getList(this.apiUrl).subscribe(
      result=>{this.data2=result
      console.log(this.data2)
      }
    );
  }
  
  
    
    
    edit(form){
      let departement :Departements;
      departement  = new Departements(form.nomdep,this.getSelecteduniversites());  
      let body = JSON.stringify({ departement });            
      this.CrudService.edit(this.apiUrl2,form.value).subscribe(
        result=>console.log("post :"+result)
      );
    }
onClose(){
  this.dialogRef.close();
 
}
ngOnInit() {
console.log(this.data);
}
}



