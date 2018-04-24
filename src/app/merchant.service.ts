import { Injectable } from '@angular/core';
import { Merchant } from './merchant';
import { MERCHANTS } from './mock-merchants';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class MerchantService {

  private merchantsUrl = 'http://localhost:8080/merchants';

  constructor(private http: HttpClient,
              private messageService: MessageService) { }

  getMerchants(): Observable<Merchant[]> {
    this.log('MerchantService: fetched merchants');
    return this.http.get<Merchant[]>(this.merchantsUrl);
  }

  getMerchant(name: string): Observable<Merchant>{
    this.log(`MerchantService: fetched merchant name=${name}`);
    return of(MERCHANTS.find(merchant => merchant.name === name));
  }

  private log(message: string) {
    this.messageService.add('MessageService: ' + message);
  }
}
