import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';

import { Merchant } from '../merchant';
import { MerchantService } from '../merchant.service';

@Component({
  selector: 'app-merchant-search',
  templateUrl: './merchant-search.component.html',
  styleUrls: [ './merchant-search.component.css' ]
})
export class MerchantSearchComponent implements OnInit {
  
  
  merchants: Observable<Merchant[]>;

  private searchTerms = new Subject<string>();
//  currentSearch:string;

  constructor(private merchantService: MerchantService) {}

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.merchants = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      
      switchMap((term: string) => this.merchantService.searchMerchants(term)),
    );
  }
  
  
  
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/