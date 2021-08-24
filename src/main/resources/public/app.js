var app = (function () {

    var time="";
    function getIntraday(symbol, fun, tm) {
        console.log(fun);
        console.log(tm+ "esto es tm");
        time=fun;
        console.log(time);
        const body = $("tbody");
        if (body !== null) {
            body.remove();
        }
        if (symbol != null && symbol != "") {
            appiclient.getIntraday(symbol, tm,actualizarTabla);
        }
    }

    function actualizarTabla(data) {
        var listDtsp = ["1. open", "2. high", "3. low", "4. close", "5. volume"];
        const tabla = $("table");
        const body = $("tbody");
        if (body != null) {
            body.remove();
        }
        tabla.append("<tbody>");
        const tblBody = $("tbody");
        console.log(time);
        var dataTimes = data[time];
        console.log(dataTimes);
        var fila="";
        for(const date in dataTimes){
            fila = fila+'<tr> <td>' + date + '</td>';
            for (const dataesp in listDtsp){
                fila= fila+'<td>'+dataTimes[date][listDtsp[dataesp]]+'</td>'
            }
            fila=fila+'</tr>'
        }
        tblBody.append(fila);

        tabla.append("</tbody>");
    }

    return {
        getIntraday: getIntraday,
        actualizarTabla: actualizarTabla
    }

})();