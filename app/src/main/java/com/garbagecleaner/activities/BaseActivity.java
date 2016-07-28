package com.garbagecleaner.activities;

import android.animation.LayoutTransition;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.garbagecleaner.R;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().setBackgroundDrawable(null);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                LayoutTransition layoutTransition = new LayoutTransition();
                layoutTransition.enableTransitionType(LayoutTransition.DISAPPEARING);
                layoutTransition.enableTransitionType(LayoutTransition.APPEARING);
                layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
                mToolbar.setLayoutTransition(layoutTransition);
            }
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    public void shouldShowToolBar(boolean shouldShow) {
        if (getSupportActionBar() == null) {
            return;
        }

        if (shouldShow) {
            getSupportActionBar().show();
        } else {
            getSupportActionBar().hide();
        }
    }

    protected void showBackButton(boolean show) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(show);
            getSupportActionBar().setDisplayShowHomeEnabled(show);
        }
    }
}
