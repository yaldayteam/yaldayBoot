import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MerchantsComponent} from './merchants/merchants.component';

const routes: Routes = [
  { path: 'merchants', component: MerchantsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {

}
