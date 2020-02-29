package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    AddressService as;

    // @Mock
    // AddressDao ad;

    // @Before
    // public void init(){
    //     MockitoAnnotations.initMocks(this);
    // }

    @Test
    public void testReadAllAddresses(){
        Iterable<Address> add = as.findAll();
        assertNotNull(add);
    }

    @Test
    public void testFindAddressById(){
        Address add = as.findAddressById(1);
        assertTrue(add != null);
    }

    @Test
    public void testSaveNewAddress(){
        Address test = new Address("test-street", "test-city", "test-state", "test-zip", "test-country");
        // as.save(test);
        // verify(as, times(1)).save(test);
        System.out.println("****************Test**************** \n"+as.findAddressById(3));
        assertTrue(as.findAddressById(1) != null);
    }

    @Test
    public void testUpdateAddress(){
        Address add = as.findAddressById(1);
        add.setCity("Orlando");
        as.save(add);
        assertTrue(add.getCity().equals("Orlando"));
    }

    @Test
    public void testDeleteAddress(){
        Address delete = new Address(0, "delete-street", "delete-city", "delete-state", "delete-zip", "delete-country");
        as.save(delete);
        assertTrue(as.delete(delete) != null);
    }

}