import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {CrudService} from 'src/app/services/crudservice.service';
import { Enseignant } from 'src/app/models/enseignant';
import { Departements } from 'src/app/models/departements';
import { Cours } from 'src/app/models/cours';
@Component({
  selector: 'app-edit-enseignant',
  templateUrl: './edit-enseignant.component.html',
  styleUrls: ['./edit-enseignant.component.scss']
})
export class EditEnseignantComponent implements OnInit {

  
  readonly apiUrl= ' http://localhost:8089/enseignant';
  readonly apiUrl2= ' http://localhost:8089/cours';
  readonly apiUrl3= ' http://localhost:8089/departement';
  public data = [];
  public data2 = [];

  selectedvalue:Departements;
  selectedvalue2:Cours;

  
  angForm: FormGroup;
  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditEnseignantComponent>,
    private CrudService:CrudService,
    @Inject(MAT_DIALOG_DATA) public data3: any) {
      this.createForm();
      this.getDepartements();
      this.getCours();
      console.log(this.data3);

     }


  
    createForm() {
      this.angForm = this.fb.group({
        matricul: ['', Validators.required],
        nomens: ['', Validators.required],
        prenomens: ['', Validators.required],
        adresseens: ['', Validators.required],
        diplom: ['', Validators.required],
        departements: new FormControl(null),
        cours: new FormControl(null)

      });
      this.angForm.setValue({

        matricul: this.data3.matricul ,
        nomens: this.data3.nomens ,
        prenomens: this.data3.prenomens ,
        adresseens: this.data3.adresseens,
        diplom: this.data3.diplom,
        cours:this.data,
        departements:this.data2,
      });
    }
    getSelecteddepartements(): Departements {
      return this.angForm ? this.angForm.get('departements').value : '';
    }
   
    getSelectedcours(): Cours {
      return this.angForm ? this.angForm.get('cours').value : '';
    }
    getDepartements(){
      this.CrudService.getList(this.apiUrl3).subscribe(
        result=>{this.data2=result
        console.log(this.data2)
        }
      );
    }
      getCours(){
        this.CrudService.getList(this.apiUrl2).subscribe(
          result=>{this.data=result
          console.log(this.data)
          }
        );
        }    
    edit(form){
      let enseignant :Enseignant;
      enseignant  = new Enseignant(form.nomens,form.prenomens,form.adresseens,form.diplom,this.getSelecteddepartements(),this.getSelectedcours());  
      let body = JSON.stringify({ form });            
      this.CrudService.edit(this.apiUrl,form).subscribe(
        result=>console.log("post :"+result)
      );
    }
onClose(){
  this.dialogRef.close();
 
}
ngOnInit() {
console.log(this.data3);
}
}