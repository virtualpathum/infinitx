package com.lk.infinitx.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lk.infinitx.R;
import com.lk.infinitx.core.BaseActivity;
import com.lk.infinitx.location.LocationActivity;

/**
 * Created by virtualpathum on 15/7/2017.
 */

public class MainWindowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout rlHousehold = (RelativeLayout) findViewById(R.id.rlHousehold);
        rlHousehold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), HouseholdItemActivity.class);
                view.getContext().startActivity(Intent);
               /* ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup .getChildCount(); i++) {

                    View viewChild = viewGroup .getChildAt(i);
                    viewChild.setPressed(true);

                }*/
            }
        });

        RelativeLayout rlGrocery = (RelativeLayout) findViewById(R.id.rlGrocery);
        rlGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Intent = new Intent(view.getContext(), LocationActivity.class);
                view.getContext().startActivity(Intent);
               /* ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup .getChildCount(); i++) {

                    View viewChild = viewGroup .getChildAt(i);
                    viewChild.setPressed(true);

                }*/
            }
        });

        RelativeLayout rlHardware = (RelativeLayout) findViewById(R.id.rlHardware);
        rlHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup .getChildCount(); i++) {

                    View viewChild = viewGroup .getChildAt(i);
                    viewChild.setPressed(true);

                }
            }
        });

        RelativeLayout rlForeign = (RelativeLayout) findViewById(R.id.rlForeign);
        rlForeign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup .getChildCount(); i++) {

                    View viewChild = viewGroup .getChildAt(i);
                    viewChild.setPressed(true);

                }
            }
        });
    }

    @NonNull
    @Override
    protected Object createComponent() {
        return null;
    }

    @Override
    public void inject() {

    }
}
