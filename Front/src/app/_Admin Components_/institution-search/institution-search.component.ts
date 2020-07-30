import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {Institution} from "../../-Models-/institution";
import {MatTableDataSource} from "@angular/material/table";
import {InstitutionService} from "../../-Services-/institution.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-institution-search',
  templateUrl: './institution-search.component.html',
  styleUrls: ['./institution-search.component.css']
})
export class InstitutionSearchComponent implements OnInit {

  private ELEMENT_DATA: Institution[];
  displayedColumns: string[] = ['id', 'institutionName', 'institutionWebSite', 'institutionLogo'];
  dataSource: MatTableDataSource<Institution>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private user: AuthenticationService,
              private institution: InstitutionService) { }

  ngOnInit(): void {
    if(this.user.currentUserValue.role === Role.Admin) {
      this.getAllInstitutions();
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getAllInstitutions() {
    return this.institution.getAllInstitutions().subscribe( data => {
      this.ELEMENT_DATA = data;
      this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
    })
  }
}
