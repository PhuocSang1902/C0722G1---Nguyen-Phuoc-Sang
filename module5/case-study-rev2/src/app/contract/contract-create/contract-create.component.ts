import {Component, OnInit} from '@angular/core';
import {differenceInDays, differenceInYears} from 'date-fns';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../service/contract.service';
import {EmployeeService} from '../../employee/service/employee.service';
import {CustomerService} from '../../customer/service/customer.service';
import {FacilityService} from '../../facility/service/facility.service';
import {Employee} from '../../employee/model/employee';
import {Customer} from '../../customer/model/customer';
import {Facility} from '../../facility/model/facility';
import {CustomerType} from '../../customer/model/customer-type';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  contractForm: FormGroup;
  regexDate: RegExp = /^\d{4}-\d{2}-\d{2}$/;
  regexNumber: RegExp = /^[0-9]*&/;
  employees: Employee[] = [];
  customers: Customer[] = [];
  facilities: Facility[] = [];

  constructor(private formBuilder: FormBuilder,
              private contractService: ContractService,
              private employeeService: EmployeeService,
              private customerService: CustomerService,
              private facilityService: FacilityService,
              private route: Router) {
    this.contractForm = this.formBuilder.group({
      id: [''],
      startDate: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      endDate: ['', [Validators.required, Validators.pattern(this.regexDate)]],
      deposit: ['', [Validators.required, Validators.min(0)]],
      customer: [{}, [Validators.required]],
      employee: [{}, [Validators.required]],
      facility: [{}, [Validators.required]]
    }, {validators: this.validateRegisteredDate});
    this.getCustomer();
    this.getEmployee();
    this.getFacility();
  }

  ngOnInit(): void {
  }

  //Ph????ng th???c ????? select ch???n theo gi?? tr???
  compareWith(o1: CustomerType, o2: CustomerType): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  // Validate ng??y k???t th??c ph???i sau ng??y b???t ?????u
  validateRegisteredDate(c: AbstractControl) {
    let startDate = new Date(c.get('startDate')?.value);
    let endDate = new Date(c.get('endDate')?.value);
    let check = differenceInDays(endDate, startDate);
    return (check < 0) ? {'endDateAfterStartDate': true} : null;
  }

  //T???o h???p ?????ng m???i
  submitContract() {
    this.contractService.create(this.contractForm.value).subscribe(data => {
      this.route.navigateByUrl('/contract');
    }, error => {
    }, () => {
    });
  }

  //T???o danh s??ch kh??ch h??ng
  getCustomer() {
    this.customerService.getListCustomer().subscribe(data => {
      this.customers = data;
    }, error => {
    }, () => {
    });
  }

  //T???o danh s??ch nh??n vi??n
  getEmployee() {
    this.employeeService.getListEmployee().subscribe(data => {
      this.employees = data;
    }, error => {
    }, () => {
    });
  }

  //T???o danh s??ch facility
  getFacility() {
    this.facilityService.getListFacility().subscribe(data => {
      this.facilities = data;
    }, error => {
    }, () => {
    });
  }
}
