import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  @Output() search = new EventEmitter<string>();
  searchName: string = '';

  onSearch(): void {
    this.search.emit(this.searchName.trim());
    
  }

}
