package dev.rbnico.pricing_service.infrastructure.adapter.input.web;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPrices1() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "35455").param("brandId", "1").param("date", "2020-06-14T10:00:00").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(result -> {
            this.validateResponse(result.getResponse().getContentAsString(), 1, "Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        }).andDo(MockMvcResultHandlers.print());
    }
    @Test
    void getPrices2() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "35455").param("brandId", "1").param("date", "2020-06-14T16:00:00").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(result -> {
            this.validateResponse(result.getResponse().getContentAsString(), 2, "Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        }).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getPrices3() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "35455").param("brandId", "1").param("date", "2020-06-14T21:00:00").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(result -> {
            this.validateResponse(result.getResponse().getContentAsString(), 1, "Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        }).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getPrices4() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "35455").param("brandId", "1").param("date", "2020-06-15T10:00:00").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(result -> {
            this.validateResponse(result.getResponse().getContentAsString(), 3, "Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)");
        }).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getPrices5() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "35455").param("brandId", "1").param("date", "2020-06-16T21:00:00").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(result -> {
            this.validateResponse(result.getResponse().getContentAsString(), 4, "Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)");
        }).andDo(MockMvcResultHandlers.print());
    }

    private void validateResponse(String response, Integer value, String message) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            Integer priceListId = (Integer) jsonObject.get("priceListId");
             assertTrue(value.equals(priceListId), message);
        } catch (JSONException ex) {
            fail("Response error");
        }
    }
}
