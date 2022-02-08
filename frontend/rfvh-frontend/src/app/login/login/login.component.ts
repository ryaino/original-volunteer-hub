import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  interval: any;

  loginForm = new FormGroup({
    email: new FormControl('',[Validators.required, Validators.email]),
    password: new FormControl('',Validators.required)
  });

  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnDestroy(): void {
    clearInterval(this.interval);
  }

  ngOnInit(): void {
    // run every 500ms
  this.interval =  setInterval(() => this.navigate(), 2000);
    // use clearInterval(this.interval) to stop
  }


  get email(){
    return this.loginForm.get('email');
  }
  get password(){
    return this.loginForm.get('password');
  }

  async submit(){
    if(!this.loginForm.valid){
      return;
    }
    const{email,password} = this.loginForm.value;
    await this.authService.login(email,password);


      }

  navigate(){
   this.authService.isAuthenticated().then(res =>{
     if(res){
        this.router.navigateByUrl('/home/profile');

     }
   })

  }


}
