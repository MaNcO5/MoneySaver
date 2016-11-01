package com.example.manco.moneysaver1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toolbar = (Toolbar) findViewById( R.id.app_bar );
        setSupportActionBar( toolbar );


        TabHost tabHost = (TabHost) findViewById( R.id.tabHost );

        tabHost.setup();


        TabHost.TabSpec tabSpec = tabHost.newTabSpec( "Income" );
        tabSpec.setContent( R.id.tab1 );
        tabSpec.setIndicator( "Income" );
        tabHost.addTab( tabSpec );

        tabSpec = tabHost.newTabSpec( "Cost" );
        tabSpec.setContent( R.id.tab2 );
        tabSpec.setIndicator( "Cost" );
        tabHost.addTab( tabSpec );

        tabSpec = tabHost.newTabSpec( "Balances" );
        tabSpec.setContent( R.id.tab3 );
        tabSpec.setIndicator( "Balances" );
        tabHost.addTab( tabSpec );
        ListView list = (ListView) findViewById( R.id.listView );
        customadapter ca = new customadapter();
        list.setAdapter( ca );

    }


    class customadapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub

            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }


        @Override
        public View getView(final int position, View convertview, ViewGroup arg2) {
            // TODO Auto-generated method stub
            LayoutInflater inflater = getLayoutInflater();
            convertview = inflater.inflate( R.layout.custom, null );
            TextView tv = (TextView) convertview.findViewById( R.id.textView1 );
            TextView tv1 = (TextView) convertview.findViewById( R.id.textView2 );
            ImageView image = (ImageView) convertview
                    .findViewById( R.id.imageView1 );
            tv.setText( names[position] );
            tv1.setText( locations[position] );
            image.setImageResource( images[position] );

            FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
            fab.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent registerIntent = new Intent(MainActivity.this, IncomeFragment.class);
                    MainActivity.this.startActivity(registerIntent);


                }

            } );

            return convertview;

        }
    }

    String[] names = {"name1", "name2", "name3", "name4", "name5"};
    String[] locations = {"location1", "location2", "location3", "location4",
            "location5"};
    int[] images = {R.drawable.accounts, R.drawable.accounts, R.drawable.accounts,
            R.drawable.accounts, R.drawable.accounts};


    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences( "MySharedString", MODE_PRIVATE );
        if (sp != null)
            setTitle( sp.getString( "sharedString", null ) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.create) {
            startActivity( new Intent( this, SharedPrefs.class ) );
            return true;
        }
        return super.onOptionsItemSelected( item );
    }


}
