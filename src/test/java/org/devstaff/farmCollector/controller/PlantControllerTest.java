package org.devstaff.farmCollector.controller;

import org.devstaff.farmCollector.dao.entity.Crop;
import org.devstaff.farmCollector.dao.entity.Farm;
import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.dao.entity.Plant;
import org.devstaff.farmCollector.model.HarvestDTO;
import org.devstaff.farmCollector.model.PlantDTO;
import org.devstaff.farmCollector.service.PlantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlantController.class)
class PlantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantService mockPlantService;

    @Test
    void testSaveHarvest() throws Exception {
        Plant savedPlant = new Plant();
        savedPlant.setId(1L);
        savedPlant.setExpectedProduct(200.0);

        when(mockPlantService.savePlant(any(PlantDTO.class))).thenReturn(savedPlant);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/plant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"expectedProduct\":\"200.0\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.expectedProduct").value("200.0"));
    }

    @Test
    void testGetAllPlantings() throws Exception {
        when(mockPlantService.getAllPlants()).thenReturn(Collections.emptyList());

        final MockHttpServletResponse response = mockMvc.perform(get("/api/plant")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
