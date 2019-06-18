package com.example.jsongetparsedemo;

import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ActGetJSON  extends AsyncTask<Void,Void,Void> {
String str;
Integer intTotal;

    @Override
    protected Void doInBackground(Void... voids) {
        URL url = null;
        try {
            url = new URL("https://api.myjson.com/bins/l7hnf");
            //[{"name": "Macro"}]

            URLConnection conn = url.openConnection();
            InputStream streamInput = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(streamInput));
            StringBuilder html = new StringBuilder();
            String line ;
            while ((line = bufferedReader.readLine())!=null) {
            html.append(line);
            }
//            str = html.toString();


            JSONArray ja = new JSONArray(html.toString());
            for(int i = 0 ; i < ja.length();i++){
                JSONObject job = ja.getJSONObject(i);
                str = job.getString("name");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.lbl1.setText(str);
    }
}
