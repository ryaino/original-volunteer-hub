import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { VolunteerCreateComponent } from './volunteers/volunteer-create/volunteer-create.component';
import { VolunteerListComponent } from './volunteers/volunteer-list/volunteer-list.component';
import { VolunteerService } from './volunteers/shared/volunteer-service.service';
import { LoginComponent } from './login/login/login.component';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { firebaseConfig } from '../resources/firebaseConfig';
import { provideAuth,getAuth, Persistence } from '@angular/fire/auth';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { CookieModule } from 'ngx-cookie';
import { AuthInterceptorService } from './interceptors/auth-interceptor.service';
import { CookieService } from 'ngx-cookie-service';
import { ProfileComponent } from './profile/profile/profile.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    VolunteerListComponent,
    VolunteerCreateComponent,
    LoginComponent,
    ProfileComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    provideFirebaseApp(() => initializeApp(firebaseConfig)),
    provideAuth(() => getAuth()),
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    CookieModule.forRoot()

  ],
  providers: [VolunteerService,
            { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
              CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
