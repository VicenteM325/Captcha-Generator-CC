class Var {
    constructor(type, id, val, mode, process, noExec) {
        this.type = type;
        this.id = id;
        this.val = val;
        this.mode = mode;
        this.process = process;
        this.noExec = noExec;
    }
}

let vars = new Array();
updateTableData();

function setValue(id, process, val) {
    let variable = vars.find(e => e.id == id && e.process == process);
    variable.val = val;
}

function getValue(id, process) {
    let variable = vars.find(e => e.id == id && e.process == process);
    return variable.val;
}

function increaseNoExec(id, process) {
    let variable = vars.find(e => e.id == id && e.process == process);
    variable.noExec = variable.noExec + 1;
}

function addVar(type, id, val, mode, process, noExec) {
    if(vars.find(e => e.id == id && e.process == process) == undefined) {
        vars.push(new Var(type, id, val, mode, process, noExec));
    } else {
        if (mode == "-") {
            let variable = vars.find(e => e.id == id && e.process == process);
            variable.val = val;
        }
    }
}

function CARACTER_ALEATORIO() {
    let code = Math.floor(Math.random() * (122 - 65)) + 65;
    while (code >=91 && code <=96) {
        code = Math.floor(Math.random() * (122 - 65)) + 65;
    }
    return String.fromCharCode(code);
}

function NUM_ALEATORIO() {
    return Math.floor(Math.random() * 1000)
}

function ASC(str) {
    return str.split("").sort().join("");
}

function DESC(str) {
    return str.split("").sort().reverse().join("");
}

function REVERSE(str) {
    return str.split("").reverse().join("");
}

function LETPAR_NUM(str) {
    let array = new Array();
    str.split("").forEach((s, i) => {
        if ((i + 1) % 2 == 0) {
            array.push(s.charCodeAt(0));
        } else {
            array.push(s);
        }
    });
    return array.join("");
}

function LETIMPAR_NUM(str) {
    let array = new Array();
    str.split("").forEach((s, i) => {
        if ((i + 1) % 2 != 0) {
            array.push(s.charCodeAt(0));
        } else {
            array.push(s);
        }
    });
    return array.join("");
}
// Incrementar los faults y redirigir
function EXIT(idCaptcha) {
    // Realizar una solicitud POST para incrementar los faults
    fetch(`http://localhost:8080/api/captchas/faults?id=${idCaptcha}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: idCaptcha })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al incrementar faults');
        }
        window.location.href = `http://localhost:4200/captchas/`;
    })
    .catch(error => {
        console.error('Error:', error);
        alert('No se pudo incrementar los faults');
    });
}

// Incrementar los hits y redirigir
function REDIRECT(link, idCaptcha) {
    // Realizar una solicitud POST para incrementar los hits en el backend
    fetch(`http://localhost:8080/api/captchas/hits?id=${idCaptcha}&link=${encodeURIComponent(link)}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al incrementar los hits');
        }
        window.location.href = `http://localhost:4200/captchas/`;
        window.open(link, '_blank'); 
    })
    .catch(error => {
        console.error('Error:', error);
        alert('No se pudo incrementar los hits.');
    });
}

function updateTableData(){
    let tableBody = document.querySelector('#tableBody');
    tableBody.innerHTML = "";
    let content = new Array();
    vars.forEach((e, i) => {
        content.push("<tr>");
        content.push("\t<td>" + (i + 1) + "</td>");
        content.push("\t<td>" + e.type + "</td>");
        content.push("\t<td>" + e.id + "</td>");
        content.push("\t<td>" + e.val + "</td>");
        content.push("\t<td>" + e.mode + "</td>");
        content.push("\t<td>" + e.process + "</td>");
        content.push("\t<td>" + e.noExec + "</td>");
        content.push("</tr>");
    });
    tableBody.innerHTML = content.join("");
}

function increaseNoExecs(process) {
    vars.forEach(e => {
        if (e.process == process) {
            increaseNoExec(e.id, process);
        }
    });
}