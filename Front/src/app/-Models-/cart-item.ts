import {Product} from "./product";
import {ProductTemplate} from "./product-template";
import {Institution} from "./institution";
import {Branch} from "./branch";

export class CartItem {
  productId: number;
  quantity: number;
  institution: Institution;
  product: Product;
  productTemplate: ProductTemplate;
  branch: Branch;


  constructor(product: Product,
              productTemplate: ProductTemplate,
              institution: Institution,
              branch: Branch,
              quantity= 1) {
    this.productId = product.id;
    this.quantity = quantity;
    this.institution = institution;
    this.product = product;
    this.productTemplate = productTemplate;
    this.branch = branch;
  }
}
