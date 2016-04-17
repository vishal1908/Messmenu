package com.example.vishal.pushnotiftest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.*;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.PushService;

import java.util.ArrayList;
import java.util.List;


public class TestPush extends ActionBarActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_push);
        Parse.initialize(this, "lQvBTVxchLjf2z0k5oqVVk2C7uwXqt4J7zSWyY8u", "aLsoffSltuvpz42TykUj33sDAF6hFyFVfAbriLvR");
        //PushService.setDefaultPushCallback(getApplicationContext(), TestPush.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setTitle("Mess Menu");

        /*ParseObject monday = new ParseObject("monday");
        monday.put("breakfast", "Paratha");
        monday.put("lunch", "Aalo-Gobhi");
        monday.put("hightea","Pasta");
        monday.put("dinner","Manchurian");
        monday.saveInBackground();


        ParseObject tuesday = new ParseObject("tuesday");
        tuesday.put("breakfast", "Pohe");
        tuesday.put("lunch", "Chhole");
        tuesday.put("hightea","Aloo-Tikki");
        tuesday.put("dinner","Chhole-Sambhar");
        tuesday.saveInBackground();

        ParseObject wednesday = new ParseObject("wednesday");
        wednesday.put("breakfast", "Paratha");
        wednesday.put("lunch", "Aalo-Gobhi");
        wednesday.put("hightea","Paneer Puff");
        wednesday.put("dinner","Panner");
        wednesday.saveInBackground();


        ParseObject thursday = new ParseObject("thursday");
        thursday.put("breakfast", "Idli");
        thursday.put("lunch", "Soya");
        thursday.put("hightea","Sandwich");
        thursday.put("dinner","Shitty Daal");
        thursday.saveInBackground();

        ParseObject friday = new ParseObject("friday");
        friday.put("breakfast", "Vada Sambhar");
        friday.put("lunch", "Chhole");
        friday.put("hightea","Samosa");
        friday.put("dinner","Panner Kadhai");
        friday.saveInBackground();

        ParseObject saturday = new ParseObject("saturday");
        saturday.put("breakfast", "Uttapam");
        saturday.put("lunch", "Chana");
        saturday.put("hightea","Indian Fries");
        saturday.put("dinner","Biryani");
        saturday.saveInBackground();


        ParseObject sunday = new ParseObject("sunday");
        sunday.put("breakfast", "Dosa");
        sunday.put("lunch", "Rajma");
        sunday.put("hightea","Veg Roll");
        sunday.put("dinner","Panner Again!!");
        sunday.saveInBackground();

    */



        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Monday");
        categories.add("Tuesday");
        categories.add("Wednesday");
        categories.add("Thursday");
        categories.add("Friday");
        categories.add("Saturday");
        categories.add("Sunday");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        /*Button updatebtn=(Button)findViewById(R.id.updbtn);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParsePush push = new ParsePush();
                //push.setQuery(pushQuery); // Set our Installation query
                //String strAnsweredBy = (Utilities.getCurTagObject().getBoolean(Utilities.alias_TAGISANON) && Utilities.getCurUserType() == Utilities.UserType.USER_TYPE_IPM) ? Utilities.getCurName() : "Someone";
                push.setMessage("Hello!!");
                try {
                    push.send();
                } catch (ParseException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }); */





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_push, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString().toLowerCase();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(item);



        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your game score

                        //ParseObject m2= query.get("b42GIsFisA");
                        TextView bf=(TextView)findViewById(R.id.bfast);
                        String b=object.getString("breakfast");
                        bf.setText(""+b);

                        TextView lnch=(TextView)findViewById(R.id.lnch);
                        String l=object.getString("lunch");
                        lnch.setText("" + l);

                    TextView high_tea=(TextView)findViewById(R.id.htea);
                    String hts=object.getString("hightea");
                    high_tea.setText("" +hts);

                    TextView dinner=(TextView)findViewById(R.id.din);
                    String dins=object.getString("dinner");
                    dinner.setText("" + dins);



                } else {
                    // something went wrong
                }
            }
        });
        //String b=selected_day.getString("breakfast");
        //TextView bf=(TextView)findViewById(R.id.bfast);
        //bf.setText(""+b);



        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + b, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
