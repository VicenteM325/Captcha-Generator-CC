import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

  title = 'Captcha Generator Front';
  menuOption: string = '';
  onOption(menuOption: string) {
    this.menuOption = menuOption;
  }
}
