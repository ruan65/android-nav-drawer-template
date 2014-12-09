package com.engstuff.classiccomposers.activities;

import android.os.Bundle;

import com.engstuff.classiccomposers.R;

public class RenameMeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.quiz_layout;
    }
}
