package com.example.kap;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class call_link extends AsyncTask<String, String, String> {

    private Activity activity;
    JSONArray dataJsonArr=null;
    JSONObject jsonobj;
    String result = "";
    String line = "";

    public call_link(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection conn = null;

        try {
            URL url;
            url = new URL(params[0]);
            conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                jsonobj = new JSONObject(result);
                bufferedReader.close();
                inputStream.close();
                // loop through all users
                /*dataJsonArr = jsonobj.getJSONArray("customer_details");

                // loop through all users
                for (int i = 0; i < dataJsonArr.length(); i++) {
                    JSONObject c = dataJsonArr.getJSONObject(i);

                    // Storing each json item in variable
                    String name = c.getString("name");
                    String address = c.getString("address");
                    String city = c.getString("city");
                    String pincode = c.getString("pincode");
                    String id = c.getString("id");
                    // show the values in our logcat
                    Log.e(TAG, "firstname: " + name
                            + ", lastname: " + address
                            + ", username: " + city);

                }*/
            }
            else {
                InputStream err = conn.getErrorStream();
            }
        }
        catch (JSONException e) {
        e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result;
    }
}