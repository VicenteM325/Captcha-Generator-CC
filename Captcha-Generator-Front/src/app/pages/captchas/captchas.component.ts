import { Component, OnInit } from '@angular/core';
import { CaptchaService } from '../../service/captcha/captcha.service';
import { Captcha } from './captcha.model';

@Component({
  selector: 'app-captchas',
  templateUrl: './captchas.component.html',
  styleUrl: './captchas.component.css'
})
export class CaptchasComponent implements OnInit {
  captchas: Captcha[] = [];
  consoleOutput: string = '';
  selectedCaptcha: Captcha | null = null;

  constructor(private captchaService: CaptchaService) { }

  ngOnInit(): void {
    this.loadCaptchas();
  }

  // Cargar los captchas
  loadCaptchas(): void {
    this.captchaService.getCaptchas().subscribe(
      (response) => {
        this.captchas = response;
      },
      (error) => {
        console.error('Error al cargar captchas:', error);
        this.consoleOutput = 'Error al cargar captchas.';
      }
    );
  }

  // Redirigir un captcha
  redirectCaptcha(id: string): void {
    this.captchaService.redirectCaptcha(id).subscribe(
      (response: any) => {
        const redirectUrl = response.url;
        window.location.href = redirectUrl; 
      },
      (error) => {
        console.error('Error al redirigir captcha:', error);
        this.consoleOutput = 'Error al redirigir captcha.';
      }
    );
  }

  // Incrementar hits
  incrementHits(id: string, link: string): void {
    this.captchaService.incrementHits(id, link).subscribe(
      () => {
        this.consoleOutput = 'Hits incrementados correctamente.';
      },
      (error) => {
        console.error('Error al incrementar hits:', error);
        this.consoleOutput = 'Error al incrementar hits.';
      }
    );
  }

  // Incrementar faults
  incrementFaults(id: string): void {
    this.captchaService.incrementFaults(id).subscribe(
      () => {
        this.consoleOutput = 'Faults incrementados correctamente.';
      },
      (error) => {
        console.error('Error al incrementar faults:', error);
        this.consoleOutput = 'Error al incrementar faults.';
      }
    );
  }

  // Mostrar detalles del captcha
  showDetails(captcha: Captcha): void {
    this.selectedCaptcha = captcha;
  }

  // Limpiar los detalles
  clearDetails(): void {
    this.selectedCaptcha = null; 
  }


}
