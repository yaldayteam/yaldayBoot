import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Merchant } from '../merchant';
import { MerchantService} from "../merchant.service";

@Component({
  selector: 'app-merchant-detail',
  templateUrl: './merchant-detail.component.html',
  styleUrls: ['./merchant-detail.component.css']
})
export class MerchantDetailComponent implements OnInit {

  @Input() merchant: Merchant;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private merchantService: MerchantService
  ) { }

  ngOnInit() {
    this.getMerchant()
  }

  getMerchant(): void {
    const name = this.route.snapshot.paramMap.get('name');
    this.merchantService.getMerchant(name).subscribe(merchant => this.merchant = merchant);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.merchantService.updateMerchant(this.merchant)
      .subscribe(() => this.goBack());
  }

}
