import {Component, Input, OnInit} from '@angular/core';
import {ProductTemplate} from "../../-Models-/product-template";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {ProductService} from "../../-Services-/product.service";
import {User} from "../../-Models-/user";
import {MessengerService} from "../../-Services-/messenger.service";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-business-product-template',
  templateUrl: './business-product-template.component.html',
  styleUrls: ['./business-product-template.component.css']
})
export class BusinessProductTemplateComponent implements OnInit {

  @Input() item: ProductTemplate;
  currentUser: User;

  constructor(private router: Router,
              private auth: AuthenticationService,
              private product: ProductService,
              private msg: MessengerService) { }

  ngOnInit(): void {
    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }

  toCreateProduct() {
    if (!this.currentUser && this.currentUser.role !== Role.Manager) {
      this.router.navigate(['login']);
    } else {
      this.msg.sendProductTemplateValue(this.item);
      this.router.navigate(['create-product']);
    }
  }
}
