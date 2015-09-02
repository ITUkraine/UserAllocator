package jobsukraine.com.ua.userallocator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SupportMapFragment mapFragment;
    private GoogleMap map;


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

        setMarkers(10);
    }

    private void setMarkers(int maxAmountOfMarkers) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Person");
        query.setLimit(maxAmountOfMarkers);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> userList, ParseException e) {
                if (e == null) {
                    if (userList.size() > 0) {
                        for (int i = 0; i < userList.size(); i++) {
                            ParseObject p = userList.get(i);
                            ParseGeoPoint geoPoint = p.getParseGeoPoint("Location");
                            map.addMarker(new MarkerOptions().position(new LatLng(geoPoint.getLatitude(), geoPoint.getLongitude())).title(p.getString("Name")));
                        }
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }

    public void onClick(View view) {
        map.clear();
        setMarkers(10);
    }
}
