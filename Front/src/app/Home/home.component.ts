import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../_Services/authentication.service";
import {User} from "../_Models/user";
import {Role} from "../_Models/role";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: User;
  manager = false;

  constructor(private router: Router,
              private auth: AuthenticationService) { }

  ngOnInit() {
    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
      this.manager = this.currentUser.email == Role.Manager;
    });
  }

  toSearchPage() {
    this.router.navigate(['search']);
  }

}
