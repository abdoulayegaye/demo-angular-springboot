import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatMenu, MatMenuItem, MatMenuModule, MatMenuTrigger} from "@angular/material/menu";
import {MatDrawer, MatDrawerContainer, MatDrawerContent} from "@angular/material/sidenav";
import {MatListItem, MatNavList} from "@angular/material/list";
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { StudentsComponent } from './students/students.component';
import { PaymentsComponent } from './payments/payments.component';
import {MatCard, MatCardContent, MatCardHeader, MatCardModule, MatCardTitle} from "@angular/material/card";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import { LoadPaymentsComponent } from './load-payments/load-payments.component';
import { LoadStudentsComponent } from './load-students/load-students.component';
import {MatTable, MatTableModule} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {MatSort, MatSortHeader, MatSortModule} from "@angular/material/sort";
import {MatFormField, MatHint, MatInput, MatLabel} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {AuhtGuard} from "./guards/auht.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {HttpClientModule} from "@angular/common/http";
import { StudentDetailsComponent } from './student-details/student-details.component';
import { NewPaymentComponent } from './new-payment/new-payment.component';
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {PdfViewerModule} from "ng2-pdf-viewer";
import {MatProgressSpinner, MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import { PaymentDetailsComponent } from './payment-details/payment-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminTemplateComponent,
    HomeComponent,
    ProfileComponent,
    LoginComponent,
    DashboardComponent,
    StudentsComponent,
    PaymentsComponent,
    LoadPaymentsComponent,
    LoadStudentsComponent,
    StudentDetailsComponent,
    NewPaymentComponent,
    PaymentDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatDrawerContainer,
    MatDrawer,
    MatNavList,
    MatListItem,
    MatDrawerContent,
    MatCardModule,
    MatDividerModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSortHeader,
    MatInput,
    MatFormField,
    MatLabel,
    ReactiveFormsModule,
    HttpClientModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatHint,
    MatSelectModule,
    PdfViewerModule,
    MatProgressSpinnerModule
  ],
  providers: [
    provideAnimationsAsync(),
    AuhtGuard,
    AuthorizationGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
