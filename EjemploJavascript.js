function crearCookie(nombreCookie, valorCookie, diasdevida) {
    var segundos = diasdevida * 60 * 60 * 24;
    var valorFinal = valorCookie + ((diasdevida == null) ? "" : "; max-age=" + String(segundos));
    var textofinal = nombreCookie + "=" + valorFinal + ";path=/";
    document.cookie = textofinal;
}


function leerCookie(nombreBuscado) {
    var limpio, i, nombre, valor;
    alert(document.cookie);
    var todaslascookies = document.cookie.split(";");
    for (i in todaslascookies) {
        limpio = todaslascookies[i].trim();
        nombre = limpio.substr(0, limpio.indexOf("="));
        valor = limpio.substr(limpio.indexOf("=") + 1);
        if (nombre == nombreBuscado) {
            return valor;
        }
    }
    return "";
}

function borrarCookie(nombreBuscado) {
    document.cookie = nombreBuscado + "= ;    expires = Mon, 1 Jan 1990 00: 00: 00 UTC;    path = /;";
}


function crearCookie(nombreCookie, valorCookie, diasdevida) {
    var fechaCaducidad = new Date();
    fechaCaducidad.setDate(fechaCaducidad.getDate() + diasdevida);
    var valorFinal = valorCookie + ((diasdevida == null) ? "" : "; expires=" + fechaCaducidad.toUTCString());
    document.cookie = nombreCookie + "=" + valorFinal + ";path=/";
}


var mimapa = new Map();
var precios = new Map([
    ["lapiz", 4],
    ["boli", 8],
    ["goma", 2]
]);

mimapa.set("alfa", 32432);
mimapa.set("beta", 534);
mimapa.set(12, "un valor");

mimapa.delete("beta");

var valor = mimapa.get("alfa");
mimapa.set("nuevo", 555);
mimapa.set("alfa", 123456);

var cuantos = mimapa.size;
var existe = mimapa.has("beta");


var lasclaves = mimapa.keys();  // crea un map iterator
var losvalores = mimapa.values(); // crea un map iterator

console.log(Array.from(lasclaves));  // convertido en array

precios.forEach(function (valor, clave) {
    console.log("el producto es " + clave);
    console.log("el valor es  " + valor);
})

for (var [clave, valor] of precios) {
    console.log("el producto es " + clave);
    console.log("el valor es  " + valor);
}

for (const cadaelemento of precios.entries()) {
    console.log(cadaelemento);
    console.log(cadaelemento[0]);
    console.log(cadaelemento[1]);
}


for (var [clave, valor] of mimapa) {
    console.log("el producto es " + clave);
    console.log("el valor es  " + valor);
}


console.log("---------------------------------------");

var cosas = new Set(["lapiz", "boli", "goma"]);

console.log(cosas.size);


cosas.forEach(function (valor) {
    console.log("el valor es  " + valor);
})

for (var elemento of cosas) {
    console.log("el valor es  " + elemento);
}

for (const cadaelemento of cosas.values()) {
    console.log(cadaelemento);
}


var conjunto_A = new Set([1, 2, 3, 4]);
var conjunto_B = new Set([2, 3]);
var conjunto_C = new Set([3, 4, 5, 6]);


var res = conjunto_A.isSuperset(conjunto_B);    // => true
console.log(res);
var res = conjunto_A.union(conjunto_C);         // => Set [1, 2, 3, 4, 5, 6]
console.log(res);
var res = conjunto_A.intersection(conjunto_C); // => Set [3, 4]
console.log(res);
var res = conjunto_A.difference(conjunto_C); // => Set [1, 2]
console.log(res);



window.onload = inicio;

function inicio() {
    document.getElementById('subir').addEventListener('click', subir);
    document.getElementById('bajar').addEventListener('click', bajar);
}

function subir() {
    var laselect = document.getElementById('marcacoches');
    var elementoelegido = laselect.options[laselect.selectedIndex];
    var hermanoanterior = elementoelegido.previousElementSibling;
    if (hermanoanterior != null) {
        elementoelegido.remove();
        var padre = hermanoanterior.parentNode;
        padre.insertBefore(elementoelegido, hermanoanterior)
    }
}

function bajar() {
    var laselect = document.getElementById('marcacoches');
    var elementoelegido = laselect.options[laselect.selectedIndex];
    var hermanosiguiente = elementoelegido.nextElementSibling;
    if (hermanosiguiente != null) {
        elementoelegido.remove();
        var padre = hermanosiguiente.parentNode;
        padre.insertBefore(elementoelegido, hermanosiguiente.nextElementSibling)
    }
}