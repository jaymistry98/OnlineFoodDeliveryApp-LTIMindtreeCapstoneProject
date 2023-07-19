import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { FoodItemService } from 'src/app/Services/food-item.service';
@Component({
  selector: 'app-create-food-item',
  templateUrl: './create-food-item.component.html',
  styleUrls: ['./create-food-item.component.css']
})
export class CreateFoodItemComponent {
  constructor(private fs: FoodItemService, private router: Router, private route: ActivatedRoute){}
  
  //Food Item Form to create food
  foodItemForm: FormGroup;
  foodName:FormControl;
  price: FormControl;
  description: FormControl;

  //Vendor Id
  vendorId: any;

  ngOnInit(){
    this.createFormControls();
    this.createForm();
    this.vendorId=this.route.snapshot.params["vendorId"];
  }

  createForm() {
    this.foodItemForm = new FormGroup({
      foodName:this.foodName,
      price:this.price,
      description:this.description,
    });
  }

  createFormControls() {
    this.foodName = new FormControl('', Validators.required);
    this.price = new FormControl('', Validators.required);
    this.description = new FormControl('', Validators.required);
  }

  createFoodItem(){

    //Add Vendor Id to Food Item Form on insert to database, and return to the Vendor Dashboard
    this.foodItemForm.value.vendorId = this.vendorId;
    this.fs.createFoodItem(this.foodItemForm.value).subscribe((response) => {
      this.router.navigate(['/vendor-dashboard', this.vendorId])
    })
  }

}