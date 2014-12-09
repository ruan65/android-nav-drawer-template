package com.engstuff.classiccomposers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.engstuff.classiccomposers.R;

public class Main extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.main;
    }

    public void onClickStartQuiz(View view) {
        startActivity(new Intent(this, RenameMeActivity.class));
    }
}
