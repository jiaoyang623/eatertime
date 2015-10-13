package com.happyfinger.eatertime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.happyfinger.eatertime.widget.QuarterRingView;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class HistoryActivity extends BaseActivity implements View.OnClickListener {
    private ListView mListView;
    private HistoryAdapter mAdapter;
    private View mHeaderView;

    private QuarterRingView mRingView;
    private TextView mDateText;
    private TextView mCalorieText;
    private TextView mDescriptionText;
    private TextView mAccumulateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initLsnr();
    }

    private void initView() {
        mListView = new ListView(getApplicationContext());
        mAdapter = new HistoryAdapter();
        mListView.setAdapter(mAdapter);

        mHeaderView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.header_history, null);
        mRingView = (QuarterRingView) mHeaderView.findViewById(R.id.quarter_ring);
        mDateText = (TextView) mHeaderView.findViewById(R.id.date);
        mCalorieText = (TextView) mHeaderView.findViewById(R.id.calorie);
        mDescriptionText = (TextView) mHeaderView.findViewById(R.id.description);
        mAccumulateText = (TextView) mHeaderView.findViewById(R.id.accumulate);

        mListView.addHeaderView(mHeaderView);
        setContentView(mListView);
    }

    private void initLsnr() {
        mHeaderView.findViewById(R.id.back).setOnClickListener(this);
        mHeaderView.findViewById(R.id.share).setOnClickListener(this);
        mHeaderView.findViewById(R.id.next_day).setOnClickListener(this);
        mHeaderView.findViewById(R.id.last_day).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.share:
                break;
            case R.id.next_day:
                break;
            case R.id.last_day:
                break;
        }
    }

    private class HistoryAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 4;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.item_history, null);
                convertView.setTag(new ViewHolder(convertView));
            }

            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.type.setText("type");
            holder.content.setText("pos." + position);

            return convertView;
        }

        private class ViewHolder {
            public TextView type;
            public TextView content;

            public ViewHolder(View parent) {
                type = (TextView) parent.findViewById(R.id.type);
                content = (TextView) parent.findViewById(R.id.content);
            }
        }
    }

}
