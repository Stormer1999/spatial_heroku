package com.example.springgis.service;

import com.example.springgis.entity.PM25;
import com.example.springgis.repository.PM25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PM25Service {
    @Autowired
    private PM25Repository repository;

    public Optional<PM25> savePMvalue(PM25 pm25){
            UUID id = UUID.randomUUID();
            pm25.setId(id);
            repository.save(pm25);
            return repository.findById(id);
        }
    public void updateGeom(){
        repository.updateAllGeom();
    }

    public List<PM25> getPMvalue(){
        return repository.findAll();
    }

    public List<PM25> getPMvalueByYear(int year){
        return repository.findByYear(year);
    }

    //feature1 (5a)
    public List<PM25> getAllByYear(int year_input){
        return repository.getByYear(year_input);
    }
    //feature2 (5b)
    public List getClosestCityBKK(){
        return repository.getClosest();
    }
    //feature3 (5c)
    public List getNeighborCountry(){
        return repository.getNeighbor();
    }

    //feature4 (5d)
    public List<PM25> getFourPoint(){
        return repository.fourPoint();
    }

    //feature5 (5e)
    public List<PM25> getHighestCity(){
        return repository.highestCityPoint();
    }

    //feature6 (5f)
    public List<PM25> getLowIncomeByYear(int year_input){
        return repository.lowIncome(year_input);
    }
}
