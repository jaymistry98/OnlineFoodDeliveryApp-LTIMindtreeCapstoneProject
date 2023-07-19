import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpGeneralService } from '../shared/http-service/httpgeneral.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http:HttpClient, private httpService: HttpGeneralService) {}

  login(data: any) {
    return this.httpService.post('/login', data);
  }

  register(data: any) {
    return this.httpService.post('/createUser', data);
  }

  changePassword(data: any) {
    return this.httpService.put('/updateUser', data);
  }

}
