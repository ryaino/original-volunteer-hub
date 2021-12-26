import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Auth } from '@angular/fire/auth';
import { signInWithEmailAndPassword } from 'firebase/auth';
import { CookieService } from 'ngx-cookie';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private  idToken: string;

  constructor(private auth: Auth, private http:  HttpClient, public cookie: CookieService) { }

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
        })
      }
      return this.http.post('http://localhost:8080/sessionLogin',null,httpOptions).subscribe(()=>{
        console.log("posting")
      });

    }

    getToken(){
      return this.idToken;
    }
}
