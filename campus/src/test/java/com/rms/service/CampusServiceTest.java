package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.CampusDao;
import com.rms.model.Address;
import com.rms.model.Building;
import com.rms.model.Campus;
import com.rms.model.FullName;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class CampusServiceTest {

    @InjectMocks
    CampusService cs;

    @Mock
    CampusDao cd;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNewCampus() {
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus(name, add, 1, 1, 1, build, corpEmp);
        cs.save(camp);
        verify(cd, times(1)).save(camp);
    }

    @Test
    public void testFindCampusById() {
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        when(cd.findById(1)).thenReturn(new Campus (name, add, 1, 1, 1, build, corpEmp));
        Campus camp = cs.findCampusById(1);
        assertEquals("test-name", camp.getName());
        assertEquals(1, camp.getTrainingManagerId());
    }

    @Test
    public void testReadAllAmenites() {
        Iterable<Campus> camp = cs.findAll();
        assertNotNull(camp);
    }

    @Test
    public void testUpdateCampus() {
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus(name, add, 1, 1, 1, build, corpEmp);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        camp2 = new Campus(name, add, 2, 1, 1, build, corpEmp);
        cs.update(camp2);
        assertEquals(2, camp2.getTrainingManagerId());
    }

    @Test
    public void testDeleteCampus() {
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus(name, add, 1, 1, 1, build, corpEmp);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        cs.delete(camp2);
        Campus camp3 = cs.findCampusById(1);
        assertFalse(camp3 != null);
    }

    @Test
    public void testUpdateById() {
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus(name, add, 1, 1, 1, build, corpEmp);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        camp2 = new Campus(name, add, 2, 1, 1, build, corpEmp);
        cs.updateById(1);
        assertEquals(2, camp2.getTrainingManagerId());
    }

    @Test
    public void testDeleteById(){
        FullName name = new FullName("test-name", "test-abbr");
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        Campus camp = new Campus(name, add, 1, 1, 1, build, corpEmp);
        cs.save(camp);
        cs.deleteById(1);
        Campus camp2 = cs.findCampusById(1);
        assertFalse(camp2 != null);
    }
    
}