import { Injectable } from '@angular/core';
import { Merchant } from './merchant';
import { MERCHANTS } from './mock-merchants';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from './message.service';

@Injectable()
export class MerchantService {

  constructor(private messageService: MessageService) { }

  getMerchants(): Observable<Merchant[]> {
    this.messageService.add('MerchantService: fetched merchants');
    return of(MERCHANTS);
  }

}
