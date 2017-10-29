package googlemaps.learn.smktelkom_mlg.sch.id.googlemapsxiirpl117;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static googlemaps.learn.smktelkom_mlg.sch.id.googlemapsxiirpl117.MainActivity.JUDUL;

public class PlaceMarkerActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition SMKTELKOMMALANG = CameraPosition.builder()
            .target(new LatLng(-7.97683, 112.6567693))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions masjid;
    MarkerOptions roker;
    MarkerOptions cafe;
    MarkerOptions bni;
    MarkerOptions bpbd;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_marker);

        Intent intent = getIntent();
        String judul = intent.getStringExtra(JUDUL);
        setTitle(judul);

        masjid = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("Masjid Manarul Islam")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        bni = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("Pasar Sawojajar")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        roker = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("Warung Ayam Roker")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        cafe = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("Urban Pop Cafe")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        bni = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("BNI Sawojajar")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        bpbd = new MarkerOptions()
                .position(new LatLng(-7.97683, 112.6567693))
                .title("BPBD Kota Malang")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(masjid);
        m_map.addMarker(bni);
        m_map.addMarker(roker);
        m_map.addMarker(cafe);
        m_map.addMarker(bni);
        m_map.addMarker(bpbd);
        flyTo(SMKTELKOMMALANG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
