package com.engstuff.this_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.engstuff.this_app.R;

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
