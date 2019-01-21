package com.jbnustudent.it.tasteroad;

import android.app.Activity;
import android.os.Bundle;
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
        CharSequence test;
        try {
            cache.Write("nice to meet you");
            test = (CharSequence)cache.Read();
            TextView textView =(TextView)findViewById(R.id.intro);
            textView.setText(test);
            Log.d(TAG, test.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
