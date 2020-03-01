package com.rms.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.ResourceMetadataDao;
import com.rms.model.ResourceMetadata;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RmdServiceTest {

    @InjectMocks
    ResourceMetadataService rms;

    @Mock
    ResourceMetadataDao rmd;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNewAddress() {
        ResourceMetadata test = new ResourceMetadata(1, 1, 1);
        System.out.println(test);
        rms.save(test);
        verify(rmd, times(1)).save(test);
    }

    @Test
    public void testFindAddressById() {
        when(rmd.findById(1)).thenReturn(new ResourceMetadata(1, 1, 1));
        ResourceMetadata test = rms.findById(1);
        assertNotNull(test);
    }

    @Test
    public void testUpdateAddress() {
        ResourceMetadata test = new ResourceMetadata(1, 1, 1);
        rms.save(test);
        ResourceMetadata test2 = rms.findById(1);
        test2 = new ResourceMetadata(1, 1, 1);
        rms.update(test2);
        assertNotSame(test, test2);
    }
    
}