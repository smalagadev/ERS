import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserService } from './../../services/user.service';
import { User } from './../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout-form',
  templateUrl: './logout-form.component.html',
  styleUrls: ['./logout-form.component.css']
})
export class LogoutFormComponent implements OnInit {

  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  @Output() public loggedOut = new EventEmitter();

  logOut(): void {
    // After testing fully implements

    event.preventDefault();
    // if successful
    // this.us.logout();
    this.isLoggedIn = false;
    this.loggedOut.emit(this.isLoggedIn);
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['']);
  }

  close(): void {
    event.preventDefault();

  }
}
