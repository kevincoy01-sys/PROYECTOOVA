import { Routes } from '@angular/router';
import { OvaCatalogComponent } from './components/ova-catalog/ova-catalog';
import { AuthFormComponent } from './components/auth-form/auth-form';

export const routes: Routes = [
  { path: 'login', component: AuthFormComponent },
  { path: '', component: OvaCatalogComponent },
  { path: '**', redirectTo: '' }
];
