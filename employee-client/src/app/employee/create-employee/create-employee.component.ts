import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import  { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  submitted: boolean = false;
  nextId: string;
  constructor(private employeeService: EmployeeService, private router: Router) {
   }

  ngOnInit(): void {
    this.employeeService.getNextId()
      .subscribe(data =>{
        this.nextId = JSON.stringify(data);
      }, error => console.log(error));
      
  }
  
  save(){
    this.employeeService.createEmployee(this.employee)
      .subscribe(data =>{
        this.employee = new Employee();
        this.goToList();
      },
      error => console.log(error));
  }
  onSubmit(){
    this.submitted = true;
    this.save();
  }
  goToList(){
    this.router.navigate(['/employees']);
  }
}
