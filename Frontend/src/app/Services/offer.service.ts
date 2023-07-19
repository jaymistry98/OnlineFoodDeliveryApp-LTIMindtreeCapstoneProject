import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpGeneralService } from '../shared/http-service/httpgeneral.service';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  constructor(private http:HttpClient, private httpService: HttpGeneralService) { }

  getAllOffers(){
    return this.httpService.get('/getAllOffers');
  }

  createOffer(data:any){
    return this.httpService.post('/createOffer',data);
  }

  getOfferById(id: number){
    return this.httpService.get(`/getOfferById/${id}`);
  }

  updateOffer(data:any){
    return this.httpService.put('/updateOffer',data);
  }

  deleteOfferById(id: number){
    return this.httpService.delete(`/deleteOfferById/${id}`);
  }

}