import { Injectable } from '@angular/core';
import  { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 
  
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getEmployee(empId: number): Observable<any>{
    var url = this.baseUrl +'/'+ empId; 
    return this.http.get(url);
  }
  createEmployee(employee: object): Observable<Object>{
    var url = this.baseUrl + '/employees';
    return this.http.post(url, employee);
  }
  updateEmployee(empId: number, value: any): Observable<Object>{
    var url = this.baseUrl +'/'+ empId;
    return this.http.put(url,value);
  }
  deleteEmployee(empId: number): Observable<any>{
    var url = this.baseUrl +'/'+ empId; 
    return this.http.delete(url, {responseType: 'text'});
  }
  getEmployeesList(): Observable<any>{
    var url = this.baseUrl + '/employees'; 
    return this.http.get(url);
  }
 
  getNextId() {
    var url = this.baseUrl + '/nextId'; 
    return this.http.get(url);
  }
}
