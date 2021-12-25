import { Component, OnInit } from '@angular/core';
import { Volunteer } from 'src/app/volunteers/shared/volunteer.model';
import { VolunteerService } from '../shared/volunteer-service.service';

/**
 * create a list of all volunteers
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Component({
  selector: 'app-volunteer-list',
  templateUrl: './volunteer-list.component.html',
  styleUrls: ['./volunteer-list.component.scss']
})
export class VolunteerListComponent implements OnInit {

  volunteers: Volunteer[] = [];

  constructor(private volunteerService: VolunteerService) { }

  ngOnInit(): void {
    this.volunteerService.findAll().subscribe(data => {
      this.volunteers = data;
    })
  }

}
