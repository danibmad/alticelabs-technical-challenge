import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LabseqComponent } from './labseq-component/labseq-component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LabseqComponent, FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('labseq-frontend');
}
