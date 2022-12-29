import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-facility-edit-form',
  templateUrl: './facility-edit-form.component.html',
  styleUrls: ['./facility-edit-form.component.css']
})
export class FacilityEditFormComponent implements OnInit {

  facilityForm: FormGroup = new FormGroup({});
  regexNumber: RegExp = /[0-9]*/;
  constructor(private formBuilder: FormBuilder) {
    this.facilityForm = formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      cost: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      maxPeople: ['', [Validators.required, Validators.min(0), Validators.pattern(this.regexNumber)]],
      facilityType: ['', [Validators.required]],
      rentType: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  submitFacility() {

  }
}
