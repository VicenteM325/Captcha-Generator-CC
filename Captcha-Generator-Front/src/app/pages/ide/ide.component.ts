import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import { ConnectionService } from '../../service/connection.service';

@Component({
  selector: 'app-ide',
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css'],
})
export class IdeComponent implements OnInit {
  textValue: string = '';
  lineNumbers: string = '0';
  cursorLine: number = 1;
  cursorColumn: number = 1;
  consoleOutput: string='';
  errores: any[] = [];
  variables: any[] = [];
  showTable: boolean = false;
  showTableButton: boolean=false;

  @ViewChild('lineNumbersRef') lineNumbersRef!: ElementRef;
  constructor(private connectionService: ConnectionService) {}

  triggerFileInput(): void {
    const fileInput = document.getElementById('fileInput') as HTMLInputElement;
    fileInput.click();
  }

  ngOnInit() {
    this.updateLineNumbers();
  }

  showVariablesTable(): void {
    this.showTable = true;
  }

  closeVariablesTable(): void {
    this.showTable = false;
  }

  updateLineNumbers() {
    const lines = this.textValue.split('\n').length;
    this.lineNumbers = Array.from({ length: lines }, (_, i) => i).join('<br>');
  }

  syncScroll(event: any) {
    this.lineNumbersRef.nativeElement.scrollTop = event.target.scrollTop;
  }

  updateCursorPosition(event: any) {
    const textarea = event.target;
    const textBeforeCursor = textarea.value.substring(
      0,
      textarea.selectionStart
    );
    const lines = textBeforeCursor.split('\n');

    this.cursorLine = lines.length;
    this.cursorColumn = lines[lines.length - 1].length + 1;
  }

  loadFile(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e) => {
        this.textValue = e.target?.result as string;
        this.updateLineNumbers();
      };
      reader.readAsText(file);
    }
  }

  saveFile(): void {
    const blob = new Blob([this.textValue], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'archivo_modificado.cc';
    link.click();
  }

  clearText(): void {
    this.textValue = '';
    this.cursorLine = 1;
    this.cursorColumn = 1;
    this.updateLineNumbers();
    this.consoleOutput = '';
    this.showTableButton=false;
  }
  //Metodo para analizar el contenido del IDE
  generate(): void { 
    this.connectionService.processCode(this.textValue).subscribe(
      (response) => {
        if (response.errores && response.errores.length > 0) {
          
          this.errores = response.errores;
          this.consoleOutput = this.errores.map(error => 
            `Tipo de error: ${error.tipoError}\n` +
            `Descripción: ${error.descripcion}\n` +
            `Línea: ${error.linea}, Columna: ${error.columna}\n` +
            `Solución: ${error.solucion}\n`
          ).join('\n--------------------\n');
          this.showTableButton=false;
        } else {
          
          this.variables = response.vars ?? [];
          this.errores = [];
  
         
          if (this.variables.length > 0) {
           // this.consoleOutput = 'Variables analizadas:\n' + 
             //                    this.variables.map(variable => 
               //                    `ID: ${variable.id}, Tipo: ${variable.tipo}, Modo: ${variable.mode}`
                 //                ).join('\n');
              this.consoleOutput = 'Captcha creado exitosamente';
              this.showTableButton=true;
          } 
        }
        console.log('Respuesta del backend: ', response);
      },
      (error) => {
        console.error('Error al procesar el código: ', error);
        this.consoleOutput = 'Error al procesar el código.';
      }
    );
  }
  
}
