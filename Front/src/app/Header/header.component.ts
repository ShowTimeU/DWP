import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../-Models-/user';
import {MatSidenav} from '@angular/material/sidenav';
import {AuthenticationService} from '../-Services-/authentication.service';
import {Role} from "../-Models-/role";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  twitterUrl: string = 'https://twitter.com';
  instagramUrl: string = 'https://instagram.com';
  facebookUrl: string = 'https://facebook.com';
  currentUser: User;
  isAdmin = false;
  reason = '';
  @ViewChild('sidenav') sidenav: MatSidenav;
  push: any;
  firstNameLetter: any;
  lastNameLetter: any;

  constructor(private changeDetection: ChangeDetectorRef,
              private auth: AuthenticationService) {
  }

  ngOnInit() {
    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
      if(this.currentUser) {
        setInterval(() => {
          this.checkName();
          this.checkNameInitials();
          this.changeDetection.markForCheck();
        }, 1000)
      }
    });
    if(this.currentUser && this.currentUser.role === Role.Admin) {
      this.isAdmin = true;
    }
  }

  checkName() {
    return (this.auth.currentUserValue.firstName && this.auth.currentUserValue.lastName);
  }

  checkNameInitials() {
    this.firstNameLetter = this.currentUser.firstName.charAt(0).toUpperCase();
    this.lastNameLetter = this.currentUser.lastName.charAt(0).toUpperCase();
    return this.firstNameLetter+''+this.lastNameLetter;
  }

  close(reason: string) {
    this.reason = reason;
    this.sidenav.close();
  }

  get isUserOrAdmin() {
    if(this.currentUser && this.currentUser.role === Role.Manager) {
      return false;
    } else {
      return this.currentUser;
    }
  }

  get isManager() {
    return this.currentUser && this.currentUser.role === Role.Manager;
  }

}
