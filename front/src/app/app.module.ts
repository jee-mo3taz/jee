import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AjouterDepartmentComponent } from './component/department/ajouter-department/ajouter-department.component';
import { EditDepartmentComponent } from './component/department/edit-department/edit-department.component';
import { ListDepartmentComponent } from './component/department/list-department/list-department.component';
import { AjouterEnseignantComponent } from './component/enseignant/ajouter-enseignant/ajouter-enseignant.component';
import { EditEnseignantComponent } from './component/enseignant/edit-enseignant/edit-enseignant.component';
import { ListEnseignantComponent } from './component/enseignant/list-enseignant/list-enseignant.component';
import { AjouterEtudiantComponent } from './component/etudiant/ajouter-etudiant/ajouter-etudiant.component';
import { EditEtudiantComponent } from './component/etudiant/edit-etudiant/edit-etudiant.component';
import { ListEtudiantComponent } from './component/etudiant/list-etudiant/list-etudiant.component';
import { AjouterSalleComponent } from './component/salle/ajouter-salle/ajouter-salle.component';
import { EditSalleComponent } from './component/salle/edit-salle/edit-salle.component';
import { ListSalleComponent } from './component/salle/list-salle/list-salle.component';
import { AjouterCoursComponent } from './component/cours/ajouter-cours/ajouter-cours.component';
import { EditCoursComponent } from './component/cours/edit-cours/edit-cours.component';
import { ListCoursComponent } from './component/cours/list-cours/list-cours.component';
import { AjouterUniversiteComponent } from './component/universite/ajouter-universite/ajouter-universite.component';
import { EditUniversiteComponent } from './component/universite/edit-universite/edit-universite.component';
import { ListUniversiteComponent } from './component/universite/list-universite/list-universite.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import { DatePipe } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { CrudService } from './services/crudservice.service';
import { DashComponent } from './component/dash/dash.component';
import { ChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [

    AppComponent,
  
    AjouterDepartmentComponent,
    EditDepartmentComponent,
    ListDepartmentComponent,
    AjouterEnseignantComponent,
    EditEnseignantComponent,
    ListEnseignantComponent,
    AjouterEtudiantComponent,
    EditEtudiantComponent,
    ListEtudiantComponent,
    AjouterSalleComponent,
    EditSalleComponent,
    ListSalleComponent,
    AjouterCoursComponent,
    EditCoursComponent,
    ListCoursComponent,
    AjouterUniversiteComponent,
    EditUniversiteComponent,
    ListUniversiteComponent,
    DashComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatDialogModule,
    MatFormFieldModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,MatInputModule, AppRoutingModule, 
    MatDatepickerModule,MatNativeDateModule,ChartsModule
    

  ],
  providers: [CrudService,ListEtudiantComponent,ListUniversiteComponent,ListCoursComponent],
  bootstrap: [AppComponent],
  entryComponents:[AjouterEtudiantComponent,AjouterUniversiteComponent,],
  schemas: [CUSTOM_ELEMENTS_SCHEMA ] 

})
export class AppModule { }
