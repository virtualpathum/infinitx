package com.lk.infinitx.layout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lk.infinitx.R;
import com.lk.infinitx.animation.CardFlipActivity;
import com.lk.infinitx.animation.CrossfadeActivity;
import com.lk.infinitx.animation.FlipMainActivity;
import com.lk.infinitx.animation.LayoutChangesActivity;
import com.lk.infinitx.animation.ScreenSlideActivity;
import com.lk.infinitx.animation.ZoomActivity;
import com.lk.infinitx.contact.ContactPersonActivity;

/**
 * Created by virtualpathum on 15/7/2017.
 */

public class HouseholdItemActivity extends ListActivity {

    private class Item {
        private String itemName;
        private Class<? extends Activity> activityClass;

        public Item(String name, Class<? extends Activity> activityClass ){
            this.itemName = name;
            this.activityClass = activityClass;
        }

        @Override
        public String toString(){
            return itemName.toString();
        }
    }

    private static Item[] items;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_flip);

        // Instantiate the list of items.
        items = new Item[]{
                new Item("Kitchen", ContactPersonActivity.class),
                new Item("School", ContactPersonActivity.class),
                new Item("Living", ContactPersonActivity.class),
                new Item("General", ContactPersonActivity.class),
        };

        setListAdapter(new ArrayAdapter<Item>(this,
                android.R.layout.simple_selectable_list_item,
                android.R.id.text1,
                items));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(HouseholdItemActivity.this, items[position].activityClass));
    }
}
