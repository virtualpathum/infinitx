package com.lk.infinitx.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lk.infinitx.R;
import com.lk.infinitx.entity.TravellerEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by virtualpathum on 26/8/2017.
 */

public class AsyncTaskRunner<T extends Activity > extends AsyncTask<Void, Void, Void> {

    private static final String TAG = AsyncTaskRunner.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    // URL to get contacts JSON
    private static String url = "https://api.androidhive.info/contacts/";

    private T t;

    ArrayList<HashMap<String, String>> contactList = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<HashMap<String, String>> contactList) {
        this.contactList = contactList;
    }



    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
      //  pDialog = new ProgressDialog(getT().getApplicationContext());
      //  pDialog.setMessage("Please wait...");
      //  pDialog.setCancelable(false);
      //  pDialog.show();

    }

    @Override
    protected Void doInBackground(Void... params) {
        HTTPHandler sh = new HTTPHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url);

        Log.e(TAG, "XXXXX Response from url: " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("contacts");

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    String id = c.getString("id");
                    String name = c.getString("name");
                    String email = c.getString("email");
                    String address = c.getString("address");
                    String gender = c.getString("gender");

                    // Phone node is JSON Object
                    JSONObject phone = c.getJSONObject("phone");
                    String mobile = phone.getString("mobile");
                    String home = phone.getString("home");
                    String office = phone.getString("office");

                    // tmp hash map for single contact
                    HashMap<String, String> contact = new HashMap<>();

                    // adding each child node to HashMap key => value
                    contact.put("id", id);
                    contact.put("name", name);
                    contact.put("email", email);
                    contact.put("mobile", mobile);

                    // adding contact to contact list
                    contactList.add(contact);
                    this.setContactList(contactList);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                t.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getT().getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
            t.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getT().getApplicationContext(),
                            "Couldn't get json from server. Check LogCat for possible errors!",
                            Toast.LENGTH_LONG)
                            .show();
                }
            });

        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
      //  if (pDialog.isShowing())
       //     pDialog.dismiss();
        /**
         * Updating parsed JSON data into ListView
         * */
        Log.i(TAG, "YYYYYYYY : "+contactList.size());
        ArrayList<TravellerEntity> travellerEntities = new ArrayList<>();
        for (HashMap<String,String> map :contactList) {
            for (Map.Entry<String, String> pair : map.entrySet()) {
                String key = pair.getKey() + pair.getValue();
                Log.i(TAG,"xxxx key : " + pair.getKey() +"\\n");
                Log.i(TAG,"xxxx value : " + pair.getValue());
                TravellerEntity travellerEntity = new TravellerEntity();
                if(pair.getKey().equalsIgnoreCase("name")){
                    travellerEntity.setName(pair.getValue());
                }
                if(pair.getKey().equalsIgnoreCase("address")){
                    travellerEntity.setLocation(pair.getValue());
                }
                if(pair.getKey().equalsIgnoreCase("email")){
                    travellerEntity.setDistance(pair.getValue());
                }

                travellerEntities.add(travellerEntity);
            }
        }

        ArrayAdapter<TravellerEntity> adapter = new ArrayAdapter<TravellerEntity>(t,
                android.R.layout.simple_selectable_list_item,
                android.R.id.text1,
                travellerEntities);

        ListView lvNearestPerson = (ListView) t.findViewById(R.id.lvNearestPerson);
        lvNearestPerson.setAdapter(adapter);
/*        ListAdapter adapter = new SimpleAdapter(
                t.getApplication(), contactList,
                R.layout.list_item, new String[]{"name", "email",
                "mobile"}, new int[]{R.id.name,
                R.id.email, R.id.mobile});

        lv.setAdapter(adapter);*/
    }

}

