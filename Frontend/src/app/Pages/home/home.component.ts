import { Component } from '@angular/core';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private as: AuthService) {}

  ngOnInit() {
    //User is not authenticated as user type, thus do not show shopping cart icon in the header
    this.as.authenticate(false);
  }
}
