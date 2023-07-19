import { Component, OnInit } from '@angular/core';
import { OfferService } from 'src/app/Services/offer.service';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  offerData: any[];
  

  constructor(private os: OfferService) { }


  ngOnInit() { 
    this.loadOffers();
  }

  loadOffers() {
    this.os.getAllOffers().subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.offerData = locArray;
    })
  }
  

}
