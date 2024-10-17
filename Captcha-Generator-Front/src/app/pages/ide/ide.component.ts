import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';

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

  @ViewChild('lineNumbersRef') lineNumbersRef!: ElementRef;

  ngOnInit() {
    this.updateLineNumbers();
  }

  updateLineNumbers() {
    const lines = this.textValue.split('\n').length;
    this.lineNumbers = Array.from({ length: lines }, (_, i) => i ).join('<br>');
  }

  syncScroll(event: any) {
    this.lineNumbersRef.nativeElement.scrollTop = event.target.scrollTop;
  }

  updateCursorPosition(event: any) {
    const textarea = event.target;
    const textBeforeCursor = textarea.value.substring(0, textarea.selectionStart);
    const lines = textBeforeCursor.split('\n');
    
    this.cursorLine = lines.length;
    this.cursorColumn = lines[lines.length - 1].length + 1;
  }
}
