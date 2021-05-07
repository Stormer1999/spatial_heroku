package com.example.springgis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "AirpollutionPM25")
public class PM25 {
    @Id
    private UUID id;
    private String country;
    private String city;
    private int Year;
    private Double pm25;
    private Double latitude;
    private Double longitude;
    private Double population;
    private String wbinc16_text;
    private String Region;
    private String conc_pm25;
    private String color_pm25;
//    private Geometry geom;
}
