package com.example.quent.geophone;


        import android.content.Context;
        import android.location.Location;
        import android.location.LocationManager;

        import static android.content.Context.LOCATION_SERVICE;


public class LocationGPS {


    Location location; // location
    double latitude; // latitude
    double longitude; // longitude
    private LocationManager locationManager;


    public LocationGPS(Context context){
        locationManager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
    }

    public Location getLastLocation() throws SecurityException{

        Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location locationNet = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);



        long GPSLocationTime = 0;
        if (null != locationGPS) { GPSLocationTime = locationGPS.getTime(); }

        long NetLocationTime = 0;

        if (null != locationNet) {
            NetLocationTime = locationNet.getTime();
        }

        if ( 0 < GPSLocationTime - NetLocationTime ) {
            return locationGPS;
        }
        else {
            return locationNet;
        }
    }

    /**
     * Function to get latitude
     * */
    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }

        // return latitude
        return latitude;
    }

    /**
     * Function to get longitude
     * */
    public double getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }

        // return longitude
        return longitude;
    }
}