import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { HttpGeneralService } from '../shared/http-service/httpgeneral.service';

@Injectable({
  providedIn: 'root'
})
export class FoodItemService {
  constructor(private http: HttpClient, private httpService: HttpGeneralService) { }

  getAllloadFoodItem(){
    return this.httpService.get(`/getAllFoodItems`);
  }

  createFoodItem(data:any) {
    return this.httpService.post('/createFoodItems',data);
  }

  //Gets one Food Item by Food Item id
  getFoodItemById(foodItemId: number) {
    console.log(foodItemId);
    return this.httpService.get(`/getFoodItemById/${foodItemId}`);
  }

  updateFoodItem(data: any) {
    return this.httpService.put('/updateFoodItem', data);
  }

  deleteFoodItemById(foodItemId: number) {
    return this.httpService.delete(`/deleteFoodItemById/${foodItemId}`);
  }
  
  //Gets Food Item List by Vendor Id
  getFoodByVendorId(vendorId: number) {
    return this.httpService.get(`/findFood/${vendorId}`);
  }
  
}