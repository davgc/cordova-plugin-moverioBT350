/**
 */
package com.funcionasi.moverioBT350;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

import com.epson.moverio.btcontrol.Bt3sCameraLedMode;

public class moverioBT350 extends CordovaPlugin {
  private static final String TAG = "moverioBT350";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Inicializando moverioBT350");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("setCameraLedMode")) {
      Integer mode = args.getInt(0);
      Bt3sCameraLedMode bt3sCameraLedMode = new Bt3sCameraLedMode(this.cordova.getActivity());
      bt3sCameraLedMode.setCameraLedMode(mode);
      final PluginResult result = new PluginResult(PluginResult.Status.OK, bt3sCameraLedMode.getCameraLedMode());
      callbackContext.sendPluginResult(result);
    }
    return true;
  }

}
