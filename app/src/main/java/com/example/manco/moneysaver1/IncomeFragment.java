package com.example.manco.moneysaver1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MANCO on 9/27/2016.
 */

public class IncomeFragment extends Activity {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.income_layout_popup, container, false );


        // Inflate the layout for this fragment
        return rootView;
    }
}