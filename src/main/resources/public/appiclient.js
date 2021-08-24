const appiclient = (function () {

    function getIntraday(symbol, tm, callback) {

        const promise = new Promise((resolve, reject) => {
            $.ajax({
                url: "/getTime/" + symbol + "/"+tm
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