import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { UserService } from 'src/app/Services/user.service';
import { VendorService } from 'src/app/Services/vendor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private us: UserService, private vs: VendorService, 
    private as: AuthService, private _router: Router) {}
  
  //Holds user response to use necessary data to reroute user to the right dashboard based on user information
  //including the user type
  userData: any;

  //Holds vendor infomration if user type is a vendor
  vendor: any;

  //Login Form
  loginForm: FormGroup;
  userName: FormControl;
  password: FormControl;

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  createForm() {
    this.loginForm= new FormGroup({
      userName: this.userName,
      password: this.password,
    });
  }

  createFormControls() {
    this.userName = new FormControl('', Validators.required);
    this.password = new FormControl('', [Validators.required, Validators.minLength(6)]);
  }

  login() {
    this.us.login(this.loginForm.value).subscribe((response) => {

      //Get login response
      this.userData = JSON.parse(JSON.stringify(response));

      //Route to appropriate dashboard based on user type
      if(this.userData['type'].match(/^User$/)) {
        this._router.navigate(['/user-dashboard']);
        this.as.authenticate(true);
      }
      else if(this.userData['type'].match(/^Admin$/)) {
        this._router.navigate(['/admin-dashboard']);
      }
      else {
        this.vs.getVendorByUserId(this.userData['userId']).subscribe((response) => {

          //Get vendor information
          this.vendor = JSON.parse(JSON.stringify(response));

          //Route to the right vendor dashboard
          this._router.navigate(['/vendor-dashboard', this.vendor['vendorId']]);
        });
      }
    });
  }
  
}
