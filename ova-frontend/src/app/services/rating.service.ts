import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Rating {
  id?: number;
  calificacion: number;
  comentario?: string;
  fechaCreacion?: string;
}

export interface RatingAverage {
  average: number;
}

@Injectable({
  providedIn: 'root',
})
export class RatingService {
  private apiUrl = 'http://localhost:8080/api/ratings';

  constructor(private http: HttpClient) {}

  getAllRatings(): Observable<Rating[]> {
    return this.http.get<Rating[]>(this.apiUrl);
  }

  getRatingById(id: number): Observable<Rating> {
    return this.http.get<Rating>(`${this.apiUrl}/${id}`);
  }

  getRatingsByOvaId(ovaId: number): Observable<Rating[]> {
    return this.http.get<Rating[]>(`${this.apiUrl}/ova/${ovaId}`);
  }

  getAverageRatingByOvaId(ovaId: number): Observable<RatingAverage> {
    return this.http.get<RatingAverage>(`${this.apiUrl}/ova/${ovaId}/average`);
  }

  createRating(ovaId: number, userId: number, rating: Rating): Observable<Rating> {
    return this.http.post<Rating>(`${this.apiUrl}/ova/${ovaId}/user/${userId}`, rating);
  }

  updateRating(id: number, rating: Rating): Observable<Rating> {
    return this.http.put<Rating>(`${this.apiUrl}/${id}`, rating);
  }

  deleteRating(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
