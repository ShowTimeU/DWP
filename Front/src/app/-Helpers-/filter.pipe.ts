import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if(!args)
      return value;
    return value.filter(
      item => item.productTemplate.productName.toLowerCase().indexOf(args.toLowerCase()) > -1
        ||
        item.productTemplate.institution.institutionName.toLowerCase().indexOf(args.toLowerCase()) > -1);
  }

}
