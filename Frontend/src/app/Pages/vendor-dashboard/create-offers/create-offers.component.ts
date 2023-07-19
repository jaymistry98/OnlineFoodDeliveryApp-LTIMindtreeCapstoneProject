import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { OfferService } from 'src/app/Services/offer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-offers',
  templateUrl: './create-offers.component.html',
  styleUrls: ['./create-offers.component.css']
})

export class CreateOffersComponent {
  constructor(private offerService: OfferService ,
    private route: ActivatedRoute,
    private _router: Router){}

  //Holds all offers
  offerData:any[];

  //Offer form
  offerForm: FormGroup;
  discount:FormControl;
  offerDescription: FormControl;

  //vendor id
  vendorId: number;

  ngOnInit(){
    this.createFormControls();
    this.createForm();
    this.vendorId=this.route.snapshot.params["vendorId"];
  }

  createForm() {
    this.offerForm = new FormGroup({
      discount:this.discount,
      offerDescription:this.offerDescription,
    })
  }

  createFormControls() {
    this.discount = new FormControl('', Validators.required);
    this.offerDescription = new FormControl('', Validators.required);
  }

  //Submit offer
  createOffer(){
    console.log()
    this.offerService.createOffer(this.offerForm.value).subscribe((response) => {
      this._router.navigate(['/vendor-dashboard', this.vendorId]);
    })
  }

}