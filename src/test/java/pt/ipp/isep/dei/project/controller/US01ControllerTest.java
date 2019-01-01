package pt.ipp.isep.dei.project.controller;

import pt.ipp.isep.dei.project.model.*;
import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;

public class US01ControllerTest {

    @Test
    public void seeIfnewTAGWorks() {
        TypeAreaList newList = new TypeAreaList();
        US01Controller ctrl = new US01Controller(newList);
        boolean result = ctrl.createAndAddTypeAreaToList("cidade");
        assertTrue(result);
    }

    @Test
    public void seeIfnewTAGWorksWithAnother() {
        TypeArea tipo = new TypeArea("rua");
        TypeAreaList newList = new TypeAreaList();
        newList.addTypeArea(tipo);
        US01Controller ctrl = new US01Controller(newList);
        boolean result = ctrl.createAndAddTypeAreaToList("cidade");
        assertTrue(result);
    }

    @Test
    public void seeIfnewTAGDoesntWorkWhenDuplicatedISAdded() {
        TypeArea tipo = new TypeArea("cidade");
        TypeAreaList expectedResult = new TypeAreaList();
        expectedResult.addTypeArea(tipo);
        US01Controller ctrl = new US01Controller(expectedResult);
        boolean result = ctrl.createAndAddTypeAreaToList("cidade");
        assertFalse(result);
    }

    @Test
    public void seeIfNewTAGDoesntWorkWhenNullIsAdded(){
        TypeArea tipo = new TypeArea("cidade");
        TypeAreaList list = new TypeAreaList();
        list.addTypeArea(tipo);
        US01Controller ctrl = new US01Controller(list);
        boolean result = ctrl.createAndAddTypeAreaToList(null);
        assertFalse(result);
    }

    @Test
    public void seeIfNewTAGDoesntWorkWhenNameIsEmpty(){
        TypeArea tipo = new TypeArea("cidade");
        TypeAreaList list = new TypeAreaList();
        list.addTypeArea(tipo);
        US01Controller ctrl = new US01Controller(list);
        boolean result = ctrl.createAndAddTypeAreaToList("");
        assertFalse(result);
    }
    @Test
    public void seeIfNewTAGDoesntWorkWhenNumbersAreAdded(){
        TypeArea tipo = new TypeArea("cidade");
        TypeAreaList list = new TypeAreaList();
        list.addTypeArea(tipo);
        US01Controller ctrl = new US01Controller(list);
        boolean result = ctrl.createAndAddTypeAreaToList("cidade1");
        assertFalse(result);
    }
}