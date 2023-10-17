function ActualizarHora() {
    let fecha = new Date();
    let segundos = fecha.getSeconds();
    let minutos = fecha.getMinutes();
    let horas = fecha.getHours();

    let elementoHoras = document.getElementById("pHoras");
    let elementoMinutos = document.getElementById("pMinutos");
    let elementoSegundos = document.getElementById("pSegundos");

    elementoHoras.textContent = horas.toString().padStart(2, "0");
    elementoMinutos.textContent = minutos.toString().padStart(2, "0");
    elementoSegundos.textContent = segundos.toString().padStart(2, "0");

    let hora=   horas.toString().padStart(2, "0")+":"+
                minutos.toString().padStart(2, "0")+":"+
                segundos.toString().padStart(2, "0")
    try{
        document.getElementById('hora').setAttribute('value',hora)
    }catch(e){}
            
}

setInterval(ActualizarHora, 1000);


function confirmarEliminacion() {
    return window.confirm("¿Estás seguro de que deseas eliminar?");
}

function confirmarDevolucion() {
    return window.confirm("¿Estás seguro de que deseas devolver?");
}

function get_ip(obj){
    try{
        document.getElementById('ip').setAttribute('value',obj.ip)
    }catch(e){}  
}