/**
 * MIT License
 *
 * Copyright 2018 Funciona
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.funcionasi;

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

  //declare each plugin method
  private static final String SET_CAMERA_LED_MODE = "setCameraLedMode";



  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "moverioBT350 plugin init");
  }

  // This is to prevent an issue where if two Javascript calls are made to OneSignal expecting a callback then only one would fire.
  private static void callbackSuccess(CallbackContext callbackContext, JSONObject jsonObject) {
    if (jsonObject == null) // in case there are no data
      jsonObject = new JSONObject();

    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jsonObject);
    pluginResult.setKeepCallback(true);
    callbackContext.sendPluginResult(pluginResult);
  }

  private static void callbackError(CallbackContext callbackContext, JSONObject jsonObject) {
    if (jsonObject == null) // in case there are no data
      jsonObject = new JSONObject();

    PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, jsonObject);
    pluginResult.setKeepCallback(true);
    callbackContext.sendPluginResult(pluginResult);
  }

  private static void callbackError(CallbackContext callbackContext, String str) {
    PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, str);
    pluginResult.setKeepCallback(true);
    callbackContext.sendPluginResult(pluginResult);
  }

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(SET_CAMERA_LED_MODE.equals(action)) {

      Integer mode = args.getInt(0);

      Bt3sCameraLedMode bt3sCameraLedMode = new Bt3sCameraLedMode(this.cordova.getActivity());
      bt3sCameraLedMode.setCameraLedMode(mode);

      //final PluginResult result = new PluginResult(PluginResult.Status.OK, bt3sCameraLedMode.getCameraLedMode());
      //callbackContext.sendPluginResult(result);

      String result = "{'led_mode':" +bt3sCameraLedMode.getCameraLedMode()+"}";

      callbackSuccess(callbackContext, new JSONObject(result));

    }
    return true;
  }


  @Override
  public void onDestroy() {
    //
  }


}
