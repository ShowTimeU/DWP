import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthenticationService} from "../../-Services-/authentication.service";
import {User} from "../../-Models-/user";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {BehaviorSubject} from "rxjs";
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit{

  private ELEMENT_DATA: User[];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private user: AuthenticationService) {
  }

  ngOnInit(): void {
    this.getAllUsers();
  }

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email', 'phone'];
  dataSource: MatTableDataSource<User>;


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getAllUsers() {
    return this.user.getAllUsers().subscribe( data => {
      this.ELEMENT_DATA = data;
      this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
      console.log(this.ELEMENT_DATA)
    })
  }

}
