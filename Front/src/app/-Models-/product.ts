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
  product: Product;

  constructor(id: number,
              startingPrice: number,
              price: number,
              quantity: number,
              branch: Branch,
              productTemplate: ProductTemplate,
              totalPrice: number,
              product: Product) {
    this.id = id;
    this.startingPrice = startingPrice;
    this.price = price;
    this.quantity = quantity;
    this.branch = branch;
    this.productTemplate = productTemplate;
    this.product = product;
    this.totalPrice = totalPrice * quantity;
  }
}
