package com.baidu.apistore.sdk;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.apistore.sdk.bena.OneDayWeatherInfs;
import com.baidu.apistore.sdk.bena.WeatherBean;
import com.baidu.apistore.sdk.network.Parameters;
import com.baidu.apistore.sdk.prase.Parse;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private TextView mTemperature;
    private TextView mWeather;
    private TextView mPm;
    private TextView mTem1;
    private TextView mTem2;
    private TextView mTem3;
    private TextView mTem4;
    private TextView mTem5;
    private TextView mTem6;
    private TextView mTem7;
    private TextView mTomorrow1;
    private TextView mTomorrow2;
    private TextView mTomorrow3;
    private TextView mTomorrow4;
    private TextView mTomorrow5;
    private TextView mWind_det1;
    private TextView mWind_det2;
    private TextView mWind_det3;
    private TextView mWind_det4;
    private TextView mWind_det5;
    private TextView mWind_det6;
    private TextView mWind_det7;
    private TextView mWind_sd1;
    private TextView mWind_sd2;
    private TextView mWind_sd3;
    private TextView mWind_sd4;
    private TextView mWind_sd5;
    private TextView mWind_sd6;
    private TextView mWind_sd7;
    private TextView mComfortable;
    private TextView mComfortableContent;
    private TextView mCwbrf;
    private TextView mCwContent;
    private TextView mDressBrief;
    private TextView mDressContent;
    private ImageView mWeatherImage1;
    private ImageView mWeatherImage2;
    private ImageView mWeatherImage3;
    private ImageView mWeatherImage4;
    private ImageView mWeatherImage5;
    private ImageView mWeatherImage6;
    private ImageView mWeatherImage7;
    private LinearLayout mLinearLayout;
    private SwipeRefreshLayout mRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatus();
        setContentView(R.layout.activity_main);

        initUI();
        apiTest();
        mRefreshLayout.setOnRefreshListener(this);

    }
        private void setStatus(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = getWindow();
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                // 透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    private void initUI() {
        mTemperature = (TextView) findViewById(R.id.tmp);
        mWeather = (TextView) findViewById(R.id.wea);
        mPm = (TextView) findViewById(R.id.pm);
        mTem1 = (TextView) findViewById(R.id.today_tmp1);
        mTem2 = (TextView) findViewById(R.id.today_tmp2);
        mTem3 = (TextView) findViewById(R.id.today_tmp3);
        mTem4 = (TextView) findViewById(R.id.today_tmp4);
        mTem5 = (TextView) findViewById(R.id.today_tmp5);
        mTem6 = (TextView) findViewById(R.id.today_tmp6);
        mTem7 = (TextView) findViewById(R.id.today_tmp7);
        mTomorrow1 = (TextView) findViewById(R.id.tomorrow1);
        mTomorrow2 = (TextView) findViewById(R.id.tomorrow2);
        mTomorrow3 = (TextView) findViewById(R.id.tomorrow3);
        mTomorrow4 = (TextView) findViewById(R.id.tomorrow4);
        mTomorrow5 = (TextView) findViewById(R.id.tomorrow5);
        mWind_det1 = (TextView) findViewById(R.id.wind_det1);
        mWind_det2 = (TextView) findViewById(R.id.wind_det2);
        mWind_det3 = (TextView) findViewById(R.id.wind_det3);
        mWind_det4 = (TextView) findViewById(R.id.wind_det4);
        mWind_det5 = (TextView) findViewById(R.id.wind_det5);
        mWind_det6 = (TextView) findViewById(R.id.wind_det6);
        mWind_det7 = (TextView) findViewById(R.id.wind_det7);
        mWind_sd1 = (TextView) findViewById(R.id.wind_sd1);
        mWind_sd2 = (TextView) findViewById(R.id.wind_sd2);
        mWind_sd3 = (TextView) findViewById(R.id.wind_sd3);
        mWind_sd4 = (TextView) findViewById(R.id.wind_sd4);
        mWind_sd5 = (TextView) findViewById(R.id.wind_sd5);
        mWind_sd6 = (TextView) findViewById(R.id.wind_sd6);
        mWind_sd7 = (TextView) findViewById(R.id.wind_sd7);
        mWeatherImage1 = (ImageView) findViewById(R.id.weather_image1);
        mWeatherImage2 = (ImageView) findViewById(R.id.weather_image2);
        mWeatherImage3 = (ImageView) findViewById(R.id.weather_image3);
        mWeatherImage4 = (ImageView) findViewById(R.id.weather_image4);
        mWeatherImage5 = (ImageView) findViewById(R.id.weather_image5);
        mWeatherImage6 = (ImageView) findViewById(R.id.weather_image6);
        mWeatherImage7 = (ImageView) findViewById(R.id.weather_image7);
        mComfortable = (TextView) findViewById(R.id.combrt);
        mComfortableContent = (TextView) findViewById(R.id.comContent);
        mCwbrf = (TextView) findViewById(R.id.cwbrf);
        mCwContent = (TextView) findViewById(R.id.cwContent);
        mDressBrief = (TextView) findViewById(R.id.dress_brf);
        mDressContent = (TextView) findViewById(R.id.dressContent);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mLinearLayout = (LinearLayout) findViewById(R.id.content_layout);
    }

    /**
     * 这里的apiTest（）方法是百度SDK自带的，返回的是json数据，
     * 我们只要在这里面添加解析json数据的方法就好了。
     */
    private void apiTest() {

        final Parameters para = new Parameters();

        para.put("city", "anyang");
        ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        Log.i("sdkdemo", "responseString" + responseString);
                        WeatherBean weatherBean = null;
                        weatherBean = Parse.resolveWeatherInf(responseString);
                        Log.i("fnhFire", "weatherBean--->" + weatherBean);
                        mPm.setText(String.valueOf(weatherBean.getPm25()));
                        mWeather.setText(weatherBean.getCond_txt());
                        mTemperature.setText(weatherBean.getNow() + getResources().getString(R.string.tmpC));
                        Log.i("sdkdemo", "Weather" + weatherBean);
                        List<OneDayWeatherInfs> list = weatherBean.getOneDayWeatherInfs();
                        Iterator<OneDayWeatherInfs> iterator = list.iterator();
                        int i = 0;
                        while (iterator.hasNext()) {

                            OneDayWeatherInfs oneDayWeatherInfs = (OneDayWeatherInfs) iterator.next();

                            if (i == 0) {
                                mTem1.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det1.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd1.setText(oneDayWeatherInfs.getWindSc());
                                mComfortable.setText(weatherBean.getComfBrf());
                                mComfortableContent.setText(weatherBean.getComfTxt());
                                mCwbrf.setText(weatherBean.getCwBrf());
                                mCwContent.setText(weatherBean.getCwTxt());
                                mDressBrief.setText(weatherBean.getDrsgBrf());
                                mDressContent.setText(weatherBean.getDrsgTxt());
                                mLinearLayout.setBackground(todayWeatherImageSet(weatherBean.getCond_txt()));
                                mWeatherImage1.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                            }
                            if (i == 1) {
                                mTem2.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det2.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd2.setText(oneDayWeatherInfs.getWindSc());
                                mWeatherImage2.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                            }
                            if (i == 2) {
                                mTomorrow1.setText(oneDayTool(oneDayWeatherInfs));
                                mTem3.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det3.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd3.setText(oneDayWeatherInfs.getWindSc());
                                mWeatherImage3.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                            }
                            if (i == 3) {
                                mWeatherImage4.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                                mTomorrow2.setText(oneDayTool(oneDayWeatherInfs));
                                mTem4.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det4.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd4.setText(oneDayWeatherInfs.getWindSc());
                            }
                            if (i == 4) {
                                mWeatherImage5.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                                mTomorrow3.setText(oneDayTool(oneDayWeatherInfs));
                                mTem5.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det5.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd5.setText(oneDayWeatherInfs.getWindSc());
                            }
                            if (i == 5) {
                                mWeatherImage6.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                                mTomorrow4.setText(oneDayTool(oneDayWeatherInfs));
                                mTem6.setText(String.valueOf(oneDayWeatherInfs.getTmpMin()) + getResources().getString
                                        (R.string.to) + String.valueOf(oneDayWeatherInfs.getTmpMax()) + getResources().getString
                                        (R.string.tmpC));
                                mWind_det6.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd6.setText(oneDayWeatherInfs.getWindSc());
                            }
                            if (i == 6) {
                                mWeatherImage7.setImageDrawable(weatherImageSet(oneDayWeatherInfs.getCondN()));
                                mTomorrow5.setText(oneDayTool(oneDayWeatherInfs));
                                mTem7.setText(oneDayWeatherInfs.getTmpMin() + getResources().getString
                                        (R.string.to) + oneDayWeatherInfs.getTmpMax() + getResources().getString
                                        (R.string.tmpC));
                                mWind_det7.setText(oneDayWeatherInfs.getWindDir());
                                mWind_sd7.setText(oneDayWeatherInfs.getWindSc());
                            }
                            i++;

                        }


                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                        Toast.makeText(MainActivity.this, "" + getStackTrace(e), Toast.LENGTH_SHORT).show();
                    }

                });

    }

    String getStackTrace(Throwable e) {
        if (e == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(e.getMessage()).append("\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            str.append(e.getStackTrace()[i]).append("\n");
        }
        return str.toString();
    }

    //获取日期
    private int dateTools(Date str) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    //日期与星期的转换
    private String weekDay(int day) {
        switch (day) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return null;
        }
    }

    //把当前的日期传递给日期转换方法，将转换结果作为字符串返回
    private String oneDayTool(OneDayWeatherInfs oneDayWeatherInfs) {
        java.sql.Date date = java.sql.Date.valueOf(oneDayWeatherInfs.getDate());
        int day = dateTools(date);
        return weekDay(day);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
                apiTest();
                Toast.makeText(MainActivity.this, "已获取最新天气数据", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    //设置一周天气图片
    private Drawable weatherImageSet(String weather) {
        if (weather.equals("多云")) {
            return getResources().getDrawable(R.mipmap.ic_weather_cloudy);
        } else if (weather.equals("阴")) {
            return getResources().getDrawable(R.mipmap.ic_weather_overcast);
        } else if (weather.equals("晴")) {
            return getResources().getDrawable(R.mipmap.ic_weather_sunny);
        } else if (weather.equals("雨夹雪")) {
            return getResources().getDrawable(R.mipmap.ic_weather_sleet);
        } else if (weather.equals("阵雪")) {
            return getResources().getDrawable(R.mipmap.ic_weather_snowflurry);
        } else if (weather.equals("雷阵雨")) {
            return getResources().getDrawable(R.mipmap.ic_weather_thundershower);
        } else if (weather.equals("阵雨")) {
            return getResources().getDrawable(R.mipmap.ic_weather_shower);
        } else if (weather.equals("沙尘暴")) {
            return getResources().getDrawable(R.mipmap.ic_weather_sandstorm);
        } else if (weather.equals("中雨")) {
            return getResources().getDrawable(R.mipmap.ic_weather_moderaterain);
        } else if (weather.equals("中雪")) {
            return getResources().getDrawable(R.mipmap.ic_weather_moderatesnow);
        } else if (weather.equals("小雨")) {
            return getResources().getDrawable(R.mipmap.ic_weather_lightrain);
        } else if (weather.equals("小雪")) {
            return getResources().getDrawable(R.mipmap.ic_weather_lightsnow);
        } else if (weather.equals("大雨")) {
            return getResources().getDrawable(R.mipmap.ic_weather_heavyrain);
        } else if (weather.equals("大雪")) {
            return getResources().getDrawable(R.mipmap.ic_weather_heavysnow);
        } else if (weather.equals("雾")) {
            return getResources().getDrawable(R.mipmap.ic_weather_fogs);
        } else if (weather.equals("冰雹")) {
            return getResources().getDrawable(R.mipmap.ic_weather_hailstone);
        } else if (weather.equals("霾")) {
            return getResources().getDrawable(R.mipmap.ic_weather_haze);
        }
        return getResources().getDrawable(R.mipmap.ic_weather_default);
    }

    //设置当天天气图片
    private Drawable todayWeatherImageSet(String weather) {
        if (weather.equals("多云")) {
            return getResources().getDrawable(R.mipmap.bg_weather_cloudy);
        } else if (weather.equals("雾")) {
            return getResources().getDrawable(R.mipmap.bg_weather_fog);
        } else if (weather.equals("中雨")) {
            return getResources().getDrawable(R.mipmap.bg_weather_moderaterain);
        } else if (weather.equals("阴")) {
            return getResources().getDrawable(R.mipmap.bg_weather_overcast);
        } else if (weather.equals("雨")) {
            return getResources().getDrawable(R.mipmap.bg_weather_rain);
        } else if (weather.equals("雪")) {
            return getResources().getDrawable(R.mipmap.bg_weather_snow);
        } else if (weather.equals("晴")) {
            return getResources().getDrawable(R.mipmap.bg_weather_sunny);
        } else if (weather.equals("暴雨")) {
            return getResources().getDrawable(R.mipmap.bg_weather_thunderstorm);
        }
        return getResources().getDrawable(R.drawable.content_bg);
    }
}
