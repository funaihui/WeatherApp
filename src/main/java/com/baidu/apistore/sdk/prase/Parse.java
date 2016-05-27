package com.baidu.apistore.sdk.prase;

import com.baidu.apistore.sdk.bena.OneDayWeatherInfs;
import com.baidu.apistore.sdk.bena.WeatherBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohui on 2016/5/15.
 */
public class Parse {
    public Parse() {

    }

    public static WeatherBean resolveWeatherInf(String strPar) {
        WeatherBean weatherBean = new WeatherBean();
        try {
            JSONObject dataOfJson = new JSONObject(strPar);
            JSONArray jsonArray = dataOfJson.getJSONArray("HeWeather data service 3.0");
            //空气质量解析
            JSONObject jsonArray0 = jsonArray.getJSONObject(0);
            JSONObject aqi = jsonArray0.getJSONObject("aqi");
            JSONObject city = aqi.getJSONObject("city");
            weatherBean.setAqi(city.getInt("aqi"));
            weatherBean.setPm10(city.getInt("pm10"));
            weatherBean.setPm25(city.getInt("pm25"));
            JSONObject basic = jsonArray0.getJSONObject("basic");
            weatherBean.setCity(basic.getString("city"));
            weatherBean.setCnty(basic.getString("cnty"));
            //当前温度
            JSONObject now = jsonArray0.getJSONObject("now");
            JSONObject nowCond = now.getJSONObject("cond");
            weatherBean.setNow(now.getInt("tmp"));
            weatherBean.setCond_txt(nowCond.getString("txt"));
            //连续七天的天气数据解析

            List<OneDayWeatherInfs> list = new ArrayList<>();
            JSONArray daily_forecast = jsonArray0.getJSONArray("daily_forecast");
            for (int i = 0; i < 7; i++) {
                OneDayWeatherInfs oneDayWeatherInfs = new OneDayWeatherInfs();
                JSONObject oneDayWeather = daily_forecast.getJSONObject(i);
                JSONObject cond = oneDayWeather.getJSONObject("cond");
                JSONObject temp = oneDayWeather.getJSONObject("tmp");
                JSONObject wind = oneDayWeather.getJSONObject("wind");
                oneDayWeatherInfs.setWindDir(wind.getString("dir"));
                oneDayWeatherInfs.setWindSc(wind.getString("sc"));
                oneDayWeatherInfs.setWindSpd(wind.getString("spd"));
                oneDayWeatherInfs.setTmpMax(temp.getInt("max"));
                oneDayWeatherInfs.setTmpMin(temp.getInt("min"));
                oneDayWeatherInfs.setCondD(cond.getString("txt_d"));
                oneDayWeatherInfs.setCondN(cond.getString("txt_n"));
                oneDayWeatherInfs.setDate(oneDayWeather.getString("date"));
                list.add(oneDayWeatherInfs);
            }
            weatherBean.setOneDayWeatherInfs(list);
            //舒适度指数解析
            JSONObject suggesttion = jsonArray0.getJSONObject("suggestion");
            JSONObject comf = suggesttion.getJSONObject("comf");
            weatherBean.setComfBrf(comf.getString("brf"));
            weatherBean.setComfTxt(comf.getString("txt"));
            JSONObject cw = suggesttion.getJSONObject("cw");
            weatherBean.setCwBrf(cw.getString("brf"));
            weatherBean.setCwTxt(cw.getString("txt"));
            JSONObject drsg = suggesttion.getJSONObject("drsg");
            weatherBean.setDrsgBrf(drsg.getString("brf"));
            weatherBean.setDrsgTxt(drsg.getString("txt"));
            JSONObject flu = suggesttion.getJSONObject("flu");
            weatherBean.setFluBrf(flu.getString("brf"));
            weatherBean.setFluTxt(flu.getString("txt"));
            JSONObject sport = suggesttion.getJSONObject("sport");
            weatherBean.setSportBrf(sport.getString("brf"));
            weatherBean.setSportTxt(sport.getString("txt"));
            JSONObject trav = suggesttion.getJSONObject("trav");
            weatherBean.setTravBrf(trav.getString("brf"));
            weatherBean.setTravTxt(trav.getString("txt"));
            JSONObject uv = suggesttion.getJSONObject("uv");
            weatherBean.setUvBrf(uv.getString("brf"));
            weatherBean.setUvTxt(uv.getString("txt"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherBean;
    }
}
