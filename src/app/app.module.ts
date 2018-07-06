import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";


import {AppComponent} from './app.component';
import {MerchantsComponent} from './merchants/merchants.component';
import {MerchantDetailComponent} from './merchant-detail/merchant-detail.component';
import {MerchantService} from "./merchant.service";
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './message.service';
import {AppRoutingModule} from './app-routing.module';
import {DashboardComponent} from './dashboard/dashboard.component';

import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './in-memory-data.service';
import { MerchantSearchComponent } from './merchant-search/merchant-search.component';


@NgModule({
  declarations: [
    AppComponent,
    MerchantsComponent,
    MerchantDetailComponent,
    MessagesComponent,
    DashboardComponent,
    MerchantSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation: false}
    )
  ],
  providers: [
    MerchantService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
