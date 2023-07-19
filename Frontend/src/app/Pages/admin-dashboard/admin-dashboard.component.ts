import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FeedbackService } from 'src/app/Services/feedback.service';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  constructor(private fs: FeedbackService, private vs: VendorService, private _router: Router) {}

    //Feedback from users
    feedbackData: any[];

    //Information of all Vendors
    vendorData: any[];

  ngOnInit() { 
    this.loadVendors()
    this.loadFeedbacks()
  }

  //Get all Vendors
  loadVendors() {
    this.vs.getAllVendors().subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.vendorData = locArray;
    })
  }

  //Get all Feedbacks
  loadFeedbacks() {
    this.fs.getAllFeedback().subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.feedbackData = locArray;
    })
  }
  
  //Delete Vendor and reload
  onDeleteVendor(vendor) {
    this.vs.deleteVendorbyId(vendor.vendorId).subscribe(response=>{
      console.log(response)
      this.loadVendors()
    });
  }

  //Delete Feedbacks and reload
  onDeleteFeedback(feedback) {
    this.fs.deleteFeedbackById(feedback.feedbackId).subscribe(response=>{
      console.log(response)
      this.loadFeedbacks()
    });
  }

}


