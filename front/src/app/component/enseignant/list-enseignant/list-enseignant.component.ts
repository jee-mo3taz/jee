import { Component, OnInit,ViewChild  } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatDialog,MatDialogConfig}from '@angular/material/dialog';
import { CrudService } from 'src/app/services/crudservice.service';
import { EditDepartmentComponent } from '../../department/edit-department/edit-department.component';
import { EditEnseignantComponent } from '../edit-enseignant/edit-enseignant.component';
@Component({
  selector: 'app-list-enseignant',
  templateUrl: './list-enseignant.component.html',
  styleUrls: ['./list-enseignant.component.scss']
})
export class ListEnseignantComponent implements OnInit {

  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['matricul','nomens', 'prenomens','adresseens' ,'diplom','cours','actions'];
   sort: MatSort;
  paginator: MatPaginator;
  searchKey: string;
  public data = [];
  readonly apiUrl= ' http://localhost:8089/enseignant';


  constructor(private CrudService:CrudService,
    private matDialog:MatDialog,private matDialog2:MatDialog ) { 
      this.matDialog.afterAllClosed.subscribe(result => {
        this.refershEtudiantList();
      });
      this.matDialog2.afterAllClosed.subscribe(result => {
        this.refershEtudiantList();
      });
    }

  ngOnInit() {
    this.refershEtudiantList();
    this.matDialog.afterAllClosed.subscribe(result => {
      this.refershEtudiantList();
    });
    this.matDialog2.afterAllClosed.subscribe(result => {
      this.refershEtudiantList();
    });
    
  }
  refershEtudiantList(){
    this.CrudService.getList(this.apiUrl).subscribe((results) =>  {
      this.data = results;
      this.listData = new MatTableDataSource(this.data);
      console.log("data =" + JSON.stringify(results));
      console.log("nb "+this.data.length);
    })
    
  }
  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }
   getList(){
    return this.CrudService.getList(this.apiUrl).subscribe(result => {this.data=result,console.log("data =",this.data);});
   }

  onEdit(row){

    const DialogConfig = new MatDialogConfig();
    DialogConfig.disableClose=true;
    DialogConfig.autoFocus=true;
    DialogConfig.width="40%";
    DialogConfig.data=row;
    this.matDialog.open(EditEnseignantComponent,DialogConfig); 
    this.matDialog.afterAllClosed.subscribe(result => {
      this.refershEtudiantList();
    });
    
  }

  onDelete(codedep){
    this.CrudService.delete(this.apiUrl,codedep)
      .subscribe(
        data => {
          console.log(data);
          this.refershEtudiantList();
        },
        error => console.log(error));
    }

  
}
