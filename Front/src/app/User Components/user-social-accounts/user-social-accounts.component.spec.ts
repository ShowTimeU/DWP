import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSocialAccountsComponent } from './user-social-accounts.component';

describe('UserSocialAccountsComponent', () => {
  let component: UserSocialAccountsComponent;
  let fixture: ComponentFixture<UserSocialAccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserSocialAccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSocialAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
