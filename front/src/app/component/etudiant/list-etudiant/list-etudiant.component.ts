import { Component, OnInit,ViewChild  } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatDialog,MatDialogConfig}from '@angular/material/dialog';
import { AjouterEtudiantComponent } from '../ajouter-etudiant/ajouter-etudiant.component';
import { EditEtudiantComponent } from '../edit-etudiant/edit-etudiant.component';
import { CrudService } from 'src/app/services/crudservice.service';

@Component({
  selector: 'app-list-etudiant',
  templateUrl: './list-etudiant.component.html',
  styleUrls: ['./list-etudiant.component.scss']
})
export class ListEtudiantComponent implements OnInit {

  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['numinsc','nometu', 'prenometu','adresseetu','dateentee','cours', 'actions'];
   sort: MatSort;
  paginator: MatPaginator;
  searchKey: string;
  public data = [];
  readonly apiUrl= ' http://localhost:8089/etudiant';


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
    this.matDialog.open(EditEtudiantComponent,DialogConfig); 
    this.matDialog.afterAllClosed.subscribe(result => {
      this.refershEtudiantList();
    });
    
  }

  onDelete(numinsc){
    this.CrudService.delete(this.apiUrl,numinsc)
      .subscribe(
        data => {
          console.log(data);
          this.refershEtudiantList();
        },
        error => console.log(error));
    }

  
}