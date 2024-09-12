package dev.rbnico.pricing_service.infrastructure.adapter.input.web;

import dev.rbnico.pricing_service.application.usercase.GetPriceUseCase;
import dev.rbnico.pricing_service.application.usercase.PriceResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(PriceController.class)
class PriceControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GetPriceUseCase useCase;

    @BeforeEach
    void setUp() {
        PriceResponseDTO response = PriceResponseDTO.builder()
                .price(BigDecimal.ONE)
                .priceListId(BigInteger.ONE)
                .brandId(BigInteger.ONE)
                .endDate(LocalDateTime.MAX)
                .startDate(LocalDateTime.MAX)
                .build();
        Mockito.lenient().when(this.useCase.execute(Mockito.any(BigInteger.class), Mockito.any(BigInteger.class), Mockito.any(LocalDateTime.class))).thenReturn(response);
    }

    @Test
    void getPrices() throws Exception {
        mockMvc.perform(get("/api/prices").param("productId", "1").param("brandId", "1").param("date", "2020-06-14T10:00:00")).andExpect(status().isOk());
    }
}