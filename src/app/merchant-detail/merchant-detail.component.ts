import { Component, OnInit, Input } from '@angular/core';
import { Merchant } from '../merchant';

@Component({
  selector: 'app-merchant-detail',
  templateUrl: './merchant-detail.component.html',
  styleUrls: ['./merchant-detail.component.css']
})
export class MerchantDetailComponent implements OnInit {

  @Input() merchant: Merchant;

  constructor() { }

  ngOnInit() {
  }

}
