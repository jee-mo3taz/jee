import { Cours } from './cours';

export class Etudiant {

  private _nometu: String;
  public get nometu(): String {
    return this._nometu;
  }
  public set nometu(value: String) {
    this._nometu = value;
  }
  private _adresseetu: String;
  public get adresseetu(): String {
    return this._adresseetu;
  }
  public set adresseetu(value: String) {
    this._adresseetu = value;
  }
  private _prenometu: String;
  public get prenometu(): String {
    return this._prenometu;
  }
  public set prenometu(value: String) {
    this._prenometu = value;
  }
  private _dateentee: Date;
  public get dateentee(): Date {
    return this._dateentee;
  }
  public set dateentee(value: Date) {
    this._dateentee = value;
  }
  private _cours: Cours;
  public get cours(): Cours {
    return this._cours;
  }
  public set cours(value: Cours) {
    this._cours = value;
  }
  constructor(nometu:String,prenometu:String,adresseetu:String,dateentee:Date,cours:Cours){
this._adresseetu=adresseetu;
this._nometu=nometu;
this._prenometu=prenometu;
this._dateentee=dateentee;
this._cours=cours;


  }


 }
