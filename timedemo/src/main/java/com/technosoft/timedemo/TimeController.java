package com.technosoft.timedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class TimeController {

    @Autowired
    private CitiesService citiesService;

    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @GetMapping("/time/{city}")
    public CityDto findTime(@PathVariable String city) throws Exception {
        return citiesService.findTime(city);
    }

    @GetMapping("/cities")
    public List<String> getCities() {
        return citiesService.getCityNames();
    }
}
