import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../-Services-/authentication.service";
import {User} from "../-Models-/user";
import {Role} from "../-Models-/role";

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
    });
    if(this.currentUser) {
      this.manager = this.currentUser.role == Role.Manager;
    }
  }

  toSearchPage() {
    this.router.navigate(['search']);
  }

}
