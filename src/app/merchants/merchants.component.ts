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

  selectedMerchant: Merchant;

  constructor(private merchantService: MerchantService) { }

  ngOnInit() {
    this.getMerchants();
  }

  getMerchants(): void {
    this.merchantService.getMerchants()
      .subscribe(merchants => this.merchants = merchants);
  }

  onSelect(merchant: Merchant): void{
    this.selectedMerchant = merchant;
  }

}
