import {Branch} from "./branch";
import {ProductTemplate} from "./product-template";

export class Product {
  id: number;
  startingPrice: number;
  price: number;
  quantity: number;
  totalPrice: number;
  branchId: number;
  productTemplateId: number;

  constructor(id: number,
              startingPrice: number,
              price: number,
              quantity: number,
              branch: Branch,
              productTemplate: ProductTemplate,
              totalPrice: number) {
    this.id = id;
    this.startingPrice = startingPrice;
    this.price = price;
    this.quantity = quantity;
    this.branchId = branch.id;
    this.productTemplateId = productTemplate.id;
    this.totalPrice = totalPrice * quantity;
  }
}
