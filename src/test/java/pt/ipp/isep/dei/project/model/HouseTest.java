package pt.ipp.isep.dei.project.model;


import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseTest {

    @Test
    public void seeIfCalculateDistanceToSensorWorks(){
        House house = new House("rua coise e tal",new Local(4,5),"447-56");
        Sensor s = new Sensor("sensr1",new TypeSensor("temperatura"),new Local(4,6),new GregorianCalendar(2018,10,1).getTime());
        double result = house.calculateDistanceToSensor(s);
        assertEquals(110.91871788829754,result,0.01);
    }

    @Test
    public void seeIfgetTheMinorDistanceFromTheHouseToTheSensorWorks(){
        Sensor s1 = new Sensor("sensr1",new TypeSensor("temperatura"),new Local(4,6),new GregorianCalendar(2018,10,1).getTime());
        Sensor s2 = new Sensor("sensr2",new TypeSensor("temperatura"),new Local(4,8),new GregorianCalendar(2018,10,1).getTime());
        SensorList sensorList = new SensorList();
        sensorList.addSensor(s1);
        sensorList.addSensor(s2);
        GeographicArea ga = new GeographicArea(new TypeArea("cidade"),new Local(4,5),sensorList);
        House house = new House("casa de praia","rua coise e tal",new Local(4,5),"447-56");
        double result = house.getTheMinorDistanceFromTheHouseToTheSensor(ga);
        assertEquals(110.91871788829754,result,0.01);
    }

    @Test
    public void seeIfgetTheMinorDistanceFromTheHouseToTheSensorWorks2(){
        Sensor s1 = new Sensor("sensr1",new TypeSensor("temperatura"),new Local(4,8),new GregorianCalendar(2018,10,1).getTime());
        Sensor s2 = new Sensor("sensr5",new TypeSensor("temperatura"),new Local(4,6),new GregorianCalendar(2018,10,1).getTime());
        SensorList sensorList = new SensorList(s1);
        sensorList.addSensor(s2);
        GeographicArea ga = new GeographicArea(new TypeArea("cidade"),new Local(4,5),sensorList);
        House house = new House("casa de rua","rua coise e tal",new Local(4,5),"447-56");
        double result = house.getTheMinorDistanceFromTheHouseToTheSensor(ga);
        assertEquals(110.91871788829754,result,0.01);
    }

    @Test
    public void seeIfGetSensorWithTheMinimumDistanceToHouseWorks(){
        Sensor s1 = new Sensor("sensor1",new TypeSensor("temperature"),new Local(4,6),new GregorianCalendar(4,4,4).getTime());
        Sensor s2 = new Sensor("sensor2",new TypeSensor("temperature"),new Local(4,8),new GregorianCalendar(4,4,4).getTime());
        SensorList sensorList = new SensorList();
        sensorList.addSensor(s1);
        sensorList.addSensor(s2);
        GeographicArea ga = new GeographicArea(new TypeArea("cidade"),new Local(4,5),sensorList);
        House house = new House("casa","rua coise",new Local(4,5),"440-4");
        Sensor result= house.getSensorWithTheMinimumDistanceToHouse(ga,house);
        assertEquals(s1,result);
    }
    @Test
    public void seeIfGetSensorWithTheMinimumDistanceToHouseWorks2(){
        Sensor s1 = new Sensor("sensor1",new TypeSensor("temperature"),new Local(4,8),new GregorianCalendar(4,4,4).getTime());
        Sensor s2 = new Sensor("sensor2",new TypeSensor("temperature"),new Local(4,6),new GregorianCalendar(4,4,4).getTime());
        SensorList sensorList = new SensorList();
        sensorList.addSensor(s1);
        sensorList.addSensor(s2);
        GeographicArea ga = new GeographicArea(new TypeArea("cidade"),new Local(4,5),sensorList);
        House house = new House("casa","rua coise",new Local(4,5),"440-4");
        Sensor result= house.getSensorWithTheMinimumDistanceToHouse(ga,house);
        assertEquals(s2,result);
    }
}

