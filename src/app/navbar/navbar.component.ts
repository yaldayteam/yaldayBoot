import { Component} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: [ './navbar.component.css' ]
})
export class NavbarComponent {

  toggleMenu = true;

  onToggleMenu() {
    this.toggleMenu = this.toggleMenu !== true;
  }

}
