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
  filteredOvas: Ova[] = [];
  showForm = false;
  isEditing = false;
  searchTerm = '';
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
    this.ovaService.getAllOvas().subscribe({
      next: (response) => {
        this.ovas = response;
        this.filteredOvas = response;
      },
      error: (error) => {
        console.error('Error al cargar OVAs:', error);
        alert('Error al cargar las OVAs. Por favor, intente nuevamente.');
      }
    });
  }

  searchOvas() {
    if (!this.searchTerm.trim()) {
      this.filteredOvas = this.ovas;
      return;
    }

    const term = this.searchTerm.toLowerCase();
    this.filteredOvas = this.ovas.filter(ova =>
      ova.titulo.toLowerCase().includes(term) ||
      ova.descripcion.toLowerCase().includes(term) ||
      ova.autor.toLowerCase().includes(term)
    );
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
      
      if (this.isEditing && this.newOva.id) {
        this.updateOva();
      } else {
        this.ovaService.createOva(this.newOva).subscribe({
          next: () => {
            this.loadOvas();
            this.toggleForm();
            alert('OVA creada exitosamente');
          },
          error: (error) => {
            console.error('Error al crear OVA:', error);
            alert('Error al crear la OVA. Por favor, verifique los datos.');
          }
        });
      }
    }
  }

  editOva(ova: Ova) {
    this.newOva = { ...ova };
    this.isEditing = true;
    this.showForm = true;
  }

  updateOva() {
    if (this.newOva.id) {
      this.ovaService.updateOva(this.newOva.id, this.newOva).subscribe({
        next: () => {
          this.loadOvas();
          this.toggleForm();
          alert('OVA actualizada exitosamente');
        },
        error: (error) => {
          console.error('Error al actualizar OVA:', error);
          alert('Error al actualizar la OVA. Por favor, intente nuevamente.');
        }
      });
    }
  }

  deleteOva(id: number | undefined) {
    if (id && confirm('¿Está seguro de eliminar este OVA?')) {
      this.ovaService.deleteOva(id).subscribe({
        next: () => {
          this.loadOvas();
          alert('OVA eliminada exitosamente');
        },
        error: (error) => {
          console.error('Error al eliminar OVA:', error);
          alert('Error al eliminar la OVA. Por favor, intente nuevamente.');
        }
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
    this.isEditing = false;
  }
}
