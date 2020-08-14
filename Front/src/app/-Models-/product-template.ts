import {Institution} from "./institution";
import {KitchenType} from "./kitchen-type";
import {DishType} from "./dish-type";

export class ProductTemplate {
  id: number;
  productName: string;
  productDescription: string;
  productImage: string;
  institution: any;
  kitchenType: any;
  dishType: any;
  kosher: boolean;
  vegetarian: boolean;
  vegan: boolean;


  constructor(id: number,
              productName: string,
              productDescription: string,
              productImage: string,
              institution: Institution,
              kitchenType: KitchenType,
              dishType: DishType,
              kosher: boolean,
              vegetarian: boolean,
              vegan: boolean) {
    this.id = id;
    this.productName = productName;
    this.productDescription = productDescription;
    this.productImage = productImage;
    this.institution = institution;
    this.kitchenType = kitchenType;
    this.dishType = dishType;
    this.kosher = kosher;
    this.vegetarian = vegetarian;
    this.vegan =  vegan;
  }
}
