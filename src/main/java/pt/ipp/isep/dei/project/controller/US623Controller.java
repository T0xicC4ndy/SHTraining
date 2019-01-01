package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.model.GeographicArea;
import pt.ipp.isep.dei.project.model.GeographicAreaList;
import pt.ipp.isep.dei.project.model.House;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * US623UI: As a Regular User, I want to get the average daily rainfall in the house area for a
 * given period (days), as it is needed to assess the garden’s watering needs.
 **/

public class US623Controller {

    public String printGAList(GeographicAreaList geoAreaList) {
        return geoAreaList.printGaList(geoAreaList);
    }

    public String printHouseList(GeographicArea geoArea) {
       return geoArea.getHouseList().printHouseList(geoArea);
    }

    public double getAVGDailyRainfallOnGivenPeriod(House house, Date minDay, Date maxDay) {
        GeographicArea geoArea = house.getmMotherArea();
        return geoArea.getAvgReadingsFromSensorTypeInGA("Rain", minDay, maxDay);
    }

    public Date createDate(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }
}

