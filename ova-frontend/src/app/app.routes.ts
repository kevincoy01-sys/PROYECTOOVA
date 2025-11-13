import { Routes } from '@angular/router';
import { OvaCatalogComponent } from './components/ova-catalog/ova-catalog';

export const routes: Routes = [
  { path: '', component: OvaCatalogComponent },
  { path: '**', redirectTo: '' }
];
