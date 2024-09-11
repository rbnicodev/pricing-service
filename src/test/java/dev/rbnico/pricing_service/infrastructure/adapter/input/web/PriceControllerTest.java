/*package dev.rbnico.pricing_service.infrastructure.adapter.input.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rbnico.pricing_service.application.usercase.GetPriceUseCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GetPriceUseCase getPriceUseCase;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testGetPrices() throws Exception {

        this.mockMvc.perform(get("/api/prices").param("brandId", "1").param("productId", "35455").param("date", "2020-06-14T10:00:00")).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/prices").param("brandId", "1").param("productId", "35455").param("date", "2020-06-14T16:00:00")).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/prices").param("brandId", "1").param("productId", "35455").param("date", "2020-06-14T21:00:00")).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/prices").param("brandId", "1").param("productId", "35455").param("date", "2020-06-15T10:00:00")).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/prices").param("brandId", "1").param("productId", "35455").param("date", "2020-06-16T21:00:00")).andExpect(status().isOk());

    }


}*/