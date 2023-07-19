import { Component } from '@angular/core';
import { FoodItemService } from 'src/app/Services/food-item.service';
import { ActivatedRoute, Params } from '@angular/router';
import { VendorService } from 'src/app/Services/vendor.service';
import { ShoppingCartService } from 'src/app/Services/shopping-cart.service';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent {

  //Vendor id
  vendorId: number;

  //Holds information for food items
  foodItemList: any;

  //Holds information of the vendor
  vendorInfo: any;

  //Controls whether or not to show go to cart button
  isOrderAuthenticated = true;  

  constructor(private fis :FoodItemService, private vs: VendorService,  private route: ActivatedRoute, private sc: ShoppingCartService,
    private cs: ShoppingCartService) { }

  ngOnInit() {

    //Get vendor id as parameter
    this.route.params.subscribe((params: Params) => {
      this.vendorId = +params['vendorId'];
    });
    this.loadVendor();
    this.loadFoodItems();

    //If cart is not empty and its contents do not match current vendor, do not
    //display go to cart button
    this.cs.getProducts().subscribe((response) => {
      if(response.length != 0 && response[0].vendorId != this.vendorId) {
        this.isOrderAuthenticated = false;
      }
    });
  }
 
  //Get vendor information by their id
  loadVendor() {
    this.vs.getVendorById(this.vendorId).subscribe((response)=>{
      this.vendorInfo= JSON.parse(JSON.stringify(response))
    });
  }

  //Get Food Items of vendor
  loadFoodItems() {
    this.fis.getFoodByVendorId(this.vendorId).subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.foodItemList = locArray;
    });
  }

  //Add a food item to the cart
  addToCart(item:any){
    var ret = this.sc.addToCart(item);

    //Check if add to cart was successful
    if(!ret) {
      alert("You can only order from one restaurant at a time");
    }
    else {
      alert(item.foodName + " added to cart");
    }
  }
}
