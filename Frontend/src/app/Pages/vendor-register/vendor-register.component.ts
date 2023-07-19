import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-vendor-register',
  templateUrl: './vendor-register.component.html',
  styleUrls: ['./vendor-register.component.css']
})
export class VendorRegisterComponent {
  constructor(private route: ActivatedRoute, private vs: VendorService, private _router: Router) {}
  
  //Object passed into create vendor
  vendor: any;

  //User Id for this Vendor
  userId: number;

  //Vendor Registration Form
  vendorRegisterForm: FormGroup;
  vendorName: FormControl;
  vendorLocation: FormControl;

  ngOnInit() {
    this.createFormControls();
    this.createForm();
    this.userId=this.route.snapshot.params["userId"];
  }

  createForm() {
    this.vendorRegisterForm= new FormGroup({
      vendorName: this.vendorName,
      vendorLocation: this.vendorLocation,
    });
  }

  createFormControls() {
    this.vendorName = new FormControl('', Validators.required);
    this.vendorLocation = new FormControl('', Validators.required);
  }

  //Create Vendor and insert into database, then route to login page
  createVendor() {
    //Add user id as a field for Vendor
    this.vendor = this.vendorRegisterForm.value;
    this.vendor.userId = this.userId;
    this.vs.createVendor(this.vendor).subscribe((response) => {
      this._router.navigate(['/login']);
    });
  }

}
