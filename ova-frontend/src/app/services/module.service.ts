import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Module {
  id?: number;
  titulo: string;
  descripcion: string;
  orden: number;
}

@Injectable({
  providedIn: 'root',
})
export class ModuleService {
  private apiUrl = 'http://localhost:8080/api/modules';

  constructor(private http: HttpClient) {}

  getAllModules(): Observable<Module[]> {
    return this.http.get<Module[]>(this.apiUrl);
  }

  getModuleById(id: number): Observable<Module> {
    return this.http.get<Module>(`${this.apiUrl}/${id}`);
  }

  getModulesByOvaId(ovaId: number): Observable<Module[]> {
    return this.http.get<Module[]>(`${this.apiUrl}/ova/${ovaId}`);
  }

  createModule(ovaId: number, module: Module): Observable<Module> {
    return this.http.post<Module>(`${this.apiUrl}/ova/${ovaId}`, module);
  }

  updateModule(id: number, module: Module): Observable<Module> {
    return this.http.put<Module>(`${this.apiUrl}/${id}`, module);
  }

  deleteModule(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
