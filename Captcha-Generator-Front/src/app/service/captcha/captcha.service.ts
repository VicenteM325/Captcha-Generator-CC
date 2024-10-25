import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Captcha } from '../../pages/captchas/captcha.model';

@Injectable({
  providedIn: 'root',
})
export class CaptchaService {
  private baseUrl = 'http://localhost:8080/api/captchas';

  constructor(private http: HttpClient) {}

  getCaptchas(): Observable<Captcha[]> {
    return this.http.get<Captcha[]>(this.baseUrl); // Hacer la solicitud GET
  }

  // Redirigir captcha
  redirectCaptcha(id: string): Observable<any> {
    const params = new HttpParams().set('id', id); // Agregar el id como parámetro
    return this.http.post<any>(`${this.baseUrl}/redirect`, null, { params });
  }

  // Incrementar hits
  incrementHits(id: string, link: string): Observable<void> {
    const params = new HttpParams()
      .set('id', id)
      .set('link', link); 
    return this.http.post<void>(`${this.baseUrl}/hits`, null, { params });
  }

  // Incrementar faults
  incrementFaults(id: string): Observable<void> {
    const params = new HttpParams().set('id', id); 
    return this.http.post<void>(`${this.baseUrl}/faults`, null, { params });
  }
}
