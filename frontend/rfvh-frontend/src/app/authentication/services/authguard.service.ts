import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  private authenticated: boolean = false;

  constructor(public authService: AuthenticationService, public router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

     this.authService.isAuthenticated().then(res =>{
      this.authenticated = res;


      if(!this.authenticated){
        this.router.navigate(['login']);
        console.log('not authenticated')
      }
        console.log('user is authenticated')
        return true;

      })
      return true;

  }

}
