import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TesteGitComponent } from './teste-git.component';

describe('TesteGitComponent', () => {
  let component: TesteGitComponent;
  let fixture: ComponentFixture<TesteGitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TesteGitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TesteGitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
