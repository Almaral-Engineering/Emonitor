package com.almaral.emonitor;

import android.os.Parcel;
import android.os.Parcelable;

public class Earthquake implements Parcelable {
    private Double magnitude;
    private String place;

    public Earthquake(Double magnitude, String place) {
        this.magnitude = magnitude;
        this.place = place;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    protected Earthquake(Parcel in) {
        magnitude = in.readByte() == 0x00 ? null : in.readDouble();
        place = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (magnitude == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(magnitude);
        }
        dest.writeString(place);
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
