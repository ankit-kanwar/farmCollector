package org.devstaff.farmCollector.controller;

import org.devstaff.farmCollector.dao.entity.Crop;
import org.devstaff.farmCollector.dao.entity.Farm;
import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.model.HarvestDTO;
import org.devstaff.farmCollector.service.HarvestServiceImpl;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HarvestController.class)
class HarvestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HarvestServiceImpl mockHarvestService;

    @Test
    void testSaveHarvest() throws Exception {
        Harvest savedHarvest = new Harvest();
        savedHarvest.setId(1L);
        savedHarvest.setActualProduct(200.0);
        when(mockHarvestService.saveHarvest(any(HarvestDTO.class))).thenReturn(savedHarvest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/harvest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\":1,\"cropId\":1,\"seasonId\":1,\"actualProduct\":\"200.0\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.actualProduct").value("200.0"));
    }

    @Test
    void testGetAllHarvests() throws Exception {
        when(mockHarvestService.getAllHarvest()).thenReturn(Collections.emptyList());

        final MockHttpServletResponse response = mockMvc.perform(get("/api/harvest")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
