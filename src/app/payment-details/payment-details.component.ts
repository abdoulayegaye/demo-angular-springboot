import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {ActivatedRoute} from "@angular/router";
import {Payment} from "../models/students.model";

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrl: './payment-details.component.css'
})
export class PaymentDetailsComponent implements OnInit{

  idPayment! : number;
  pdfFileUrl : any;

  constructor(private studentService : StudentsService,
              private activateRoute : ActivatedRoute) {
  }

  ngOnInit() {
    this.idPayment = this.activateRoute.snapshot.params['id'];
    this.studentService.getPaymentDetails(this.idPayment)
      .subscribe({
        next : data => {
          let blob = new Blob([data], {type: 'application/pdf'});
          this.pdfFileUrl = window.URL.createObjectURL(blob);
        },
        error : err => {
          console.log(err);
        }
      })
  }

  afterLoadComplete($event: any) {

  }
}
