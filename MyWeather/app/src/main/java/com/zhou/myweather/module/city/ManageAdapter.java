package com.zhou.myweather.module.city;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhou.myweather.R;
import com.zhou.myweather.base.adapter.BaseRecycleViewAdapter;
import com.zhou.myweather.base.adapter.BaseRecycleViewHoldler;
import com.zhou.myweather.model.WeatherInfoManager;
import com.zhou.myweather.module.main.weather.WeatherPOJO;
import com.zhou.myweather.module.weather.AddCityActivity;
import com.zhou.myweather.net.CityAllWeatherInfoDTO;
import com.zhou.myweather.util.ToastUtil;

import java.util.List;

/**
 * Created by 周利杰 on 2017/9/30.
 */

public class ManageAdapter extends BaseRecycleViewAdapter<ManageAdapter.ViewHolder> {
    private List<WeatherPOJO> weatherPOJOS;
    private Context mContext;

    public ManageAdapter(List<WeatherPOJO> weatherPOJOS) {
        this.weatherPOJOS = weatherPOJOS;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        if (weatherPOJOS == null || weatherPOJOS.get(position) == null) {
            viewHolder.tvCityMsg.setVisibility(View.VISIBLE);
            ToastUtil.getInstance().toastShowS("跳转");
            return;
        }
        viewHolder.tvCityWeather.setText(weatherPOJOS.get(position).city_weather);
        viewHolder.tvCityTemperature.setText(weatherPOJOS.get(position).city_weather_temperature);
        viewHolder.tvCityName.setText(weatherPOJOS.get(position).city_name);
    }

    @Override
    public int getItemCount() {
        return weatherPOJOS.size();
    }

    public class ViewHolder extends BaseRecycleViewHoldler implements View.OnClickListener {
        private TextView tvCityName, tvCityTemperature, tvCityWeather, tvCityMsg;
        private ImageButton delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCityName = (TextView) itemView.findViewById(R.id.tv_city_name);
            tvCityTemperature = (TextView) itemView.findViewById(R.id.tv_city_temperature);
            tvCityWeather = (TextView) itemView.findViewById(R.id.tv_city_weather);
            tvCityMsg = (TextView) itemView.findViewById(R.id.tv_city_msg);
            delete = (ImageButton) itemView.findViewById(R.id.delete);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.delete) {
                int pos = getAdapterPosition();
//                WeatherInfoManager.getWeatherInfoManager().removePOJO(pos);
                WeatherInfoManager.getWeatherInfoManager().remove(pos);
                weatherPOJOS = WeatherInfoManager.getWeatherInfoManager().getWeatherMap();
                notifyItemRemoved(pos);
            }
        }
    }
}

