package com.lk.infinitx.entity;

import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by virtualpathum on 27/8/2017.
 */

public class TravellerEntity extends BaseEntity {

    private String name;
    private String location;
    private String distance;
    private ImageView ivPhoto;
    private Class<? extends Activity> activityClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public ImageView getIvPhoto() {
        return ivPhoto;
    }

    public void setIvPhoto(ImageView ivPhoto) {
        this.ivPhoto = ivPhoto;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }

    public TravellerEntity(){
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer().append(name).append(location).append(distance).append(ivPhoto);
        return sb.toString();
    }
}
