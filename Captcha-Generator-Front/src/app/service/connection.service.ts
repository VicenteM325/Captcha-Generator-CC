import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  private apiUrl = 'http://localhost:8080/api/processCode';
  constructor(private http: HttpClient) { }

  processCode(code: string): Observable<{message:string}> {
    const headers = new HttpHeaders({ 'Content-Type' : 'application/json' });
    return this.http.post<{ message: string }>(this.apiUrl, { code }, { headers });
  }
}
