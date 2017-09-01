package com.lk.infinitx.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lk.infinitx.R;
import com.lk.infinitx.common.AsyncTaskRunner;
import com.lk.infinitx.entity.TravellerEntity;
import com.lk.infinitx.location.LocationActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactPersonActivity extends AppCompatActivity {

    private static final String TAG = ContactPersonActivity.class.getName();
    private ListView lvNearestPerson;
    private Button btnConfirm;
    private Button btnCancel;
    private ImageView ivTraveller;
    private TextView tvTravellerNIC;
    private TextView tvTravellerRating;
    private TextView tvTravellerPhone;
    private TextView tvTravellerAddress;
    private TravellerEntity[] travellerEntities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_people);

        lvNearestPerson = (ListView)findViewById(R.id.lvNearestPerson);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        ivTraveller  = (ImageView) findViewById(R.id.ivTraveller);
        tvTravellerNIC = (TextView) findViewById(R.id.tvTravellerNIC);
        tvTravellerRating = (TextView) findViewById(R.id.tvTravellerRating);
        tvTravellerPhone = (TextView) findViewById(R.id.tvTravellerPhone);
        tvTravellerAddress = (TextView)findViewById(R.id.tvTravellerAddress);

        ImageView ivPhoto = null;
        AsyncTaskRunner<ContactPersonActivity> atr = new AsyncTaskRunner<ContactPersonActivity>();
        atr.setT(this);
        atr.execute();
        // Instantiate the list of items.

        lvNearestPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String url = null;
                if(0 == id){
                    url = "https://image.pbs.org/poster_images/assets/1iydnsu7s91d9zwrnmqh.png.resize.710x399.png";
                }else if(1 == id){
                    url = "https://openclipart.org/image/2400px/svg_to_png/261881/Cartoon-Man-Avatar-2.png";
                }else if(2 == id){
                    url = "http://hddfhm.com/images/free-clipart-of-a-man-20.png";
                }else if(3 == id){
                    url = "https://openclipart.org/image/2400px/svg_to_png/261880/Cartoon-Man-Avatar.png";
                }
                Glide.with(getApplicationContext())
                        .load(url).into(ivTraveller);
            }
        });

       // Drawable traveller = ivTraveller.getContext().getResources().getDrawable(R.drawable.person_dummy);
        //ivTraveller.setImageDrawable(traveller);

        tvTravellerNIC.setText("NIC : 821567891 v");
        tvTravellerRating.setText("Rating : * * *");
        tvTravellerPhone.setText("Contact Number : 0777878342");
        tvTravellerAddress.setText("Address : 123/4, Colombo Road, Colombo");

        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), LocationActivity.class);
                view.getContext().startActivity(Intent);}
        });


    }

    public void setPersonList(ArrayList<HashMap<String, String>> contactList){

    }




}
