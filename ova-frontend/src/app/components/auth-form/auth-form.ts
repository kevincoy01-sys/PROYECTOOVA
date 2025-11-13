import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.html',
  styleUrls: ['./auth-form.scss']
})
export class AuthFormComponent {
  username: string = '';
  password: string = '';
  isLoginMode: boolean = true;
  error: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    const credentials = { username: this.username, password: this.password };
    if (this.isLoginMode) {
      this.authService.login(credentials).subscribe({
        next: (response) => {
          if (response.token) {
            this.authService.setToken(response.token);
            this.router.navigate(['/']);
          }
        },
        error: (err) => {
          this.error = err.error?.error || 'Credenciales inválidas';
        }
      });
    } else {
      this.authService.register(credentials).subscribe({
        next: (response) => {
          this.isLoginMode = true;
          this.error = '';
        },
        error: (err) => {
          this.error = err.error?.error || 'Error al registrar';
        }
      });
    }
  }

  toggleMode() {
    this.isLoginMode = !this.isLoginMode;
    this.error = '';
  }
}
