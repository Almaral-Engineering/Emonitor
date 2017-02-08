package com.almaral.emonitor;

import android.provider.BaseColumns;

public class EqContract {

    public class EqColumns implements BaseColumns {
        public static final String TABLE_NAME = "earthquakes";

        public static final String MAGNITUDE = "magnitude";
        public static final String PLACE = "place";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String TIMESTAMP = "timestamp";

        public static final int MAGNITUDE_COLUMN_INDEX = 1;
        public static final int PLACE_COLUMN_INDEX = 2;
        public static final int LONGITUDE_COLUMN_INDEX = 3;
        public static final int LATITUDE_COLUMN_INDEX = 4;
        public static final int TIMESTAMP_COLUMN_INDEX = 5;
    }
}
