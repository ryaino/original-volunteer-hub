import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerCreateComponent } from './volunteer-create.component';

describe('VolunteerCreateComponent', () => {
  let component: VolunteerCreateComponent;
  let fixture: ComponentFixture<VolunteerCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VolunteerCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VolunteerCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
