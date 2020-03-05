package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.BuildingDao;
import com.rms.model.Address;
import com.rms.model.Amenity;
import com.rms.model.Building;
import com.rms.model.ResourceMetadata;
import com.rms.model.Room;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BuildingServiceTest {

    @InjectMocks
    BuildingService bs;

    @Mock
    BuildingDao bd;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNewBuilding() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        bs.save(build);
        verify(bd, times(1)).save(build);
    }

    @Test
    public void testFindBuildingById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        when(bd.findById(1)).thenReturn(new Building("test-name", "test-abbr", add, 1, am, room, rmd));
        Building build = bs.findBuildingById(1);
        assertEquals("test-name", build.getName());
        assertEquals("test-abbr", build.getAbbrName());
    }

    @Test
    public void testReadAllAmenites() {
        Iterable<Building> build = bs.findAll();
        assertNotNull(build);
    }

    @Test
    public void testUpdateBuilding() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        bs.save(build);
        Building build2 = bs.findBuildingById(1);
        build2 = new Building("test-name2", "test-abbr", add, 1, am, room, rmd);
        bs.update(build2);
        assertEquals("test-name2", build2.getName());
    }

    @Test
    public void testDeleteBuilding() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        bs.save(build);
        Building build2 = bs.findBuildingById(1);
        bs.delete(build2);
        Building build3 = bs.findBuildingById(1);
        assertFalse(build3 != null);
    }

    @Test
    public void testUpdateById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        bs.save(build);
        Building build2 = bs.findBuildingById(1);
        build2 = new Building("test-name2", "test-abbr", add, 1, am, room, rmd);
        bs.updateById(1);
        assertEquals("test-name2", build2.getName());
    }

    @Test
    public void testDeleteById(){
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        Amenity[] am = new Amenity[2];
        Room[] room = new Room[3];
        ResourceMetadata rmd = new ResourceMetadata();
        Building build = new Building("test-name", "test-abbr", add, 1, am, room, rmd);
        bs.save(build);
        bs.deleteById(1);
        Building build2 = bs.findBuildingById(1);
        assertFalse(build2 != null);
    }
}