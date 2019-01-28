package com.jbnustudent.it.tasteroad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jbnustudent.it.tasteroad.Cache;
import java.io.IOException;
import android.util.Log;
import com.jbnustudent.it.tasteroad.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IntroActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Cache cache = new Cache(this);
    private static final String TAG = "introactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.intro_scroll);
        mViewPager.setAdapter(mSectionsPagerAdapter);

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

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String intro_data = "{\"intro_data\":[{\"name\":\"hi\",\"age\":\"24\",\"gender\":\"남\",\"motto\":\"착하게살자\",\"introduce\":\"blahblah\"},{\"name\":\"he\",\"age\":\"22\",\"gender\":\"남\",\"motto\":\"살자\",\"introduce\":\"blahblㄹah\"},{\"name\":\"hu\",\"age\":\"23\",\"gender\":\"여\",\"motto\":\"착살자\",\"introduce\":\"blahblㄴah\"},{\"name\":\"ha\",\"age\":\"25\",\"gender\":\"남\",\"motto\":\"착하 살자\",\"introduce\":\"blahㄴㅁblah\"}]}";
        private static String intro_avatar = "R.drawable.avatar1";
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            JSONArray intro_data_array;
            JSONObject intro_data_object;
            String name;
            String age;
            String gender;
            String motto;
            String introduce;
            try {
                intro_data_array = new JSONObject(intro_data).getJSONArray("intro_data");
                intro_data_object = intro_data_array.getJSONObject(sectionNumber);
                name = intro_data_object.getString("name");
                age = intro_data_object.getString("age");
                gender = intro_data_object.getString("gender");
                motto = intro_data_object.getString("motto");
                introduce = intro_data_object.getString("introduce");
                args.putString("name",name);
                args.putString("age",age);
                args.putString("gender",gender);
                args.putString("motto",motto);
                args.putString("introduce",introduce);
                intro_avatar += sectionNumber;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main_view, container, false);
            ImageView avatar_image = (ImageView) rootView.findViewById(R.id.intro_avatar);
            TextView name_text = (TextView) rootView.findViewById(R.id.intro_name_change);
            TextView age_text = (TextView) rootView.findViewById(R.id.intro_age_change);
            TextView gender_text = (TextView) rootView.findViewById(R.id.intro_gender_change);
            TextView motto_text = (TextView) rootView.findViewById(R.id.intro_motto_change);
            TextView introduce_text = (TextView) rootView.findViewById(R.id.intro_introduce_change);
            //avatar_image.setImageResource(R.drawable.avatar0);
            name_text.setText(getArguments().getString("name"));
            age_text.setText(getArguments().getString("age"));
            gender_text.setText(getArguments().getString("gender"));
            motto_text.setText(getArguments().getString("motto"));
            introduce_text.setText(getArguments().getString("introduce"));
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }
}
