import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }
  getList(apiUrl :string):Observable<any[]>{
    return this.http.get<any[]>(apiUrl +'/get/');
  }
  add(apiUrl :string,object :any){
   return this.http.post(`${apiUrl}/add`, object);
  }
  edit(apiUrl :string,object :any){
    return this.http.put(`${apiUrl}/edit`, object);
   }
   delete(apiUrl :string,id : number){
    return this.http.delete(apiUrl +'/delete/'+ id);
     }

}
