package dev.rbnico.pricing_service.application.usercase;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import dev.rbnico.pricing_service.application.service.PriceService;
import dev.rbnico.pricing_service.application.service.PriceServiceImpl;
import dev.rbnico.pricing_service.domain.model.BrandEntity;
import dev.rbnico.pricing_service.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GetPriceUseCaseUnitTest {

    @Autowired
    private GetPriceUseCase useCase;

    @MockitoBean
    private PriceServiceImpl priceService;
    PriceDTO price1 = PriceDTO.builder().priceListId(BigInteger.ONE).startDate(LocalDateTime.MIN).endDate(LocalDateTime.MAX).priority(0).build();
    PriceDTO price2 = PriceDTO.builder().priceListId(BigInteger.TWO).startDate(LocalDateTime.MIN).endDate(LocalDateTime.MAX).priority(1).build();
    List<PriceDTO> results = Arrays.asList(price1, price2);

    @Test
    void executeTest() {
        Mockito.lenient().when(this.priceService.getPriceByParams(Mockito.any(BigInteger.class), Mockito.any(BigInteger.class), Mockito.any(LocalDateTime.class))).thenReturn(results);
        PriceResponseDTO result = this.useCase.execute(BigInteger.ONE, BigInteger.ONE, LocalDateTime.now());
        assertNotNull(result);
        assertEquals(BigInteger.TWO, result.getPriceListId());
    }

    @Test
    void executeTest2() {
        Mockito.lenient().when(this.priceService.getPriceByParams(Mockito.any(BigInteger.class), Mockito.any(BigInteger.class), Mockito.any(LocalDateTime.class))).thenReturn(Arrays.asList(price1));
        PriceResponseDTO result = this.useCase.execute(BigInteger.ONE, BigInteger.ONE, LocalDateTime.now());
        assertNotNull(result);
        assertEquals(BigInteger.ONE, result.getPriceListId());
    }

}