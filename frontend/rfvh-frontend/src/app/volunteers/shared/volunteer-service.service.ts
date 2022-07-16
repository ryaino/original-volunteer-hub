import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Volunteer } from './volunteer.model';

/**
 * performs CRUD operations on the volunteers collection
 *
 * @author Ryan Field fieldryan19@gmail.com
 */
@Injectable({
  providedIn: 'root'
})
export class VolunteerService {

  private volunteerUrl: string;

  constructor(private http: HttpClient) {
    this.volunteerUrl = 'http://localhost:8080/api/volunteers';
  }

  public findAll(): Observable<Volunteer[]>{
    return this.http.get<Volunteer[]>(this.volunteerUrl,{withCredentials: true});
  }

  public save(volunteer: Volunteer){
    return this.http.post<Volunteer>(this.volunteerUrl,volunteer);
  }

  public getAddVolunteer(){
    return this.http.get('http://localhost:8080/api/addVolunteer');
  }
}
