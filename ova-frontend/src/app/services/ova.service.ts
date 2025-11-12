import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OvaService {
  private apiUrl = 'http://localhost:8080/api/ovas';

  constructor(private http: HttpClient) {}

  getAllOvas(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getOvaById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  createOva(ova: { name: string; description: string }): Observable<any> {
    return this.http.post(this.apiUrl, ova);
  }

  deleteOva(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
