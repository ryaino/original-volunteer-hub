import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]>{
    return this.http.get<User[]>(this.userUrl);
  }

  public save(user: User){
    return this.http.post<User>(this.userUrl,user);
  }
}
