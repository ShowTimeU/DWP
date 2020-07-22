import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if(!args)
      return value;
    return value.filter(
      item => item.productName.toLowerCase().indexOf(args.toLowerCase()) > -1
        ||
        item.institution.toLowerCase().indexOf(args.toLowerCase()) > -1);
  }

}
