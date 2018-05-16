import { Component, OnInit } from '@angular/core';
import { Merchant } from '../merchant';
import { MerchantService } from '../merchant.service';

@Component({
  selector: 'app-merchants',
  templateUrl: './merchants.component.html',
  styleUrls: ['./merchants.component.css']
})
export class MerchantsComponent implements OnInit {

  merchants: Merchant[];

  constructor(private merchantService: MerchantService) { }

  ngOnInit() {
    this.getMerchants();
  }

  getMerchants(): void {
    this.merchantService.getMerchants()
      .subscribe(merchants => this.merchants = merchants);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.merchantService.addMerchant({ name } as Merchant)
      .subscribe(hero => {
        this.merchants.push(hero);
      });
  }

  delete(merchant: Merchant): void {
    this.merchants = this.merchants.filter(m => m !== merchant);
    this.merchantService.deleteMerchant(merchant).subscribe();
  }
}
