import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FoodItemService } from './food-item.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ShoppingCartService {
  constructor(private http: HttpClient, private fis: FoodItemService) {}

  //Actual cart
  cartItemList = [];

  //Behavior Subject for immediate update
  productList = new BehaviorSubject<any>([]);
  
  getProducts() {
    return this.productList.asObservable();
  }

  setProducts(product: any) {
    this.cartItemList.push(...product);
    this.productList.next(product);
  }

  addToCart(product: any) {
    //Check and return whether items in cart are from the same vendor
    if(this.cartItemList.length != 0 && this.cartItemList[0].vendorId != product.vendorId) {
      return false;
    }
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    return true;
  }

  getSubTotal() {
    let subTotal = 0;
    this.cartItemList.map((a: any) => {
      subTotal += a.price;
    });
    return subTotal;
  }

  getGrandTotal(discount: any) {
    let grandTotal = this.getSubTotal();
    return (grandTotal * (1 - (discount / 100))).toFixed(2);
  }

  removeCartItem(product: any) {
    this.cartItemList.some((a: any, index: any) => {
      
      //Find item in cart and remove it
      if (product.id === a.id) {
        this.cartItemList.splice(index, 1);
        this.productList.next(this.cartItemList);
        return true;
      }
      return false;
    });
  }

  removeAllCart() {
    this.cartItemList = [];
    this.productList.next(this.cartItemList);
  }

}
