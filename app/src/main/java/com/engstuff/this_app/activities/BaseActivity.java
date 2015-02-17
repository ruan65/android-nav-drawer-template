package com.engstuff.this_app.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.engstuff.this_app.R;
import com.engstuff.this_app.fragments.FragmentNavDrawer;
import com.engstuff.this_app.helpers.AppHelper;


public abstract class BaseActivity extends ActionBarActivity {

    Toolbar mToolbar;
    DrawerLayout mDrawerLayout; // parent activity layout
    View mDrawerView; // child drawer view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        FragmentNavDrawer drawerFragment = (FragmentNavDrawer) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_nav_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerView = findViewById(R.id.fragment_nav_drawer);
        drawerFragment.setUp(mDrawerLayout, mToolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        String keyNotFirstTime = getString(R.string.not_first_time);

        if (!AppHelper.readFromPrefsBoolean(this, keyNotFirstTime)) {
            mDrawerLayout.openDrawer(mDrawerView);
            AppHelper.writeToPrefs(this, keyNotFirstTime, true);
        }
    }

    protected abstract int getLayoutResource();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings ? true : super.onOptionsItemSelected(item);
    }

    /**
     * This is for preventing app crash after pressing hardware Back button
     * And now more - open/close drawer after pressing it
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {

            if (!mDrawerLayout.isDrawerOpen(mDrawerView)) {
                mDrawerLayout.openDrawer(mDrawerView);
            } else if (mDrawerLayout.isDrawerOpen(mDrawerView)) {
                mDrawerLayout.closeDrawer(mDrawerView);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
