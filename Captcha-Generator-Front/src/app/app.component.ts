import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

  title = 'Captcha Generator CC';
  menuOption: string = '';
  onOption(menuOption: string) {
    this.menuOption = menuOption;
  }
}
