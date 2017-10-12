package com.example.mapdemo.utils;

/**
 * Created by jan_spidlen on 10/11/17.
 */


import com.example.mapdemo.MapDemoActivity;
import com.example.mapdemo.push.PushRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.ui.IconGenerator;

import android.content.Context;
import android.util.Log;

import java.util.Hashtable;

public class PushUtilTracker {

    // DO NOT declare this hashtable as static since it should only last the lifetime of an Activity.
    Hashtable<String, Marker> userMarkerMap;

    public PushUtilTracker() {
        userMarkerMap = new Hashtable<String, Marker>();
    }

    public void handleMarkerUpdates(Context context, PushRequest pushRequest,
                                    GoogleMap map) {
//        if (!MapDemoActivity.CHANNEL_NAME.equals(pushRequest.channel)) {
//            Log.d("jenda", "pushRequest.channel " + pushRequest.channel);
//            return;
//        }
        Marker marker = userMarkerMap.get(pushRequest.markerId);

        // If marker already exists, simply update the position and title.
        if (marker != null) {
            Log.d("jenda", "updating position");
            marker.setPosition(pushRequest.mapLocation);
            marker.setTitle(pushRequest.title);
        } else {
            // Otherwise, create a new speech bubble and use the data from the push
            // to create the new marker.
//            BitmapDescriptor icon = MapUtils
//                    .addSpeechBubble(context, IconGenerator.STYLE_BLUE, pushRequest.title);
            marker = MapUtils.addSpeechBubble(context, map, pushRequest.mapLocation,
                    pushRequest.title,
                    pushRequest.snippet);
            //MapUtils.dropPinEffect(marker);
            userMarkerMap.put(pushRequest.markerId, marker);
        }
    }
}