import { Component, OnInit } from '@angular/core';
import { Merchant } from '../merchant';
import { MerchantService } from '../merchant.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  merchants: Merchant[] = [];

  constructor(private merchantService: MerchantService) { }

  ngOnInit() {
    this.getMerchants();
  }

  getMerchants(): void {
    this.merchantService.getMerchants()
      .subscribe(merchants => this.merchants = merchants.slice(1, 5));
  }
}
