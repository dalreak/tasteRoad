package com.jbnustudent.it.tasteroad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class First extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
