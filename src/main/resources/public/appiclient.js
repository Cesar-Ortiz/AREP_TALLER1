const appiclient = (function () {
    let localhost = "http://localhost:4567";

    function getIntraday(symbol, tm, callback) {

        const promise = new Promise((resolve, reject) => {
            $.ajax({
                url: localhost + "/getTime/" + symbol + "/"+tm,
                type: 'GET',
                contentType: "application/json"
            }).done(function (response) {
                resolve(response);
            }).fail(function (msg) {
                reject(msg);
            });
        });

        promise
            .then(res => {
                callback(res);
            });
    }

    return {
        getIntraday: getIntraday
    }

})();