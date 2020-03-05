// package com.rms.controller;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// import com.rms.model.Building;

// import org.junit.Before;
// import org.junit.Test;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MvcResult;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// public class BuildingControllerTest extends AbstractTest {

//     @Override
//     @Before
//     public void setUp() {
//         super.setUp();
//     }

//     @Test
//     public void getAllBuildings() throws Exception {
//         String uri = "/building/all";
//         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//                 .andReturn();

//         int status = mvcResult.getResponse().getStatus();
//         assertEquals(200, status);
//         String content = mvcResult.getResponse().getContentAsString();
//         Building[] add = super.mapFromJson(content, Building[].class);
//         assertTrue(add.length > 0);
//     }

// }