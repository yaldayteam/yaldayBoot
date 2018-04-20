import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { MerchantsComponent } from './merchants/merchants.component';
import { MerchantDetailComponent } from './merchant-detail/merchant-detail.component';
import { MerchantService } from "./merchant.service";
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';


@NgModule({
  declarations: [
    AppComponent,
    MerchantsComponent,
    MerchantDetailComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [
    MerchantService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
