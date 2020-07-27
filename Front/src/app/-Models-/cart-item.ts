import {Product} from "./product";

export class CartItem {
  productId: number;
  productName: string;
  quantity: number;
  price: number;
  image?: string;
  description?: string;
  institution?: string;
  area?: string;


  constructor(product: Product, quantity= 1) {
    this.productId = product.id;
    this.productName = product.productName;
    this.quantity = quantity;
    this.price = product.price;
    this.image = product.image;
    this.description = product.description;
    this.institution = product.institution;
    this.area = product.area;
  }
}
