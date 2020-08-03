import {Component, Input, OnInit} from '@angular/core';
import {ProductTemplate} from "../../-Models-/product-template";
import {MessengerService} from "../../-Services-/messenger.service";
import {Observable} from "rxjs";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {User} from "../../-Models-/user";
import {Role} from "../../-Models-/role";
import {FormBuilder, FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProductService} from "../../-Services-/product.service";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  productTemplate: ProductTemplate;
  formGroup: any;
  currentUser: User;

  constructor(private auth: AuthenticationService,
              private formBuilder: FormBuilder,
              private msg: MessengerService,
              private router: Router,
              private product: ProductService) {
  }

  ngOnInit(): void {
    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
    });
    if(this.currentUser && this.currentUser.role === Role.Manager) {
      this.productTemplate = this.msg.currentProductTemplateValue;
      this.formGroup = this.formBuilder.group({
        branchId: new FormControl(this.currentUser.branch.id),
        productTemplateId: new FormControl(this.productTemplate.id),
        startingPrice: new FormControl('', Validators.required),
        price: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),
      });
    }
  }
  onSubmit() {
    if (!this.currentUser && this.currentUser.role !== Role.Manager) {
      this.router.navigate(['login']);
    }
    this.product.createProduct(this.formGroup.value).subscribe( () => {
      this.router.navigate(['']);
    });
  }
}
