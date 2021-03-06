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

import com.epson.moverio.btcontrol.Bt3sCameraLedMode;
import com.epson.moverio.btcontrol.DisplayControl;
import com.epson.moverio.btcontrol.Bt3sCustomKey;
import com.epson.moverio.btcontrol.UIControl;
import com.epson.moverio.btcontrol.Bt3sControllerLedMode;



public class moverioBT350 extends CordovaPlugin {
    private static String TAG =  moverioBT350.class.getSimpleName();

    //declare each plugin method
    private static final String SET_CAMERA_LED_MODE = "setCameraLedMode";

    private static final String SET_BACKLIGHT = "setBacklight";
    private static final String SET_DISPLAY_DISTANCE = "setDisplayDistance";
    private static final String SET_DISPLAY_MUTE = "setDisplayMute";

    private static final String SET_KEY_ENABLE = "setKeyEnable";
    private static final String SET_KEY_ASISGN = "setKeyAsisgn";
    private static final String SET_TRACKPAD_ENABLE = "setTrackpadEnable";
    private static final String KEY_RESET_TO_DEFAULT = "resetToDefault";
    private static final String SET_ESPAD_SENSIVITY = "setESpadSensitivity";
    private static final String SET_CONTROLLER_LED_MODE = "setControllerLedMode";





    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        Log.d(TAG, "moverioBT350 plugin init");


    }



    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        if(SET_CAMERA_LED_MODE.equals(action)) {

            Integer mode = args.getInt(0);

            Bt3sCameraLedMode bt3sCameraLedMode = new Bt3sCameraLedMode(this.cordova.getContext());
            bt3sCameraLedMode.setCameraLedMode(mode);


            String result = "{'led_mode':" +bt3sCameraLedMode.getCameraLedMode()+"}";

            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (SET_BACKLIGHT.equals(action)){
            // from 0 to 20
            Integer qty = args.getInt(0);

            DisplayControl displayControl = new DisplayControl(this.cordova.getContext());


            String result = "{'status':" + displayControl.setBacklight(qty) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        } else if (SET_DISPLAY_DISTANCE.equals(action)){
            // from 0 to 15 (11m -> 2m)
            Integer qty = args.getInt(0);

            DisplayControl displayControl = new DisplayControl(this.cordova.getContext());

            String result = "{'status':" + displayControl.setDisplayDistance(qty) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        } else if (SET_DISPLAY_MUTE.equals(action)){

            Boolean mode = args.getBoolean(0);

            DisplayControl displayControl = new DisplayControl(this.cordova.getContext());

            String result = "{'status':" + displayControl.setMute(mode) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        } else if (SET_KEY_ENABLE.equals(action)){


            String keyLabel = args.getString(0);
            Boolean enable = args.getBoolean(1);
            Integer keyID = 0;

            switch (keyLabel){
                case "DPAD_UP":
                    keyID = Bt3sCustomKey.DPAD_UP;
                    break;
                case "DPAD_DOWN":
                    keyID = Bt3sCustomKey.DPAD_DOWN;
                    break;
                case "DPAD_LEFT":
                    keyID = Bt3sCustomKey.DPAD_LEFT;
                    break;
                case "DPAD_RIGHT":
                    keyID = Bt3sCustomKey.DPAD_RIGHT;
                    break;
                case "DPAD_CENTER":
                    keyID = Bt3sCustomKey.DPAD_CENTER;
                    break;
                case "VOLUME_UP":
                    keyID = Bt3sCustomKey.VOLUME_UP;
                    break;
                case "VOLUME_DOWN":
                    keyID = Bt3sCustomKey.VOLUME_DOWN;
                    break;
                case "FUNCTION":
                    keyID = Bt3sCustomKey.FUNCTION;
                    break;
                case "BACK":
                    keyID = Bt3sCustomKey.BACK;
                    break;
                case "HOME":
                    keyID = Bt3sCustomKey.HOME;
                    break;
                case "APP_SWITCH":
                    keyID = Bt3sCustomKey.APP_SWITCH;
                    break;
                case "POWER":
                    keyID = Bt3sCustomKey.POWER;
                    break;
            }



            Bt3sCustomKey bt3sCustomKey = new Bt3sCustomKey(this.cordova.getContext());



            String result = "{'status':" + bt3sCustomKey.setKeyEnable(keyID,enable) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (SET_KEY_ASISGN.equals(action)){

            String keyLabel = args.getString(0);
            Integer newKeyCode = args.getInt(1);

            Integer keyID = 0;

            switch (keyLabel){
                case "DPAD_UP":
                    keyID = Bt3sCustomKey.DPAD_UP;
                    break;
                case "DPAD_DOWN":
                    keyID = Bt3sCustomKey.DPAD_DOWN;
                    break;
                case "DPAD_LEFT":
                    keyID = Bt3sCustomKey.DPAD_LEFT;
                    break;
                case "DPAD_RIGHT":
                    keyID = Bt3sCustomKey.DPAD_RIGHT;
                    break;
                case "DPAD_CENTER":
                    keyID = Bt3sCustomKey.DPAD_CENTER;
                    break;
                case "VOLUME_UP":
                    keyID = Bt3sCustomKey.VOLUME_UP;
                    break;
                case "VOLUME_DOWN":
                    keyID = Bt3sCustomKey.VOLUME_DOWN;
                    break;
                case "FUNCTION":
                    keyID = Bt3sCustomKey.FUNCTION;
                    break;
                case "BACK":
                    keyID = Bt3sCustomKey.BACK;
                    break;
                case "HOME":
                    keyID = Bt3sCustomKey.HOME;
                    break;
                case "APP_SWITCH":
                    keyID = Bt3sCustomKey.APP_SWITCH;
                    break;
                case "POWER":
                    keyID = Bt3sCustomKey.POWER;
                    break;
            }


            Bt3sCustomKey bt3sCustomKey = new Bt3sCustomKey(this.cordova.getContext());

            String result = "{'status':" + bt3sCustomKey.setKeyAssign(keyID, newKeyCode) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (SET_TRACKPAD_ENABLE.equals(action)){

            Boolean mode = args.getBoolean(0);

            UIControl uiControl = new UIControl(this.cordova.getContext());

            String result = "{'status':" + uiControl.setTrackpadEnable(mode) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (KEY_RESET_TO_DEFAULT.equals(action)){

            Bt3sCustomKey bt3sCustomKey = new Bt3sCustomKey(this.cordova.getContext());
            bt3sCustomKey.resetToDefault();

            String result = "{'status': true}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (SET_ESPAD_SENSIVITY.equals(action)){

            Integer qty = args.getInt(0);

            UIControl uiControl = new UIControl(this.cordova.getContext());

            String result = "{'status':" + uiControl.setESpadSensitivity(qty) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }else if (SET_CONTROLLER_LED_MODE.equals(action)){

            Integer mode = args.getInt(0);

            Bt3sControllerLedMode bt3sControllerLedMode = new Bt3sControllerLedMode(this.cordova.getContext());

            String result = "{'status':" + bt3sControllerLedMode.setControllerLedMode(mode) + "}";
            callbackSuccess(callbackContext, new JSONObject(result));

        }



        return true;
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
    public void onDestroy() {
        //
    }


}
