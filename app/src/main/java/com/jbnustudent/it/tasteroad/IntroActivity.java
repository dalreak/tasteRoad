package com.jbnustudent.it.tasteroad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jbnustudent.it.tasteroad.Cache;
import java.io.File;
import java.io.IOException;
import android.util.Log;

public class IntroActivity extends Activity {

    private Cache cache = new Cache(this);
    private static final String TAG = "introactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        FloatingActionButton closeButton = (FloatingActionButton)findViewById(R.id.intro_button);
        closeButton.setOnClickListener(new FloatingActionButton.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(IntroActivity.this,MainActivity.class));
                finish();
            }
        });
        CharSequence test;
        try {
            test = (CharSequence)cache.Read();
            Log.d(TAG, test.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
