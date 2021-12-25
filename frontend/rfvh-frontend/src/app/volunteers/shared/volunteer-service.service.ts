import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Volunteer } from './volunteer.model';


@Injectable({
  providedIn: 'root'
})
export class VolunteerService {

  private volunteerUrl: string;

  constructor(private http: HttpClient) {
    this.volunteerUrl = 'http://localhost:8080/volunteers';
  }

  public findAll(): Observable<Volunteer[]>{
    return this.http.get<Volunteer[]>(this.volunteerUrl);
  }

  public save(volunteer: Volunteer){
    return this.http.post<Volunteer>(this.volunteerUrl,volunteer);
  }
}
