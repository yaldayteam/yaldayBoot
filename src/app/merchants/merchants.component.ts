import { Component, OnInit } from '@angular/core';
import { Merchant } from '../merchant';
import { MERCHANTS } from '../mock-merchants';

@Component({
  selector: 'app-merchants',
  templateUrl: './merchants.component.html',
  styleUrls: ['./merchants.component.css']
})
export class MerchantsComponent implements OnInit {

  merchants = MERCHANTS;

  selectedMerchant: Merchant;

  constructor() { }

  ngOnInit() {
  }

  onSelect(merchant: Merchant): void{
    this.selectedMerchant = merchant;
  }

}
