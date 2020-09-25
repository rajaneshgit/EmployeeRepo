import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  empId: number;
  employee: Employee;
  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employee = new Employee();
    this.empId = this.route.snapshot.params['empId'];
    this.employeeService.getEmployee(this.empId)
      .subscribe(data =>{
        this.employee = data;
      }, error => console.log(error));
  }
  
  updateEmployee(){
    this.employeeService.updateEmployee(this.empId, this.employee)
      .subscribe(data =>{
        this.employee = new Employee();
        this.goToList();
      }, error => console.log(error));
  }
  goToList() {
    this.router.navigate(['/employees']);
  }
  onSubmit(){
    this.updateEmployee();
  }
}
