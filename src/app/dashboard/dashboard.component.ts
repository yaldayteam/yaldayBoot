import { Component, OnInit } from '@angular/core';
import { Merchant } from '../merchant';
import { MerchantService } from '../merchant.service';
import { HttpResponse } from "@angular/common/http";
import { Subscription, Subject, Observable } from "rxjs";
import { ActivatedRoute } from '@angular/router';
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
  
  
  
export class DashboardComponent implements OnInit {
  merchants: Merchant[] = [];
  merchantsSearch: Observable<Merchant[]>;
  
  eventSubscriber: Subscription;
  currentSearch: string;
  private searchTerms = new Subject<string>();
  
  constructor(
    private merchantService: MerchantService,
    private activatedRoute: ActivatedRoute
 
  ) { this.currentSearch = this.activatedRoute.snapshot.params['search']
    ? this.activatedRoute.snapshot.params['search']: '';
}
  
  search2(term: string):void{
      this.searchTerms.next(term);
  }
  
  
 getMerchants(): void {
    this.merchantService.getMerchants()
      .subscribe(merchants => this.merchants = merchants.slice(1, 15));
   
  }
   

loadAll() {
    
  if (this.currentSearch) {
    this.merchantService.searchMerchants(this.currentSearch)
        .subscribe(merchants => this.merchants = merchants.slice(1,15));
        return; 
    }    
    this.merchantService.getMerchants()
        .subscribe(merchants => this.merchants = merchants.slice(1,15)); 
}
  
  search(query) {               //User button event Search(currentSearch), if search term on User Click then currentSearch = Query and loadAll()
      if(!query) {
        return this.clear();
      }
    this.currentSearch = query;
    this.loadAll();
  }
 
  clear() {
    this.currentSearch = '';
    this.loadAll();
  }
  
 ngOnInit(){
   this.loadAll();
   
   this.merchantsSearch = this.searchTerms.pipe(
   
    debounceTime(300),
      
    distinctUntilChanged(),
      
    switchMap((term: string) => this.merchantService.searchMerchants(term)),
   );
}
 
 

}
