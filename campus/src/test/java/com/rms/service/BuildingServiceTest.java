package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rms.model.Building;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingServiceTest {

    @InjectMocks
    BuildingService bs;

    @Test
    public void testReadAllBuildings(){
        Iterable<Building> build = bs.findAll();
        assertNotNull(build);
    }

    @Test
    public void testFindBuildingById(){
        Building build = bs.findBuildingById(1);
        assertTrue(build != null);
    }

    @Test
    public void testSaveNewBuilding(){
        bs.save(new Building("test-name", "test-abbrname", null, 0, null, null, null));
        Building build = bs.findBuildingById(1);
        assertNotNull(build);
    }

    @Test
    public void testUpdateBuilding(){
        Building build = bs.findBuildingById(1);
        build.setName("test-new name");
        bs.update(build);
        assertTrue(build.getName().equals("test-new name"));
    }

    @Test
    public void testDeleteBuilding(){
        bs.deleteById(1);
        assertTrue(bs.findBuildingById(1) == null);
    }
}