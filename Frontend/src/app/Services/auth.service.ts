import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

//Controls whether or not to show cart icon on any given page at any given time
//based on user authentication
export class AuthService {
  authentication = false;
  auth_update = new BehaviorSubject<boolean>(false);


  authenticate(auth: boolean) {
    this.authentication = auth;
    this.auth_update.next(auth);
  }

  getAuthentication() {
    console.log(this.authentication);
    return this.authentication;
  }
  
}
