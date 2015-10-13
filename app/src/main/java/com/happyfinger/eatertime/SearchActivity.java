package com.happyfinger.eatertime;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.happyfinger.eatertime.adapter.SearchAdapter;
import com.happyfinger.eatertime.model.SearchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ListView mListView;
    private EditText mSearchText;
    private TextView mSelectCountText;
    private TextView mCalorieText;
    private TextView mCalorieExtraText;
    private Button mConfirmButton;
    private SearchAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_search);
        mListView = (ListView) findViewById(R.id.list);
        mSearchText = (EditText) findViewById(R.id.search_text);
        mSelectCountText = (TextView) findViewById(R.id.select_count);
        mCalorieText = (TextView) findViewById(R.id.select_calorie);
        mCalorieExtraText = (TextView) findViewById(R.id.more_calorie);
        mConfirmButton = (Button) findViewById(R.id.select_confirm);

    }

    private void initData() {
        mAdapter = new SearchAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(mAdapter);
        List<SearchBean> list = new ArrayList<SearchBean>();

        for (int i = 0; i < 20; i++) {
            SearchBean bean = new SearchBean();
            bean.title = "no. " + i;
            bean.description = "吃货";
            list.add(bean);
        }

        mAdapter.setList(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back: {
                finish();
            }
            break;
            case R.id.clean: {
                mSearchText.setText("");
            }
            break;
            case R.id.select_confirm: {
                //TODO
                finish();
            }
            break;
            case R.id.confirm: {
                mDialog.dismiss();
                mDialog = null;
            }
            break;
        }
    }

    private AlertDialog mDialog;

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View contentView = View.inflate(getApplicationContext(), R.layout.dialog_search, null);

        contentView.findViewById(R.id.confirm).setOnClickListener(this);

        builder.setView(contentView);
        mDialog = builder.create();
        mDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

}
