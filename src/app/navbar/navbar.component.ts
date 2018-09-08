import { Component} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: [ './navbar.component.css' ]
})
export class NavbarComponent {

  toggleMenu = true;


  onToggleMenu() {
    if (this.toggleMenu === true){
      this.toggleMenu = false;
    } else {
      this.toggleMenu = true;
    }
  }



}
