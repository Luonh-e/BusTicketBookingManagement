package com.example.finalproject.authentication.search.list_city_points;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.finalproject.R;

import java.util.List;

public class CityAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<City> cityList;

    public CityAdapter(Context context, int layout, List<City> cityList) {
        this.context = context;
        this.layout = layout;
        this.cityList = cityList;
    }

    @Override
    public int getCount() {
        if(cityList != null){
            return cityList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtNameCity;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewholder;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewholder = new ViewHolder();

            viewholder.txtNameCity = (TextView) view.findViewById(R.id.textviewNameCity);
            view.setTag(viewholder);
        }else{
            viewholder = (ViewHolder) view.getTag();
        }

        City city = cityList.get(i);
        viewholder.txtNameCity.setText(city.getNameCity());

        return view;
    }
}
