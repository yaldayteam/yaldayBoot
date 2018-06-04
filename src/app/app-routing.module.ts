import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MerchantsComponent} from './merchants/merchants.component';
import { LoginComponent} from './login/login.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { MerchantDetailComponent }  from './merchant-detail/merchant-detail.component';
import { RegisterComponent} from './register/register.component';
import { AuthGuard } from './_guards/index';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full', canActivate: [AuthGuard] },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'merchant/:name', component: MerchantDetailComponent },
  { path: 'merchants', component: MerchantsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {

}
