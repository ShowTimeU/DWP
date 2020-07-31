import {Branch} from "./branch";
import {ProductTemplate} from "./product-template";

export class Product {
  id: number;
  startingPrice: number;
  price: number;
  quantity: number;
  totalPrice: number;
  branch: Branch;
  productTemplate: ProductTemplate;

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
    this.branch = branch;
    this.productTemplate = productTemplate;
    this.totalPrice = totalPrice * quantity;
  }
}
