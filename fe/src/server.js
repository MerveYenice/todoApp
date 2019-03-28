// https://www.npmjs.com/package/node-static
var static = require('node-static');

var fileServer = new static.Server('./src/public');

require('http').createServer(function (request, response) {
    request.addListener('end', function () {
        fileServer.serve(request, response, function(){
            console.log("new request:"+request.url);
        });
    }).resume();
}).listen(8079);

console.log("serving at 8079");

