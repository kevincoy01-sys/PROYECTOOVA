import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.html',
  styleUrls: ['./auth-form.scss']
})
export class AuthFormComponent {
  username: string = '';
  password: string = '';
  isLoginMode: boolean = true;

  constructor(private authService: AuthService) {}

  onSubmit() {
    const credentials = { username: this.username, password: this.password };
    if (this.isLoginMode) {
      this.authService.login(credentials).subscribe(response => {
        console.log('Login successful:', response);
      });
    } else {
      this.authService.register(credentials).subscribe(response => {
        console.log('Registration successful:', response);
      });
    }
  }

  toggleMode() {
    this.isLoginMode = !this.isLoginMode;
  }
}
