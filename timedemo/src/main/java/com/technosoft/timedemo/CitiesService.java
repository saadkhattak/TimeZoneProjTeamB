package com.technosoft.timedemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalTime;

import java.time.ZoneId;

@Service
public class CitiesService {

    static Map<String, String> cityToRegCityMap = new HashMap<>();

    public CityDto findTime(String givenCity) throws Exception {

        createMapping();

        CityDto cityDto = new CityDto();
        cityDto.setCity(givenCity);
        cityDto.setTime(getCityTime(givenCity));
        cityDto.setAvailable(isAvailableLocal(cityDto.getTime()));

        return cityDto;
    }



    /* Creates mapping for the city name to the region/city format */

    public void createMapping() {

        for (String zone : ZoneId.getAvailableZoneIds()) {

            String cityName = zone.substring(zone.lastIndexOf("/") + 1);

            cityToRegCityMap.put(cityName, zone);

        }


        for (String zone : cityToRegCityMap.keySet()) {

            System.out.println(cityToRegCityMap.get(zone));

        }

    }



    /*

     * Returns the local time for the given city

     * Throws exception if the given city is not found

     */

    public LocalTime getCityTime(String city) throws Exception {

        if (city.isEmpty()) {

            throw new Exception("City Value is Empty");

        }


        if (cityToRegCityMap.containsKey(city))

            return LocalTime.now(ZoneId.of(cityToRegCityMap.get(city).toString()));//.isAfter(afterTime);

        else

            throw new Exception("City not Found");

    }



    /*

     * Checks if the given local city time is between 21:00 and 9:00

     * */

    public boolean isAvailableLocal(LocalTime obtainedTime) throws Exception {

        LocalTime afterTwentyOne = LocalTime.parse("21:00");

        LocalTime beforeNine = LocalTime.parse("09:00");


        if (obtainedTime == null) {

            throw new Exception("Local Time parsing failed. Null Value Obtained");

        }


        if (obtainedTime.isAfter(afterTwentyOne) || (obtainedTime.isBefore(beforeNine)))

            return false;

        else

            return true;


    }

    /* Returns arrayList of city names for the dropdown list*/

    public List<String> getCityNames()
    {
        createMapping();
        List<String> cityNames = new ArrayList<String>();
        for(String cityName : cityToRegCityMap.keySet())
        {
            cityNames.add(cityName);
        }
        return cityNames;
    }
}
