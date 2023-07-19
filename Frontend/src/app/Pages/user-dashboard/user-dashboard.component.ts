import { Component } from '@angular/core';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
  constructor(private vs: VendorService) {}

  //Holds list of Vendors
  vendorList: any[];

  ngOnInit() {
    this.loadVendors();
  }

  loadVendors() {
    this.vs.getAllVendors().subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.vendorList = locArray;
    });
  }
}
