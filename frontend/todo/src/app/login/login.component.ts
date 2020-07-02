import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthenticationService } from '../service/hard-coded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'in28minutes'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  //dependency injection
  constructor(
    private router: Router,
    private hardCodedAuthenticationService: HardCodedAuthenticationService
  ) { }

  ngOnInit(): void {
  }

  handleLogin() {
    if (this.hardCodedAuthenticationService.authenticate(this.username, this.password)) {

      this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
      
    } else {
      this.invalidLogin = true
    }
  }

}
