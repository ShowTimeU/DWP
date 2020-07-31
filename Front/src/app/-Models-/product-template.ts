import {Institution} from "./institution";

export class ProductTemplate {
  id: number;
  productName: string;
  productDescription: string;
  productImage: string;
  institution: any;

  constructor(id: number,
              productName: string,
              productDescription: string,
              productImage: string,
              institution: Institution) {
    this.id = id;
    this.productName = productName;
    this.productDescription = productDescription;
    this.productImage = productImage;
    this.institution = institution;
  }
}
