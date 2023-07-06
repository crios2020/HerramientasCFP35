function ActualizarHora() {
    var fecha = new Date();
    var segundos = fecha.getSeconds();
    var minutos = fecha.getMinutes();
    var horas = fecha.getHours();

    var elementoHoras = document.getElementById("pHoras");
    var elementoMinutos = document.getElementById("pMinutos");
    var elementoSegundos = document.getElementById("pSegundos");

    elementoHoras.textContent = horas.toString().padStart(2, "0");
    elementoMinutos.textContent = minutos.toString().padStart(2, "0");
    elementoSegundos.textContent = segundos.toString().padStart(2, "0");


}

setInterval(ActualizarHora, 1000);