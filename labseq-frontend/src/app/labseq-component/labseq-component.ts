import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { LabseqService } from '../labseq-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-labseq-component',
  imports: [FormsModule, CommonModule],
  templateUrl: './labseq-component.html',
  styleUrl: './labseq-component.scss',
})
export class LabseqComponent {
  inputN = 0;
  result: string | null = null;
  error: boolean = false;

  private http = inject(HttpClient);
  private labseqService = new LabseqService(this.http);

  calculate() {
    this.labseqService.getLabseq(this.inputN).subscribe({
      next: (value: string) => {
        this.result = value;
        this.error = false;
      },
      error: (error: any) => {
        this.result = error.error;
        this.error = true;
      },
    });
  }
}
