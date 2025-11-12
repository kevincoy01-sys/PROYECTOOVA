import { Component, OnInit } from '@angular/core';
import { OvaService } from '../../services/ova.service';

@Component({
  selector: 'app-ova-catalog',
  templateUrl: './ova-catalog.html',
  styleUrls: ['./ova-catalog.scss']
})
export class OvaCatalogComponent implements OnInit {
  ovas: any[] = [];

  constructor(private ovaService: OvaService) {}

  ngOnInit() {
    this.loadOvas();
  }

  loadOvas() {
    this.ovaService.getAllOvas().subscribe(response => {
      this.ovas = response;
    });
  }

  deleteOva(id: number) {
    this.ovaService.deleteOva(id).subscribe(() => {
      this.loadOvas();
    });
  }
}
