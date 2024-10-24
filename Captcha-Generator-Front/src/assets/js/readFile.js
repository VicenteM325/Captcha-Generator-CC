function processFile(files) {
    var file = files[0];
    var reader = new FileReader();
    reader.readAsText(file);
    reader.onload = (e) => {
        let texto = e.target.result.toString();
        const codeEditor = ace.edit("textEditor");
        codeEditor.setValue(texto);
    };
}