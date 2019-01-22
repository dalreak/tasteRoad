package com.jbnustudent.it.tasteroad;

import android.app.Activity;
import com.jbnustudent.it.tasteroad.Cache;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import android.util.Log;

public class SplashActivity extends FragmentActivity {
    private static final String TAG = "SplashActivity";
    Cache cache = new Cache(this);
    String temp;
    JSONObject jArray;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try{
            temp = cache.Read();
            jArray = new JSONObject(temp);
            JSONObject jsonObj = jArray.getJSONObject("config");
            String boolVal = jsonObj.getString("introSet");
            Log.d(TAG, boolVal);
            Thread.sleep(3000);
            if(boolVal.equals("yes")){
                startActivity(new Intent(this,IntroActivity.class));
                finish();
            }
            else{
                startActivity(new Intent(this,MainActivity.class));
                finish();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        catch(JSONException e){
            e.printStackTrace();
            startActivity(new Intent(this,IntroActivity.class));
            finish();
        }
    }
}