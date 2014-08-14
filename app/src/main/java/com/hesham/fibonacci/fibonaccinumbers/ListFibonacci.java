package com.hesham.fibonacci.fibonaccinumbers;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListFibonacci extends Activity {
        ListView listView;
    ArrayList<Integer> fiboNumbers = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fibonacci);
        listView = (ListView)findViewById(R.id.fibo_list);
        Intent intent = getIntent();
        fiboNumbers = (ArrayList<Integer>)intent.getIntegerArrayListExtra("fib");
        if(fiboNumbers!=null || fiboNumbers.size()>0){
            listFibo();
        }
    }

    private void listFibo() {
        ListAdapter listAdapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return fiboNumbers.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = null;

        LayoutInflater inflater =(LayoutInflater) LayoutInflater.from(ListFibonacci.this);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView textView = (TextView)convertView.findViewById(R.id.textView);
                textView.setText("fib" + (position + 1) + ": " +fiboNumbers.get(position).intValue() + "");


                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return fiboNumbers.size();
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };
        listView.setAdapter(listAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_fibonacci, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
