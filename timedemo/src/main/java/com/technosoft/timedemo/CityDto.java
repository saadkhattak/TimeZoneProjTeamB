package com.technosoft.timedemo;

import java.time.LocalTime;

public class CityDto {
    private String city;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private LocalTime time;
    private boolean isAvailable;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
