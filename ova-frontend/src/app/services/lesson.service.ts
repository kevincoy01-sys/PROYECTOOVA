import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Lesson {
  id?: number;
  titulo: string;
  contenido: string;
  orden: number;
}

@Injectable({
  providedIn: 'root',
})
export class LessonService {
  private apiUrl = 'http://localhost:8080/api/lessons';

  constructor(private http: HttpClient) {}

  getAllLessons(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(this.apiUrl);
  }

  getLessonById(id: number): Observable<Lesson> {
    return this.http.get<Lesson>(`${this.apiUrl}/${id}`);
  }

  getLessonsByModuleId(moduleId: number): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(`${this.apiUrl}/module/${moduleId}`);
  }

  createLesson(moduleId: number, lesson: Lesson): Observable<Lesson> {
    return this.http.post<Lesson>(`${this.apiUrl}/module/${moduleId}`, lesson);
  }

  updateLesson(id: number, lesson: Lesson): Observable<Lesson> {
    return this.http.put<Lesson>(`${this.apiUrl}/${id}`, lesson);
  }

  deleteLesson(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
