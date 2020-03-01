package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AddressServiceTest {

    @InjectMocks
    AddressService as;

    @Mock
    AddressDao ad;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNewAddress() {
        Address test = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(test);
        verify(ad, times(1)).save(test);
    }

    @Test
    public void testFindAddressById() {
        when(ad.findById(1))
                .thenReturn(new Address("test-street", "test-city", "test-state", "test-zip", "test-country"));
        Address add = as.findAddressById(1);
        assertEquals("test-street", add.getUnitStreet());
        assertEquals("test-city", add.getCity());
        assertEquals("test-state", add.getState());
    }

    @Test
    public void testReadAllAddresses() {
        Iterable<Address> add = as.findAll();
        assertNotNull(add);
    }

    @Test
    public void testUpdateAddress() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        Address add2 = as.findAddressById(1);
        add2 = new Address("test-street2", "test-city", "test-state", "test-zip", "test-country");
        as.update(add2);
        assertEquals("test-street2", add2.getUnitStreet());
    }

    @Test
    public void testDeleteAddress() {
        Address delete = new Address(0, "delete-street", "delete-city", "delete-state", "delete-zip", "delete-country");
        as.save(delete);
        Address add2 = as.findAddressById(1);
        as.delete(add2);
        Address add3 = as.findAddressById(1);
        assertFalse(add3 != null);
    }

    @Test
    public void testUpdateById() {
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        Address add2 = as.findAddressById(1);
        add2 = new Address("test-street2", "test-city", "test-state", "test-zip", "test-country");
        as.updateById(1);
        assertEquals("test-street2", add2.getUnitStreet());
    }

    @Test
    public void testDeleteById(){
        Address add = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        as.save(add);
        as.deleteById(1);
        Address add2 = as.findAddressById(1);
        assertFalse(add2 != null);
    }

}