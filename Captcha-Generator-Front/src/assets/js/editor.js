'use strict';

const btnReset = document.querySelector('#reset');
const inputFile = document.querySelector('#archivoEntrada');
const inputText = document.querySelector('#inputText');
const analyzeText = document.querySelector('#analyzeText');
const position = document.querySelector('#position');

let codeEditor = ace.edit("textEditor");

let editorLib = {
    init() {
        codeEditor.setValue('');

        //Tema
        codeEditor.setTheme("ace/theme/merbivore");

        //Language
        codeEditor.session.setMode("ace/mode/html_ruby");

        //Options
        codeEditor.setOptions({
            fontFamily: 'Inconsolata',
            fontSize: '12pt',
            printMarginColumn: 100
        });
    }
};

codeEditor.getSession().on('change', () => {
    inputText.innerHTML = codeEditor.getValue();
    analyzeText.innerHTML = codeEditor.getValue();
});

codeEditor.session.selection.on('changeCursor', function(e) {
    const line = codeEditor.getCursorPosition().row;
    const column = codeEditor.getCursorPosition().column;
    position.innerHTML = 'Current position: ' + (line + 1) + ' - ' + (column + 1);
});

btnReset.addEventListener('click', () => {
    codeEditor.setValue('');
    inputFile.value = '';
});

function loadText () {
    codeEditor.setValue(analyzeText.value);
}

editorLib.init();