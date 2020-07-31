import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {Branch} from "../../-Models-/branch";
import {InstitutionService} from "../../-Services-/institution.service";
import {MatTableDataSource} from "@angular/material/table";
import {Role} from "../../-Models-/role";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-branch-search',
    templateUrl: './branch-search.component.html',
    styleUrls: ['./branch-search.component.css']
})
export class BranchSearchComponent implements OnInit {

    private ELEMENT_DATA: Branch[];
    @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
    displayedColumns: string[] = ['id', 'branchCity', 'branchAddress', 'branchPhone', 'branchEmail', 'institutionName', 'userEmail'];
    dataSource: MatTableDataSource<Branch>;
    institutionName: string;
    userEmail: string;

    constructor(private institution: InstitutionService,
                private user: AuthenticationService,
                private router: Router) {
    }

    ngOnInit(): void {
        if (this.user.currentUserValue.role === Role.Admin) {
            this.getAllBranches();
        }
    }

    applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();
    }

    getAllBranches() {
        return this.institution.getAllBranches().subscribe(data => {
            this.ELEMENT_DATA = data;
            this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
            this.dataSource.paginator = this.paginator;
        })
    }

    updateBranchInfo() {
        this.router.navigate(['/branch-info']);
    }
}
