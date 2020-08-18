import {Product} from "./product";
import {ProductTemplate} from "./product-template";
import {Institution} from "./institution";
import {Branch} from "./branch";

export class CartItem {
  id: string;
  productId: number;
  quantity: number;
  institution: Institution;
  product: Product;
  productTemplate: ProductTemplate;
  branch: Branch;


  constructor(id: string,
              product: Product,
              productTemplate: ProductTemplate,
              institution: Institution,
              branch: Branch,
              quantity= 1) {
    this.id = id;
    this.productId = product.id;
    this.quantity = quantity;
    this.institution = institution;
    this.product = product;
    this.productTemplate = productTemplate;
    this.branch = branch;
  }
}
