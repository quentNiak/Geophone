package com.example.quent.geophone;

        import android.location.Location;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitudeCible;
    private double longitudeCible;
    private String deviceName;

    private LocationGPS localisationPerso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        localisationPerso = new LocationGPS(getApplicationContext());



        latitudeCible = getIntent().getExtras().getDouble("latitudeSearch");
        longitudeCible = getIntent().getExtras().getDouble("longitudeSearch");
        deviceName = getIntent().getExtras().getString("device name");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Location localisationActuelle = localisationPerso.getLastLocation();
        //Toast.makeText(getApplicationContext(),"\n"+ localisationActuelle.getLatitude()+" \n"+ localisationActuelle.getLongitude()+"    \n"+ latitudeCible+" \n"+ longitudeCible, Toast.LENGTH_LONG).show();
        LatLng myPosition = new LatLng(localisationActuelle.getLatitude(), localisationActuelle.getLongitude());
        LatLng positionCible = new LatLng(this.latitudeCible, this.longitudeCible);


        mMap.addMarker(new MarkerOptions().position(myPosition).title("Ma position"));
        mMap.addMarker(new MarkerOptions().position(positionCible).title(deviceName) .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))).showInfoWindow();

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(positionCible,18),1500,null);
    }
}
