import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Auth } from '@angular/fire/auth';
import { signInWithEmailAndPassword } from 'firebase/auth';
import {  CookieService } from 'ngx-cookie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private auth: Auth, private http:  HttpClient, public cookie: CookieService) { }

  login(email: string, password: string){
    signInWithEmailAndPassword(this.auth, email, password)
      .then((userCredential) => {
        // Signed in
        const user = userCredential.user;

        return user.getIdToken().then(idToken => {
          const csrfToken = this.cookie.get('csrfToken');
          return this.postIdTokenToSessionLogin(idToken,csrfToken);
        })
        // ...
      })
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
      });
    }

    postIdTokenToSessionLogin(idToken: string, csrfToken: string){
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          Authorization: idToken,
        })
      }
      return this.http.get('http://localhost:8080/sessionLogin',httpOptions).subscribe(()=>{
        console.log('trying to post');
      });

    }
}
