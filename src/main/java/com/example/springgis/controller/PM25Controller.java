package com.example.springgis.controller;

import com.example.springgis.entity.PM25;
import com.example.springgis.service.PM25Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PM25Controller {

    @Autowired
    PM25Service service;

    //pass
    @GetMapping("/insertData")
    public Optional<PM25> insertData(@RequestBody PM25 pm25){
        return service.savePMvalue(pm25);
    }

    @GetMapping("/updateAllGeom")
    public void updateAllGeom(){
        service.updateGeom();
    }

    //pass
    @GetMapping("/getData")
    public List<PM25> getData(){
        return service.getPMvalue();
    }

    //pass
    @GetMapping("/getDataByYear")
    public List<PM25> getDataByYear(int year_input){
        return service.getPMvalueByYear(year_input);
    }

    //feature1 pass
    @GetMapping("/feature1")
    public List<PM25> feature1(int year_input){
        return service.getAllByYear(year_input);
    }
    //feature2 pass
    @GetMapping("/feature2")
    public List feature2(){
        return service.getClosestCityBKK();
    }
    //feature3 pass
    @GetMapping("/feature3")
    public List feature3(){
        return service.getNeighborCountry();
    }
    //feature4
    @GetMapping("/feature4")
    public List<PM25> feature4(){
        return service.getFourPoint();
    }
    //feature5 pass
    @GetMapping("/feature5")
    public List<PM25> feature5(){
        return service.getHighestCity();
    }
    //feature6 pass
    @GetMapping("/feature6")
    public List<PM25> feature6(int year_input){
        return service.getLowIncomeByYear(year_input);
    }
}
