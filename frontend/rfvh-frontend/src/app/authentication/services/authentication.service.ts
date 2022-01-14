import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FirebaseApp } from '@angular/fire/app';
import { Auth } from '@angular/fire/auth';
import { Router } from '@angular/router';
import {  Config, signInWithEmailAndPassword, signOut } from 'firebase/auth';
import { CookieService } from 'ngx-cookie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private  idToken: string  = '';

  constructor(private auth: Auth, private http:  HttpClient, public cookie: CookieService, private router: Router) { }

  login(email: string, password: string){
    signInWithEmailAndPassword(this.auth, email, password)
      .then((userCredential) => {
        // Signed in
        const user = userCredential.user;

        return user.getIdToken().then(idToken => {
          this.idToken = idToken;
          const csrfToken = this.cookie.get('csrfToken');
          return this.postIdTokenToSessionLogin(idToken,csrfToken);
        })
        // ...
      }).then(()=>{
        return this.auth.signOut();
      }).then(()=>{
        this.router.navigateByUrl('/volunteers');
      })
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
      });
    }

    postIdTokenToSessionLogin(idToken: string, csrfToken: string){
      return this.http.post<HttpResponse<Object>>("http://localhost:8080/api/sessionLogin", null,{ observe: "response", withCredentials: true,headers: new HttpHeaders({'Accept': 'application/json','Content-Type': 'application/json', 'Authorization': idToken}) })
          .subscribe((res: HttpResponse<Object>) => console.log(res.headers.get('set-cookie')));



    }

    getToken(){
      return this.idToken;
    }

    // postConfigResponse(): Observable<HttpResponse<any>> {
    //       return this.http.post<any>(
    //     'http://localhost:8080/api/sessionLogin', { observe: 'response', withCredentials: true });
    // }
}
