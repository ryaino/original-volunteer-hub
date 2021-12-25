import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { VolunteerCreateComponent } from './volunteers/volunteer-create/volunteer-create.component';
import { VolunteerListComponent } from './volunteers/volunteer-list/volunteer-list.component';
import { VolunteerService } from './volunteers/shared/volunteer-service.service';

@NgModule({
  declarations: [
    AppComponent,
    VolunteerListComponent,
    VolunteerCreateComponent
  ],
  imports: [
     BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [VolunteerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
