import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { ShoppingCartService } from 'src/app/Services/shopping-cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  
  //Number of items in Shopping Cart
  ItemCount: number;
  //Whether or not to show Shopping Cart icon
  isShoppingAuthenticated: boolean;

  constructor(private cs: ShoppingCartService, private as: AuthService, private route: ActivatedRoute) {}
  
  ngOnInit() {
    //Get Item Count
    this.cs.getProducts().subscribe((response) => {
      this.ItemCount = response.length;
    });
    
    //Get Shopping Cart Authentication for user type User
    this.as.auth_update.subscribe((response) => {
      this.isShoppingAuthenticated = response;
    })
  }

}
