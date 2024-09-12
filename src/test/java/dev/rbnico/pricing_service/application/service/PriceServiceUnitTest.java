package dev.rbnico.pricing_service.application.service;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import dev.rbnico.pricing_service.domain.model.BrandEntity;
import dev.rbnico.pricing_service.domain.model.PriceEntity;
import dev.rbnico.pricing_service.domain.model.PriceListEntity;
import dev.rbnico.pricing_service.domain.model.ProductEntity;
import dev.rbnico.pricing_service.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceServiceUnitTest {

    @Autowired
    private PriceServiceImpl priceService;

    @Mock
    private PriceRepository repository;

    @BeforeEach
    void setUp() {

        //Repository mock
        Mockito.lenient().when(this.repository.findPricesByParams(Mockito.any(BigInteger.class), Mockito.any(BigInteger.class), Mockito.any(LocalDateTime.class))).thenAnswer( input -> {
            BigInteger productId = input.getArgument(0);
            BigInteger brandId = input.getArgument(1);
            LocalDateTime date = input.getArgument(2);

            return PriceServiceUnitTestData.getData().stream().filter( priceEntity ->
                    productId.compareTo(priceEntity.getProduct().getId()) == 0
                    && brandId.compareTo(priceEntity.getBrand().getId()) == 0
                    && (date.isEqual(priceEntity.getStartDate()) || date.isAfter(priceEntity.getStartDate()))
                    && (date.isEqual(priceEntity.getEndDate()) || date.isBefore(priceEntity.getEndDate()))
            );
        });
    }

    @Test
    void getPriceByParams() {
        List<PriceDTO> prices = this.priceService.getPriceByParams(BigInteger.valueOf(35455), BigInteger.ONE, LocalDateTime.of(2020,06,14,10,0));

        assertNotNull(prices);
        assertTrue(prices.size() == 1);

        List<PriceDTO> prices2 = this.priceService.getPriceByParams(BigInteger.valueOf(35455), BigInteger.ONE, LocalDateTime.of(2020,06,14,16,0));

        assertNotNull(prices);
        assertTrue(prices2.size() == 2); //There are two records that meet the conditions

        List<PriceDTO> prices3 = this.priceService.getPriceByParams(BigInteger.valueOf(35455), BigInteger.ONE, LocalDateTime.of(2020,06,14,21,0));

        assertNotNull(prices);
        assertTrue(prices3.size() == 1);

        List<PriceDTO> prices4 = this.priceService.getPriceByParams(BigInteger.valueOf(35455), BigInteger.ONE, LocalDateTime.of(2020,06,15,10,0));

        assertNotNull(prices);
        assertTrue(prices4.size() == 2); //There are two records that meet the conditions

        List<PriceDTO> prices5 = this.priceService.getPriceByParams(BigInteger.valueOf(35455), BigInteger.ONE, LocalDateTime.of(2020,06,16,21,0));

        assertNotNull(prices);
        assertTrue(prices5.size() == 2); //There are two records that meet the conditions
    }
}