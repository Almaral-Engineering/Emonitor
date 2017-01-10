package com.almaral.emonitor;

import android.os.Parcel;
import android.os.Parcelable;

public class Earthquake implements Parcelable {
    private Long dateTime;
    private Double magnitude;
    private String place;
    private String longitude;
    private String latitude;

    public Earthquake(Long dateTime, Double magnitude, String place, String longitude, String latitude) {
        this.dateTime = dateTime;
        this.magnitude = magnitude;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public long getDateTime() {
        return dateTime;
    }

    protected Earthquake(Parcel in) {
        dateTime = in.readLong();
        magnitude = in.readByte() == 0x00 ? null : in.readDouble();
        place = in.readString();
        longitude = in.readString();
        latitude = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(dateTime);
        if (magnitude == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(magnitude);
        }
        dest.writeString(place);
        dest.writeString(longitude);
        dest.writeString(latitude);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Earthquake> CREATOR = new Parcelable.Creator<Earthquake>() {
        @Override
        public Earthquake createFromParcel(Parcel in) {
            return new Earthquake(in);
        }

        @Override
        public Earthquake[] newArray(int size) {
            return new Earthquake[size];
        }
    };
}
