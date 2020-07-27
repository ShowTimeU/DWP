import {Injectable} from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {AuthenticationService} from "./authentication.service";

@Injectable({
  providedIn: 'root'
})
export class MessengerService {

  subject = new Subject();
  totalItems = new BehaviorSubject<number>(0);
  currentCount: number = 0;
  cast = this.totalItems.asObservable();

  constructor() {
  }

  sendMsg(product) {
    this.subject.next(product);
  }

  getMsg() {
    return this.subject.asObservable();
  }



  sendNumber(items: number) {
    this.totalItems.next(items);
  }


  editCount(newCount: number) {
    this.currentCount += newCount;
    this.totalItems.next(this.currentCount);
  }
}
