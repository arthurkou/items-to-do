import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  welcomeMessageFromService: string;
  message: String = 'Some Welcome message'
  name = ''

  constructor(
    private route: ActivatedRoute,
    private welcomeDataService: WelcomeDataService) { }

  ngOnInit(): void {

    console.log(this.message)
    //console.log(this.route.snapshot.params['name'])
    this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage() {
    //    console.log(this.welcomeDataService.executeHelloWorldBeanService());

    this.welcomeDataService.executeHelloWorldBeanService().subscribe(
      response => this.handlerSuccessfulResponse(response),
      error => this.handlerErrorResponse(error));
  }

  getWelcomeMessageWithParams() {
    //    console.log(this.welcomeDataService.executeHelloWorldBeanService());

    this.welcomeDataService.executeHelloWorldBeanServiceWithPathVariable(this.name).subscribe(
      response => this.handlerSuccessfulResponse(response),
      error => this.handlerErrorResponse(error));
  }

  handlerSuccessfulResponse(response) {
    this.welcomeMessageFromService = response.message;
    //    console.log(response);
    //    console.log(response.message);
  }

  handlerErrorResponse(error) {
    /* console.log(error)
    console.log(error.error);
    console.log(error.error.message); */
    this.welcomeMessageFromService = error.error.message;
  }

}
