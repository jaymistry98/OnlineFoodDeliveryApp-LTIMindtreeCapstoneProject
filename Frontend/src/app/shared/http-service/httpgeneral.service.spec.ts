import { TestBed } from '@angular/core/testing';

import { HttpGeneralService } from './httpgeneral.service';

describe('HttpgeneralService', () => {
  let service: HttpGeneralService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpGeneralService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
