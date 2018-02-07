
var exec = require('cordova/exec');

var PLUGIN_NAME = 'moverioBT350';

var moverioBT350 = {
  saludo: function (name, successCallback, errorCallback){
        exec(successCallback, errorCallback, PLUGIN_NAME, "saludar", [name]);
  }
};

module.exports = moverioBT350;
