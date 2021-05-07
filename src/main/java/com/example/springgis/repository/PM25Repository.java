package com.example.springgis.repository;

import com.example.springgis.entity.PM25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PM25Repository extends JpaRepository<PM25, UUID> {

    @Query(value = "UPDATE airpollutionpm25 SET geom = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326)",nativeQuery = true)
    void updateAllGeom();

    @Query("FROM PM25 WHERE Year = ?1")
    List<PM25> findByYear(int year);

    //5a pass
    @Query("FROM PM25 WHERE Year = ?1")
    List<PM25> getByYear(int year_input);

    //5b
    @Query(value = "select distinct city , st_distance (geom,st_geomfromtext('POINT(100.5544779 13.74622118)',4326)) as distance ,latitude,longitude from airpollutionpm25 where city != 'bangkok' and country != 'Thailand'Order by distance ASC limit 50",nativeQuery = true)
    List getClosest();

    //5c
    @Query(value = "select distinct country , st_distance (geom,st_geomfromtext('POINT(100.5544779 13.74622118)',4326)) as distance ,latitude,longitude from airpollutionpm25 where YEAR =2018 and country != 'Thailand'Order by distance ASC",nativeQuery = true)
    List getNeighbor();

    //5d marked
    @Query("FROM PM25 WHERE country = 'Thailand' AND Year = 2009")
    List<PM25> fourPoint();

    //5e
    @Query(value = "select * from airpollutionpm25 as a3 where country = ( select a1.country from airpollutionpm25 as a1 where Year = 2011 group by a1.country order by count(a1.city) desc LIMIT 1)AND Year = 2011",nativeQuery = true)
    List<PM25> highestCityPoint();

    //5f
    @Query("FROM PM25 WHERE wbinc16_text='low income' AND Year = ?1")
    List<PM25> lowIncome(int year_input);
}

