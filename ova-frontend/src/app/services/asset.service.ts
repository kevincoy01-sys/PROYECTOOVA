import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export enum AssetType {
  PDF = 'PDF',
  IMAGE = 'IMAGE',
  VIDEO = 'VIDEO'
}

export interface Asset {
  id?: number;
  nombre: string;
  tipo: AssetType;
  url: string;
  descripcion?: string;
}

@Injectable({
  providedIn: 'root',
})
export class AssetService {
  private apiUrl = 'http://localhost:8080/api/assets';

  constructor(private http: HttpClient) {}

  getAllAssets(): Observable<Asset[]> {
    return this.http.get<Asset[]>(this.apiUrl);
  }

  getAssetById(id: number): Observable<Asset> {
    return this.http.get<Asset>(`${this.apiUrl}/${id}`);
  }

  getAssetsByLessonId(lessonId: number): Observable<Asset[]> {
    return this.http.get<Asset[]>(`${this.apiUrl}/lesson/${lessonId}`);
  }

  getAssetsByType(tipo: AssetType): Observable<Asset[]> {
    return this.http.get<Asset[]>(`${this.apiUrl}/type/${tipo}`);
  }

  createAsset(lessonId: number, asset: Asset): Observable<Asset> {
    return this.http.post<Asset>(`${this.apiUrl}/lesson/${lessonId}`, asset);
  }

  updateAsset(id: number, asset: Asset): Observable<Asset> {
    return this.http.put<Asset>(`${this.apiUrl}/${id}`, asset);
  }

  deleteAsset(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
