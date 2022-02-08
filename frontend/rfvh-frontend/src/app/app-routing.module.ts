import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login/login.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { VolunteerCreateComponent } from './volunteers/volunteer-create/volunteer-create.component';
import { VolunteerListComponent } from './volunteers/volunteer-list/volunteer-list.component';
import { AuthGuardService } from './authentication/services/authguard.service';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService], children: [
    { path: 'profile', component: ProfileComponent},
    { path: '', redirectTo: '/home/profile', pathMatch: 'full'}
  ]},
  { path: 'volunteers', component: VolunteerListComponent },
  { path: 'addVolunteer', component: VolunteerCreateComponent },
  { path: '', redirectTo: '/home/profile', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
