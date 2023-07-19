import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { FoodItemService} from 'src/app/Services/food-item.service';
import { OfferService } from 'src/app/Services/offer.service';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-vendor-dashboard',
  templateUrl: './vendor-dashboard.component.html',
  styleUrls: ['./vendor-dashboard.component.css']
})
export class VendorDashboardComponent {
  constructor(private foodService: FoodItemService, private offerservice:OfferService,private route: ActivatedRoute,
    private vendorService: VendorService) {}

  //Holds all Offer data
  offerData:any[];

  //Holds all Food Item Data
  foodItemData:any=[];

  //Vendor Id
  vendorId: number;

  //Holds the Vendor Information
  vendorInfo: any;

  ngOnInit(){ 
    this.route.params.subscribe((params: Params) => {
      this.vendorId=this.route.snapshot.params["vendorId"];

      //After getting vendor id, get the vendor's information
      this.vendorService.getVendorById(this.vendorId).subscribe((response)=>{
        this.vendorInfo= JSON.parse(JSON.stringify(response));
      });
    });
    this.loadFoodItems();
    this.loadOffers();
  }

  //Get all Food Items for given Vendor
  loadFoodItems(){
    this.foodService.getFoodByVendorId(this.vendorId).subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.foodItemData= locArray;
    });
  }

  //Delete Food Item belonging to this Vendor
  deleteFoodItem(foodItem:any){
    this.foodService.deleteFoodItemById(foodItem.foodId).subscribe((response) => {
      this.loadFoodItems();
    });
  }

  //Get all Offers
  loadOffers(){
    this.offerservice.getAllOffers().subscribe((data) =>{
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.offerData= locArray
      this.loadFoodItems();
    })
  }

  //Delete an offer from the shared offers list
  deleteOffer(offer:any){
    this.offerservice.deleteOfferById(offer.offerId).subscribe((response) => {
      console.log(response)
      this.loadOffers()
    });
  }

}

