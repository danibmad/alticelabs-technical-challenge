import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { LabseqService } from '../labseq-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-labseq-component',
  imports: [FormsModule],
  templateUrl: './labseq-component.html',
  styleUrl: './labseq-component.scss',
})
export class LabseqComponent {
  inputN = 0;
  result: number | null = null;

  private http = inject(HttpClient);
  private labseqService = new LabseqService(this.http);

  calculate() {
    this.labseqService.getLabseq(this.inputN).subscribe({
      next: (value: number) => (this.result = value),
      error: (error: any) => console.error(error),
    });
  }
}
