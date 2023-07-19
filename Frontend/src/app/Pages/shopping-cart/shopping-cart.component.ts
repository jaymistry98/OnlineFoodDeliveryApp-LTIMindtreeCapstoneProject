import { Component } from '@angular/core';
import { ShoppingCartService } from 'src/app/Services/shopping-cart.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OfferService } from 'src/app/Services/offer.service';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent {

  //Holds the list of items in a users shopping cart
  productList: any[];
  subTotal: number; 
  vendorId: number;
  offers: any = [];
  discount= {discount: 0};
  isShoppingAuthenticated = true;
  vendorData: any;

  constructor(private vs: VendorService, private _router: Router, private os: OfferService, private cs: ShoppingCartService, 
    private route: ActivatedRoute) {}

  ngOnInit(): void {
      this.loadProducts();
      this.loadOffers();
      this.vendorId=this.route.snapshot.params["vendorId"];

      //Check if vendorId is null, if so, user has clicked shopping cart icon
      if(isNaN(this.vendorId)) {
        this.cs.getProducts().subscribe((response) => {
          //If empty shopping cart, user can return to dashboard only
          if(response.length == 0) {
            this.isShoppingAuthenticated = false;
          }
          else {
            //else vendor information is shown along with return to food menu and go to cart buttons
            this.vendorId = response[0].vendorId;
          }
        });
      }

      //Get Vendor Information
      this.vs.getVendorById(this.vendorId).subscribe((response) => {
        this.vendorData = response;
        console.log(this.vendorData);
      });
    }

    //Get all products
    loadProducts() {
      this.cs.getProducts().subscribe((res) => {
        this.productList = res;
        this.getSubTotal();
      });
    }

    //Get the subtotal
    getSubTotal() {
      this.subTotal = this.cs.getSubTotal();
      console.log(this.subTotal);
    }

    //Get all offers
    loadOffers() {
      this.os.getAllOffers().subscribe((res) => {
        this.offers = res;
      })
    }

    //Remove an item from cart and update products and subtotal
    removeItem(item: any) {
      this.cs.removeCartItem(item);
      this.loadProducts();
      this.cs.getSubTotal();
    }

    //Remove all items from the cart and update products and subtotal
    removeAll() {
      this.cs.removeAllCart();
      this.loadProducts();
      this.cs.getSubTotal();
    }

    //Confirm order and go to order confirmation page
    confirmOrder() {
      console.log(this.discount.discount);
      this._router.navigate(['/order-confirmation', this.vendorId, this.discount.discount]);
    }
}
