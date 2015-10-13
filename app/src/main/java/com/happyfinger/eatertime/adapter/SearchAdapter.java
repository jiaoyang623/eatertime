package com.happyfinger.eatertime.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.happyfinger.eatertime.R;
import com.happyfinger.eatertime.model.SearchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaoyang on 7/26/15.
 */
public class SearchAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Context mContext;

    public SearchAdapter(Context context) {
        mContext = context;
    }

    private List<SearchBean> mSearchList = new ArrayList<SearchBean>();

    public void setList(List<SearchBean> list) {
        mSearchList.clear();
        if (list != null) {
            mSearchList.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return mSearchList.size();
    }

    @Override
    public SearchBean getItem(int position) {
        return mSearchList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_search, null);
            holder = new ViewHolder();
            holder.contentImage = (ImageView) convertView.findViewById(R.id.image);
            holder.addImage = (ImageView) convertView.findViewById(R.id.add);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SearchBean bean = getItem(position);
        holder.title.setText(bean.title);
        holder.description.setText(bean.description);
        //TODO 图片和点击事件

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        openDialog();
    }

    private class ViewHolder {
        ImageView contentImage;
        ImageView addImage;
        TextView title;
        TextView description;
    }
}