import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MerchantsComponent} from './merchants/merchants.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { MerchantDetailComponent }  from './merchant-detail/merchant-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'merchant/:name', component: MerchantDetailComponent },
  { path: 'merchants', component: MerchantsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {

}
