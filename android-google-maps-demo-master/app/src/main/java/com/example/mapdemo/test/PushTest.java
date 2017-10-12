package com.example.mapdemo.test;

import com.parse.ParseCloud;
import com.parse.ParseInstallation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by jan_spidlen on 10/11/17.
 */

public class PushTest {
    public static void sendPushTest() {
        JSONObject payload = new JSONObject();

        try {
            payload.put("sender", ParseInstallation.getCurrentInstallation().getInstallationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap<String, String> data = new HashMap<>();
        data.put("customData", payload.toString());

        ParseCloud.callFunctionInBackground("pingReply", data);
    }
}
