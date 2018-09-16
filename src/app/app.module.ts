import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";


import { AppComponent } from './app.component';
import { MerchantsComponent } from './merchants/merchants.component';
import { MerchantDetailComponent } from './merchant-detail/merchant-detail.component';
import { MerchantService } from "./merchant.service";
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './user_home/user_home.component';

import { AlertService, AuthenticationService, UserService } from './_services/index';
import { RegisterComponent } from './register/index';
import { LoginComponent } from './login/login.component';
import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { JwtInterceptor } from './_helpers/index';
import { fakeBackendProvider } from './_helpers/index';

@NgModule({
  declarations: [
    AppComponent,
    MerchantsComponent,
    MerchantDetailComponent,
    MessagesComponent,
    DashboardComponent,
    AlertComponent,
    LoginComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    MerchantService,
    MessageService,
    AlertService,
    AuthenticationService,
    AuthGuard,
    UserService,
    {
        provide: HTTP_INTERCEPTORS,
        useClass: JwtInterceptor,
        multi: true
    },

    // provider used to create fake backend
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
