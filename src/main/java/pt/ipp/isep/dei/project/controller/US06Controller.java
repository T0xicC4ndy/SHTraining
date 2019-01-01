package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.model.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * User Story 06
 * As a system administrator, I want to be able to manually input a new sensor and add it to a pre-input Geographic Area
 */

public class US06Controller {

    private Local mLocal;
    private Date mDate;
    private TypeSensor mType;
    private Sensor mSensor;

    public US06Controller() {
        /*
         * Builder US06Controller(), with no parameters, as it will only be used in ui to apply methods on given inputs
         */
    }

    /**
     * Method to create a Local with given doubles
     * Calls the original method from model
     * @param latitude Latitude
     * @param latitude Longitude
     * @param latitude Altitude
     * @return Local created
     */
    public Local createLocal(Double latitude, Double longitude, Double altitude) {
        Local local = new Local(latitude, longitude, altitude);
        this.mLocal = local;
        return this.mLocal;
    }
    public Date createDate(int year, int month, int day) {
        Date date = new GregorianCalendar(year, month, day).getTime();
        this.mDate = date;
        return this.mDate;
    }
    public TypeSensor createType(String sensorType){
        this.mType = new TypeSensor(sensorType);
        return this.mType;
    }
    public Sensor createSensor (String name, TypeSensor type, Local local, Date date){
        this.mSensor = new Sensor(name,type,local,date);
        return mSensor;
    }
    /**
     * Method to add a Sensor to a SensorList
     * Calls the original method from model
     */
    public boolean addSensor(Sensor sensor, SensorList sensorList){
        if(sensorList.containsSensor(sensor)) {
            sensorList.getSensorList().add(sensor);
            return false;
        }
        return true;
    }
    /**
     * Method to check if a list is either composed by null values or is empty
     *
     */
    private boolean checkIfListValid(List<GeographicArea> values) {
        if (values == null || values.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * Method to add a SensorList to a GeographicArea given that both the name of the Geographis Area and the name given
     * as parameter match
     * Calls the original method from model
     */

    public boolean addSensorToGeographicArea(String name, GeographicAreaList gaList, SensorList sensorList) {
        if (checkIfListValid(gaList.getGeographicAreaList())) {
            for (GeographicArea ga : gaList.getGeographicAreaList())
                if ((ga.getName().equals(name))) {
                    ga.setSensorList(sensorList);
                    return true;
                }
        }
    return false;
    }

    public Local getLocal() {
        return this.mLocal;
    }
    public TypeSensor getType() {
        return this.mType;
    }
    public Date getDate() {
        return this.mDate;
    }
    public Sensor getSensor() {
        return this.mSensor;
    }
}
