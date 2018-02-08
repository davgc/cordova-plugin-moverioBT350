
var exec = require('cordova/exec');

var PLUGIN_NAME = 'moverioBT350';

var moverioBT350 = {
  setCameraLedMode: function (status, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setCameraLedMode", [status]);
  },
  setBacklight: function (qty, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setBacklight", [qty]);
  },
  setDisplayDistance: function (qty, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setDisplayDistance", [qty]);
  },
  setDisplayMute: function (disabled, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setDisplayMute", [disabled]);
  },
  setKeyEnable: function (keyLabel, enable, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setKeyEnable", [keyLabel, enable]);
  },
  setKeyAsisgn: function (keyLabel,keyCode, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setKeyAsisgn", [keyLabel, keyCode]);
  },
  setTrackpadEnable: function (enable, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "setTrackpadEnable", [enable]);
  }

};





module.exports = moverioBT350;
