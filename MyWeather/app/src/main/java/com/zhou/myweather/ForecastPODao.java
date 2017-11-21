package com.zhou.myweather;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.zhou.myweather.db.dto.ForecastPO;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FORECAST_PO".
*/
public class ForecastPODao extends AbstractDao<ForecastPO, Void> {

    public static final String TABLENAME = "FORECAST_PO";

    /**
     * Properties of entity ForecastPO.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "name", false, "NAME");
        public final static Property Weekday = new Property(1, String.class, "weekday", false, "WEEKDAY");
        public final static Property Day_air_temperature = new Property(2, String.class, "day_air_temperature", false, "DAY_AIR_TEMPERATURE");
        public final static Property Night_air_temperature = new Property(3, String.class, "night_air_temperature", false, "NIGHT_AIR_TEMPERATURE");
        public final static Property Day_weather_pic = new Property(4, String.class, "day_weather_pic", false, "DAY_WEATHER_PIC");
    }


    public ForecastPODao(DaoConfig config) {
        super(config);
    }
    
    public ForecastPODao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FORECAST_PO\" (" + //
                "\"NAME\" TEXT," + // 0: name
                "\"WEEKDAY\" TEXT," + // 1: weekday
                "\"DAY_AIR_TEMPERATURE\" TEXT," + // 2: day_air_temperature
                "\"NIGHT_AIR_TEMPERATURE\" TEXT," + // 3: night_air_temperature
                "\"DAY_WEATHER_PIC\" TEXT);"); // 4: day_weather_pic
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FORECAST_PO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ForecastPO entity) {
        stmt.clearBindings();
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(1, name);
        }
 
        String weekday = entity.getWeekday();
        if (weekday != null) {
            stmt.bindString(2, weekday);
        }
 
        String day_air_temperature = entity.getDay_air_temperature();
        if (day_air_temperature != null) {
            stmt.bindString(3, day_air_temperature);
        }
 
        String night_air_temperature = entity.getNight_air_temperature();
        if (night_air_temperature != null) {
            stmt.bindString(4, night_air_temperature);
        }
 
        String day_weather_pic = entity.getDay_weather_pic();
        if (day_weather_pic != null) {
            stmt.bindString(5, day_weather_pic);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ForecastPO entity) {
        stmt.clearBindings();
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(1, name);
        }
 
        String weekday = entity.getWeekday();
        if (weekday != null) {
            stmt.bindString(2, weekday);
        }
 
        String day_air_temperature = entity.getDay_air_temperature();
        if (day_air_temperature != null) {
            stmt.bindString(3, day_air_temperature);
        }
 
        String night_air_temperature = entity.getNight_air_temperature();
        if (night_air_temperature != null) {
            stmt.bindString(4, night_air_temperature);
        }
 
        String day_weather_pic = entity.getDay_weather_pic();
        if (day_weather_pic != null) {
            stmt.bindString(5, day_weather_pic);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ForecastPO readEntity(Cursor cursor, int offset) {
        ForecastPO entity = new ForecastPO( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // name
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // weekday
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // day_air_temperature
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // night_air_temperature
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // day_weather_pic
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ForecastPO entity, int offset) {
        entity.setName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setWeekday(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDay_air_temperature(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNight_air_temperature(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDay_weather_pic(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ForecastPO entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ForecastPO entity) {
        return null;
    }

    @Override
    public boolean hasKey(ForecastPO entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
