import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { MerchantsComponent } from './merchants/merchants.component';
import { MerchantDetailComponent } from './merchant-detail/merchant-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    MerchantsComponent,
    MerchantDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
