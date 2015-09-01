package jobsukraine.com.ua.userallocator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    SupportMapFragment mapFragment;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFragment.getMap();
        if (map == null) {
            finish();
            return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddOne:
                map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("First marker"));
                break;
            case R.id.btnAddTwo:
                map.addMarker(new MarkerOptions().position(new LatLng(41, 0)).title("Second marker"));
                break;
            case R.id.btnClear:
                map.clear();
                break;
        }
    }
}
