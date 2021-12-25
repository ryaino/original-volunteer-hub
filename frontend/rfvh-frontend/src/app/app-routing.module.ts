import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { VolunteerCreateComponent } from './volunteers/volunteer-create/volunteer-create.component';
import { VolunteerListComponent } from './volunteers/volunteer-list/volunteer-list.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  { path: 'volunteers', component: VolunteerListComponent },
  { path: 'addVolunteer', component: VolunteerCreateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
