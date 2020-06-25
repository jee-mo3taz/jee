import { Departements } from './departements';
import { Cours } from './cours';

export class Enseignant {
  constructor(
	private nomens: String,
	private prenomens: String,
   private adresseens: String,
   private diplom: String ,
   private cours: Cours,
   private departements: Departements){

   }
  
}
