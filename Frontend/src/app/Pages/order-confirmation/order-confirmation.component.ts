import { Component } from '@angular/core';
import { ShoppingCartService } from 'src/app/Services/shopping-cart.service';
import { ActivatedRoute } from '@angular/router';
import { VendorService } from 'src/app/Services/vendor.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent {
  constructor(private cs: ShoppingCartService,  private vs: VendorService, 
    private route: ActivatedRoute, private datepipe: DatePipe) {

      //Get the current time
      this.currentDateTime =this.datepipe.transform((new Date), 'MM/dd/yyyy h:mm');
  }

  //Holds vendor information
  vendorData: any;
  grandTotal: any; 

  //Holds vendor which user is ordering from
  vendorId: number;
  currentDateTime: any;
  discount: number;
  subtotal: number;

  ngOnInit(): void {
    this.vendorId=this.route.snapshot.params["vendorId"];
    this.discount=this.route.snapshot.params["discount"];

    //Load vendor details on order confirmation page
    this.vs.getVendorById(this.vendorId).subscribe((res) => {
      this.vendorData= res;
    })

    this.getSubtotal();
    this.getGrandTotal();
  }

  //Before offer is applied to order
  getSubtotal() {
    this.subtotal = this.cs.getSubTotal();
  }

  //After offer is applied to order
  getGrandTotal() {
    this.grandTotal = this.cs.getGrandTotal(this.discount);
  }

}
