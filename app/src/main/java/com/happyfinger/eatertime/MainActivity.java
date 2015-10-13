package com.happyfinger.eatertime;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private View mDrawerContent;
    private View mSlideMenuButton;
    private View mBreakfastButton;
    private View mLunchButton;
    private View mSupperButton;
    private View mOtherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerContent = findViewById(R.id.drawerContent);
        findViewById(R.id.menu).setOnClickListener(this);
        findViewById(R.id.search).setOnClickListener(this);
        findViewById(R.id.history).setOnClickListener(this);


        mSlideMenuButton = findViewById(R.id.slide_menu_button);
        mBreakfastButton = findViewById(R.id.breakfast);
        mLunchButton = findViewById(R.id.lunch);
        mSupperButton = findViewById(R.id.supper);
        mOtherButton = findViewById(R.id.others);

        mSlideMenuButton.setOnClickListener(this);
        mBreakfastButton.setOnClickListener(this);
        mLunchButton.setOnClickListener(this);
        mSupperButton.setOnClickListener(this);
        mOtherButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu: {
                if (mDrawerLayout.isDrawerOpen(mDrawerContent)) {
                    mDrawerLayout.closeDrawer(mDrawerContent);
                } else {
                    mDrawerLayout.openDrawer(mDrawerContent);
                }
            }
            break;
            case R.id.search: {
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
            }
            break;
            case R.id.history: {
                startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
            }
            break;
            case R.id.slide_menu_button:
                clickMenu();
                break;
            case R.id.breakfast:
                showMessage("breakfast");
                break;
            case R.id.lunch:
                showMessage("lunch");
                break;
            case R.id.supper:
                showMessage("supper");
                break;
            case R.id.others:
                showMessage("others");
                break;
        }
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean mIsMenuOpen = false;

    private void clickMenu() {
        View[] itemArray = {mBreakfastButton, mLunchButton, mSupperButton, mOtherButton};

        if (mIsMenuOpen) {
            // close
            ObjectAnimator animator = ObjectAnimator.ofFloat(mSlideMenuButton, "rotation", 180, 0);
            animator.start();

            for (View item : itemArray) {
                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(item, "alpha", 1, 0);
                alphaAnim.start();

                int dx = mSlideMenuButton.getRight() - item.getRight();
                ObjectAnimator transAnim = ObjectAnimator.ofFloat(item, "translationX", 0, dx);
                transAnim.start();
            }
        } else {
            // open
            ObjectAnimator animator = ObjectAnimator.ofFloat(mSlideMenuButton, "rotation", 0, 180);
            animator.start();

            for (View item : itemArray) {
                item.setVisibility(View.VISIBLE);
                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(item, "alpha", 0, 1);
                alphaAnim.start();

                int dx = mSlideMenuButton.getRight() - item.getRight();
                ObjectAnimator transAnim = ObjectAnimator.ofFloat(item, "translationX", dx, 0);
                transAnim.start();
            }
        }
        mIsMenuOpen = !mIsMenuOpen;
    }
}
