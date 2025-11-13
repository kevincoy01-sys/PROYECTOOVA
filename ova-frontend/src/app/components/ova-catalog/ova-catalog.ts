import { Component, OnInit } from '@angular/core';
import { OvaService, Ova } from '../../services/ova.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ova-catalog',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ova-catalog.html',
  styleUrls: ['./ova-catalog.scss']
})
export class OvaCatalogComponent implements OnInit {
  ovas: Ova[] = [];
  showForm = false;
  newOva: Ova = {
    titulo: '',
    descripcion: '',
    autor: '',
    fechaCreacion: ''
  };

  constructor(private ovaService: OvaService) {}

  ngOnInit() {
    this.loadOvas();
  }

  loadOvas() {
    this.ovaService.getAllOvas().subscribe(response => {
      this.ovas = response;
    });
  }

  toggleForm() {
    this.showForm = !this.showForm;
    if (!this.showForm) {
      this.resetForm();
    }
  }

  createOva() {
    if (this.newOva.titulo && this.newOva.descripcion && this.newOva.autor) {
      this.newOva.fechaCreacion = new Date().toISOString().split('T')[0];
      this.ovaService.createOva(this.newOva).subscribe(() => {
        this.loadOvas();
        this.toggleForm();
      });
    }
  }

  deleteOva(id: number | undefined) {
    if (id && confirm('¿Está seguro de eliminar este OVA?')) {
      this.ovaService.deleteOva(id).subscribe(() => {
        this.loadOvas();
      });
    }
  }

  resetForm() {
    this.newOva = {
      titulo: '',
      descripcion: '',
      autor: '',
      fechaCreacion: ''
    };
  }
}
