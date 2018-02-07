
var exec = require('cordova/exec');

var PLUGIN_NAME = 'moverioBT350';

var moverioBT350 = {
  setCameraLedMode: function (status, successCallback, errorCallback){
        exec(successCallback, errorCallback, PLUGIN_NAME, "setCameraLedMode", [status]);
  }
};

module.exports = moverioBT350;
