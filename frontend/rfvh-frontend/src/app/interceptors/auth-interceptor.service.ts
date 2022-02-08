import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authentication/services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  urlsToNotUse: Array<string>;

  constructor(private auth: AuthenticationService) {
    this.urlsToNotUse= [
      'login',
    ];
  }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.isValidRequestForInterceptor(req.url)) {
    // Get the auth token from the service.
      const authToken = this.auth.getToken();
      console.log('intercepting request for: ' + req.url)

      // Clone the request and replace the original headers with
      // cloned headers, updated with the authorization.
      const authReq = req.clone({
        withCredentials : true
      });

      // send cloned request with header to the next handler.
      return next.handle(authReq);
    }
    return next.handle(req);
  }

  private isValidRequestForInterceptor(requestUrl: string): boolean {
    if(requestUrl === 'http://localhost:8080/login'){
      console.log(requestUrl)
      return false;
    }
    return true;
    // let positionIndicator: string = 'api/';
    // let position = requestUrl.indexOf(positionIndicator);
    // if (position > 0) {
    //   let destination: string = requestUrl.substr(position + positionIndicator.length);
    //   for (let address of this.urlsToNotUse) {
    //     if (new RegExp(address).test(destination)) {
    //       return false;
    //     }
    //   }
    // }
    // return true;
  }
}
