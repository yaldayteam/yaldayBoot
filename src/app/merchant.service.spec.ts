import { TestBed, inject } from '@angular/core/testing';

import { MerchantService } from './merchant.service';

describe('MerchantService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MerchantService]
    });
  });

  it('should be created', inject([MerchantService], (service: MerchantService) => {
    expect(service).toBeTruthy();
  }));
});
