import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AjouterEtudiantComponent } from './component/etudiant/ajouter-etudiant/ajouter-etudiant.component';
import { CommonModule } from '@angular/common';
import { ListEtudiantComponent } from './component/etudiant/list-etudiant/list-etudiant.component';
import { ListUniversiteComponent } from './component/universite/list-universite/list-universite.component';
import { AjouterUniversiteComponent } from './component/universite/ajouter-universite/ajouter-universite.component';
import { AjouterCoursComponent } from './component/cours/ajouter-cours/ajouter-cours.component';
import { ListCoursComponent } from './component/cours/list-cours/list-cours.component';
import { AjouterSalleComponent } from './component/salle/ajouter-salle/ajouter-salle.component';
import { ListSalleComponent } from './component/salle/list-salle/list-salle.component';
import { ListDepartmentComponent } from './component/department/list-department/list-department.component';
import { AjouterDepartmentComponent } from './component/department/ajouter-department/ajouter-department.component';
import { AjouterEnseignantComponent } from './component/enseignant/ajouter-enseignant/ajouter-enseignant.component';
import { ListEnseignantComponent } from './component/enseignant/list-enseignant/list-enseignant.component';
import { DashComponent } from './component/dash/dash.component';

const routes: Routes = [

  { path: 'Ajouteretu', component: AjouterEtudiantComponent },
  { path: 'Listetu', component: ListEtudiantComponent },
  { path: 'Listuniv', component: ListUniversiteComponent },
  { path: 'Adduniv', component: AjouterUniversiteComponent },
  { path: 'Addcours', component: AjouterCoursComponent },
  { path: 'Listcour', component: ListCoursComponent },
  { path: 'Addsalle', component: AjouterSalleComponent },
  { path: 'Listsalle', component: ListSalleComponent },
  { path: 'Adddep', component: AjouterDepartmentComponent },
  { path: 'Listdep', component: ListDepartmentComponent },
  { path: 'Addens', component: AjouterEnseignantComponent },
  { path: 'Listens', component: ListEnseignantComponent },
  { path: 'dash', component: DashComponent },



];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }

