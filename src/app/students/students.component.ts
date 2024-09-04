import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {Router} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {Student} from "../models/students.model";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent implements OnInit{

  students!: Array<Student>;
  public dataSource: any;
  public displayedColumns = ["id", "code", "firstName", "lastName", "programId", "photo", "payments"];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private router : Router, private studentService : StudentsService) {
  }

  ngOnInit() {
    this.studentService.getAllStudents()
      .subscribe({
        next : data => {
          this.students = data
          this.dataSource = new MatTableDataSource(this.students);
          this.dataSource.paginator = this.paginator
          this.dataSource.sort = this.sort
        },
        error : err => {
          console.log(err)
        }
      });
  }

  filterStudents($event: Event) {
    let value = ($event.target as HTMLInputElement).value
    this.dataSource.filter = value
  }

  studentPayments(student: Student) {
    this.router.navigateByUrl(`/admin/student-details/${student.code}`)
  }
}
