package com.happyfinger.eatertime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class GuideActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager mPager;
    private GuideAdapter mAdapter;
    private List<View> mPageList = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);
        mPager = (ViewPager) findViewById(R.id.pager);
        initPages();
        mAdapter = new GuideAdapter();
        mPager.setAdapter(mAdapter);
    }

    private void initPages() {
        int[] res = {R.drawable.guide1, R.drawable.guide2, R.drawable.guide3};
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(res[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mPageList.add(imageView);
        }

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View lastPage = inflater.inflate(R.layout.pager_guide_last, null);
        lastPage.findViewById(R.id.button).setOnClickListener(this);
        mPageList.add(lastPage);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    private class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPageList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = mPageList.get(position);
            container.addView(page);
            return page;
        }
    }
}
