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
import com.rms.model.ResourceMetadata;

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
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.save(camp);
        verify(cd, times(1)).save(camp);
    }

    @Test
    public void testFindCampusById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        when(cd.findById(1)).thenReturn(new Campus ("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd));
        Campus camp = cs.findCampusById(1);
        assertEquals("test-name", camp.getName());
        assertEquals("test-abbr", camp.getAbbrName());
    }

    @Test
    public void testReadAllAmenites() {
        Iterable<Campus> camp = cs.findAll();
        assertNotNull(camp);
    }

    @Test
    public void testUpdateCampus() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        camp2 = new Campus("test-name2", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.update(camp2);
        assertEquals("test-name2", camp2.getName());
    }

    @Test
    public void testDeleteCampus() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        // cs.deleteById(camp2.getId());
        Campus camp3 = cs.findCampusById(1);
        assertFalse(camp3 != null);
    }

    @Test
    public void testUpdateById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.save(camp);
        Campus camp2 = cs.findCampusById(1);
        camp2 = new Campus("test-name2", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.updateById(1);
        assertEquals("test-name2", camp2.getName());
    }

    @Test
    public void testDeleteById(){
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Building[] build = new Building[2];
        int[] corpEmp = new int[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Campus camp = new Campus("test-name", "test-abbr", add, 1, 1, 1, build, corpEmp, rmd);
        cs.save(camp);
        cs.deleteById(1);
        Campus camp2 = cs.findCampusById(1);
        assertFalse(camp2 != null);
    }
    
}