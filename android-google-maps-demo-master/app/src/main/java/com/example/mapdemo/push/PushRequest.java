package com.example.mapdemo.push;

/**
 * Created by jan_spidlen on 10/11/17.
 */

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.json.JSONObject;

public class PushRequest {

    public String markerId;
    public String title;
    public String installationId;
    public String snippet = "";
    public LatLng mapLocation;
    public String channel;

    public PushRequest(JSONObject data) throws JSONException {
        JSONObject location = data.getJSONObject("location");
        markerId = data.getString("markerId");
        title = data.getString("title");
        snippet = data.optString("snippet", "");
        installationId = data.getString("installationId");
//        channel = data.getString("channel");

        mapLocation = new LatLng(location.getDouble("lat"),
                location.getDouble("long"));

    }
}