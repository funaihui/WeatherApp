package com.baidu.apistore.sdk.bena;

import java.util.List;

/**
 * Created by xiaohui on 2016/5/15.
 */
public class WeatherBean {

    private List<OneDayWeatherInfs> mOneDayWeatherInfs;
    private int now;
    private int aqi;
    private int pm10;
    private int pm25;
    private String city;
    private String cond_txt;
    private String cnty;
    private String comfBrf;
    private String comfTxt;
    private String cwBrf;
    private String cwTxt;
    private String drsgBrf;
    private String drsgTxt;
    private String fluBrf;
    private String fluTxt;
    private String sportBrf;
    private String sportTxt;
    private String travBrf;
    private String travTxt;
    private String uvBrf;
    private String uvTxt;
    public WeatherBean() {
    }

    public WeatherBean(int aqi, String city, String cnty, String comfBrf, String comfTxt, String cond_txt, String cwBrf, String cwTxt, String drsgBrf, String drsgTxt, String fluBrf, String fluTxt, List<OneDayWeatherInfs> oneDayWeatherInfs, int now, int pm10, int pm25, String sportBrf, String sportTxt, String travBrf, String travTxt, String uvBrf, String uvTxt) {
        this.aqi = aqi;
        this.city = city;
        this.cnty = cnty;
        this.comfBrf = comfBrf;
        this.comfTxt = comfTxt;
        this.cond_txt = cond_txt;
        this.cwBrf = cwBrf;
        this.cwTxt = cwTxt;
        this.drsgBrf = drsgBrf;
        this.drsgTxt = drsgTxt;
        this.fluBrf = fluBrf;
        this.fluTxt = fluTxt;
        mOneDayWeatherInfs = oneDayWeatherInfs;
        this.now = now;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.sportBrf = sportBrf;
        this.sportTxt = sportTxt;
        this.travBrf = travBrf;
        this.travTxt = travTxt;
        this.uvBrf = uvBrf;
        this.uvTxt = uvTxt;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getComfBrf() {
        return comfBrf;
    }

    public void setComfBrf(String comfBrf) {
        this.comfBrf = comfBrf;
    }

    public String getComfTxt() {
        return comfTxt;
    }

    public void setComfTxt(String comfTxt) {
        this.comfTxt = comfTxt;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public String getCwBrf() {
        return cwBrf;
    }

    public void setCwBrf(String cwBrf) {
        this.cwBrf = cwBrf;
    }

    public String getCwTxt() {
        return cwTxt;
    }

    public void setCwTxt(String cwTxt) {
        this.cwTxt = cwTxt;
    }

    public String getDrsgBrf() {
        return drsgBrf;
    }

    public void setDrsgBrf(String drsgBrf) {
        this.drsgBrf = drsgBrf;
    }

    public String getDrsgTxt() {
        return drsgTxt;
    }

    public void setDrsgTxt(String drsgTxt) {
        this.drsgTxt = drsgTxt;
    }

    public String getFluBrf() {
        return fluBrf;
    }

    public void setFluBrf(String fluBrf) {
        this.fluBrf = fluBrf;
    }

    public String getFluTxt() {
        return fluTxt;
    }

    public void setFluTxt(String fluTxt) {
        this.fluTxt = fluTxt;
    }

    public List<OneDayWeatherInfs> getOneDayWeatherInfs() {
        return mOneDayWeatherInfs;
    }

    public void setOneDayWeatherInfs(List<OneDayWeatherInfs> oneDayWeatherInfs) {
        mOneDayWeatherInfs = oneDayWeatherInfs;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public String getSportBrf() {
        return sportBrf;
    }

    public void setSportBrf(String sportBrf) {
        this.sportBrf = sportBrf;
    }

    public String getSportTxt() {
        return sportTxt;
    }

    public void setSportTxt(String sportTxt) {
        this.sportTxt = sportTxt;
    }

    public String getTravBrf() {
        return travBrf;
    }

    public void setTravBrf(String travBrf) {
        this.travBrf = travBrf;
    }

    public String getTravTxt() {
        return travTxt;
    }

    public void setTravTxt(String travTxt) {
        this.travTxt = travTxt;
    }

    public String getUvBrf() {
        return uvBrf;
    }

    public void setUvBrf(String uvBrf) {
        this.uvBrf = uvBrf;
    }

    public String getUvTxt() {
        return uvTxt;
    }

    public void setUvTxt(String uvTxt) {
        this.uvTxt = uvTxt;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "aqi=" + aqi +
                ", mOneDayWeatherInfs=" + mOneDayWeatherInfs +
                ", now=" + now +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", city='" + city + '\'' +
                ", cond_txt='" + cond_txt + '\'' +
                ", cnty='" + cnty + '\'' +
                ", comfBrf='" + comfBrf + '\'' +
                ", comfTxt='" + comfTxt + '\'' +
                ", cwBrf='" + cwBrf + '\'' +
                ", cwTxt='" + cwTxt + '\'' +
                ", drsgBrf='" + drsgBrf + '\'' +
                ", drsgTxt='" + drsgTxt + '\'' +
                ", fluBrf='" + fluBrf + '\'' +
                ", fluTxt='" + fluTxt + '\'' +
                ", sportBrf='" + sportBrf + '\'' +
                ", sportTxt='" + sportTxt + '\'' +
                ", travBrf='" + travBrf + '\'' +
                ", travTxt='" + travTxt + '\'' +
                ", uvBrf='" + uvBrf + '\'' +
                ", uvTxt='" + uvTxt + '\'' +
                '}';
    }
}
