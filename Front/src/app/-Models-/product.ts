export class Product {
  id: number;
  institution: string;
  productName: string;
  description: string;
  startingPrice: number;
  price: number;
  quantity: number;
  area: string;
  totalPrice: number;
  image?: string;
  institutionLogo?: string;

  constructor(id: number, productName: string, description: string, image: string, startingPrice: number,
              price: number, area: string, institution: string, quantity: number, totalPrice: number, institutionLogo: string) {
    this.id = id;
    this.productName = productName;
    this.description = description;
    this.image = image;
    this.startingPrice = startingPrice;
    this.price = price;
    this.area = area;
    this.institution = institution;
    this.institutionLogo = institutionLogo;
    this.quantity = quantity;
    this.totalPrice = totalPrice*quantity;
  }
}
