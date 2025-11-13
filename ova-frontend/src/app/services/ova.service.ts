import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Ova {
  id?: number;
  titulo: string;
  descripcion: string;
  autor: string;
  fechaCreacion: string;
}

@Injectable({
  providedIn: 'root',
})
export class OvaService {
  private apiUrl = 'http://localhost:8080/api/ovas';

  constructor(private http: HttpClient) {}

  getAllOvas(): Observable<Ova[]> {
    return this.http.get<Ova[]>(this.apiUrl);
  }

  getOvaById(id: number): Observable<Ova> {
    return this.http.get<Ova>(`${this.apiUrl}/${id}`);
  }

  createOva(ova: Ova): Observable<Ova> {
    return this.http.post<Ova>(this.apiUrl, ova);
  }

  updateOva(id: number, ova: Ova): Observable<Ova> {
    return this.http.put<Ova>(`${this.apiUrl}/${id}`, ova);
  }

  deleteOva(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
