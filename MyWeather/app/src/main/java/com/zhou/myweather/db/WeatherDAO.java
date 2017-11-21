package com.zhou.myweather.db;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zhou.myweather.DaoMaster;
import com.zhou.myweather.DaoSession;
import com.zhou.myweather.WeatherPODao;
import com.zhou.myweather.db.dto.ForecastPO;
import com.zhou.myweather.db.dto.WeatherPO;
import com.zhou.myweather.util.LogcatUtil;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周利杰 on 17-11-20.
 */

public class WeatherDAO {
    private static WeatherDAO weatherDAO;
    private Application application;
    private DaoSession daoSession;

    private static synchronized void initSync() {
        if (weatherDAO == null)
            weatherDAO = new WeatherDAO();
    }

    private WeatherDAO() {
    }

    public static WeatherDAO getWeatherDAO() {
        if (weatherDAO == null)
            initSync();
        return weatherDAO;
    }

    public void init(Application application) {
        this.application = application;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, WeatherPODao.TABLENAME + ".db");
            SQLiteDatabase database = helper.getWritableDatabase();
            daoSession = new DaoMaster(database).newSession();
        }
        return daoSession;
    }

    public void insertWeather(WeatherPO weatherPO) {
        QueryBuilder<WeatherPO> weatherPOQueryBuilder = getDaoSession().getWeatherPODao().queryBuilder();
        weatherPOQueryBuilder.where(new WhereCondition.StringCondition("CITY_NAME = '" + weatherPO.city_name + "'")).buildDelete().executeDeleteWithoutDetachingEntities();
        getDaoSession().getWeatherPODao().insert(weatherPO);
    }

    public WeatherPO getWeatherPO(String city_name) {
        QueryBuilder<WeatherPO> weatherPOQueryBuilder = getDaoSession().getWeatherPODao().queryBuilder();
        List<WeatherPO> weatherPOS = weatherPOQueryBuilder.where(new WhereCondition.StringCondition("CITY_NAME = '" + city_name + "'")).list();
        if (weatherPOS == null || weatherPOS.size() == 0) {
            LogcatUtil.d("没有数据");
            weatherPOS = new ArrayList<>();
            return null;
        }
        return weatherPOS.get(0);
    }

    public List<ForecastPO> getForecastOPS(String city_name) {
        QueryBuilder<ForecastPO> forecastPOQueryBuilder = getDaoSession().getForecastPODao().queryBuilder();
        List<ForecastPO> forecastPOS = forecastPOQueryBuilder.where(new WhereCondition.StringCondition("NAME = '" + city_name + "'")).list();
        return forecastPOS;
    }

    public void insertForecastPO(String city_name, List<ForecastPO> forecastPOs) {
        QueryBuilder<ForecastPO> forecastPOQueryBuilder = getDaoSession().getForecastPODao().queryBuilder();
        forecastPOQueryBuilder.where(new WhereCondition.StringCondition("NAME = '" + city_name + "'")).buildDelete().executeDeleteWithoutDetachingEntities();
        for (ForecastPO forecastPO : forecastPOs) {
            getDaoSession().getForecastPODao().insert(forecastPO);
        }
    }
}
