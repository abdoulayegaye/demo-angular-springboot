import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Payment, Student} from "../models/students.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http: HttpClient) { }

  public getAllPayments() : Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.BACKEND_HOST}/payments`);
  }

  public getAllStudents() : Observable<Array<Student>>{
    return this.http.get<Array<Student>>(`${environment.BACKEND_HOST}/students`);
  }
}
