import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpGeneralService } from '../shared/http-service/httpgeneral.service';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  constructor(private http:HttpClient, private httpService: HttpGeneralService) { }

  getAllFeedback(){
    return this.httpService.get('/getAllFeedbacks');
  }

  createFeedback(data:any){
    return this.httpService.post('/createFeedback',data);
  }

  deleteFeedbackById(feedbackId: number){
    return this.httpService.delete(`/deleteFeedbackById/${feedbackId}`);
  }

}