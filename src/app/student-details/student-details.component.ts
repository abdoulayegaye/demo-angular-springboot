import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {Payment} from "../models/students.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrl: './student-details.component.css'
})
export class StudentDetailsComponent implements OnInit{

  studentCode! : string;
  paymentsByStudent!: Array<Payment>;
  public dataSource: any;
  public displayedColumns = ["id", "date", "amount", "type", "status", "nomComplet", "details"];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private activateRoute : ActivatedRoute,
              private studentService : StudentsService,
              private router : Router) {
  }

  ngOnInit() {
    this.studentCode = this.activateRoute.snapshot.params['code'];
    this.studentService.getPaymentsByStudentCode(this.studentCode)
      .subscribe({
        next : data => {
          this.paymentsByStudent = data;
          this.dataSource = new MatTableDataSource(this.paymentsByStudent);
          this.dataSource.paginator = this.paginator
          this.dataSource.sort = this.sort
        },
        error : err => {
          console.log(err);
        }
      })
  }

  filterPayments($event: Event) {
    let value = ($event.target as HTMLInputElement).value
    this.dataSource.filter = value
  }

  newPayment() {
    this.router.navigateByUrl(`/admin/new-payment/${this.studentCode}`);
  }

  paymentDetails(payment: Payment) {
    this.router.navigateByUrl(`/admin/payment-details/${payment.id}`)
  }
}
