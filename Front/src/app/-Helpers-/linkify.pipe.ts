import { Pipe, PipeTransform } from '@angular/core';
import linkifyStr from 'linkifyjs/string';

@Pipe({
  name: 'linkify'
})
export class LinkifyPipe implements PipeTransform {

  transform(str: any): any {
    return str ? linkifyStr(str, {target: '_system'}) : str;
  }

}
