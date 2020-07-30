export class Institution {
  id: number;
  institutionName: string;
  institutionWebSite: string;
  institutionLogo: string;
  institutionDescription: string;

  constructor(id: number,
              institutionName: string,
              institutionWebSite: string,
              institutionLogo: string,
              institutionDescription: string) {
    this.id = id;
    this.institutionName = institutionName;
    this.institutionWebSite = institutionWebSite;
    this.institutionLogo = institutionLogo;
    this.institutionDescription = institutionDescription;
  }
}
