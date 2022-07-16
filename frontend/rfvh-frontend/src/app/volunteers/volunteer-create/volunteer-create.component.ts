import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Volunteer } from 'src/app/volunteers/shared/volunteer.model';
import { VolunteerService } from '../shared/volunteer-service.service';

/**
 * Create a new volunteer
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Component({
  selector: 'app-volunteer-create',
  templateUrl: './volunteer-create.component.html',
  styleUrls: ['./volunteer-create.component.scss']
})
export class VolunteerCreateComponent implements OnInit{

    volunteer: Volunteer;

    ngOnInit(): void {
      this.volunteerService.getAddVolunteer().subscribe(data => {
      })
  }

  constructor(
    private route: ActivatedRoute, private router: Router, private volunteerService: VolunteerService) {
    this.volunteer = new Volunteer();
  }

  onSubmit() {
    this.volunteerService.save(this.volunteer).subscribe(result => this.goToVolunteerList());
  }

  goToVolunteerList() {
    this.router.navigate(['/volunteers']);
  }
}
