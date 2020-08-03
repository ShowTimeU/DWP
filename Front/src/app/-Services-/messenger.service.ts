import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {AuthenticationService} from "./authentication.service";
import {ProductTemplate} from "../-Models-/product-template";
import {User} from "../-Models-/user";

@Injectable({
  providedIn: 'root'
})
export class MessengerService {

  subject = new Subject();
  totalItems = new BehaviorSubject<number>(0);
  currentCount: number = 0;

  private currentProductTemplateSubj: BehaviorSubject<ProductTemplate>;
  public currentProductTemplate: Observable<ProductTemplate>;

  constructor() {
    this.currentProductTemplateSubj = new BehaviorSubject<ProductTemplate>(JSON.parse(sessionStorage.getItem('currentProductTemplate')));
    this.currentProductTemplate = this.currentProductTemplateSubj.asObservable();
  }

  public get currentProductTemplateValue(): ProductTemplate {
    return this.currentProductTemplateSubj.value;
  }

  public sendProductTemplateValue(productTemplate: ProductTemplate) {
    sessionStorage.setItem('currentProductTemplate', JSON.stringify(productTemplate));
    return this.currentProductTemplateSubj.next(productTemplate);
  }

  sendMsg(product) {
    this.subject.next(product);
  }

  getMsg() {
    return this.subject.asObservable();
  }

  editCount(newCount: number) {
    this.currentCount += newCount;
    this.totalItems.next(this.currentCount);
  }
}
