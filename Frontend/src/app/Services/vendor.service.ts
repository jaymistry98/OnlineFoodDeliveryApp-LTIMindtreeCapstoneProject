import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpGeneralService } from '../shared/http-service/httpgeneral.service';

@Injectable({
  providedIn: 'root',
})
export class VendorService {
  constructor(private http: HttpClient, private httpService: HttpGeneralService) {}

  getAllVendors() {
    return this.httpService.get('/getAllVendors');
  }

  createVendor(data: any) {
    return this.httpService.post('/createVendor', data);
  }

  //Get Vendor by the Vendor Id
  getVendorById(vendorId: number) {
    return this.httpService.get(`/getVendorById/${vendorId}`);
  }

  //Get Vendor by the User Id
  getVendorByUserId(userId: number) {
    return this.httpService.get(`/getVendorByUserId/${userId}`);
  }

  updateVendor(data: any) {
    return this.httpService.put('/updateVendor', data);
  }

  //Delete Vendor by Vendor Id
  deleteVendorbyId(vendorId: number) {
    return this.httpService.delete(`/deleteVendorById/${vendorId}`);
  }

}
