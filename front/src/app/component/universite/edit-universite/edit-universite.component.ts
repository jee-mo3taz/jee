import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
@Component({
  selector: 'app-edit-universite',
  templateUrl: './edit-universite.component.html',
  styleUrls: ['./edit-universite.component.scss']
})
export class EditUniversiteComponent implements OnInit {
  readonly apiUrl= ' http://localhost:8089/universite';

  
  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditUniversiteComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.createForm();
     }


  
    createForm() {
      this.angForm = this.fb.group({
        codeuniv: ['',],
        nomuniv: ['', Validators.required],
        adresseSite: ['', Validators.required],

      });
      this.angForm.setValue({

        codeuniv: this.data.codeuniv ,
        nomuniv: this.data.nomuniv ,
        adresseSite: this.data.adresseSite ,
       

      });
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


