import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

interface ProcessCodeResponse {
  message?: string;
  errores?: any[];
  vars?: any[];
  inputText?: string;
}

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  private apiUrl = 'http://localhost:8080/api/processCode';
  constructor(private http: HttpClient) { }

  processCode(code: string): Observable<ProcessCodeResponse> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<ProcessCodeResponse>(this.apiUrl, code, { headers });
  }
}
