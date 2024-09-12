package dev.rbnico.pricing_service.domain.repository;

import dev.rbnico.pricing_service.domain.model.BrandEntity;
import dev.rbnico.pricing_service.domain.model.PriceEntity;
import dev.rbnico.pricing_service.domain.model.PriceListEntity;
import dev.rbnico.pricing_service.domain.model.ProductEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PriceRepositoryUnitTest {

    @Autowired
    private PriceRepository repository;

    @Test
    @DisplayName("Test 1: Find prices by params brandId, productId and dateTime")
    void findPricesByParams() {
        List<PriceEntity> result = this.repository.findPricesByParams(BigInteger.valueOf(35455L), BigInteger.ONE, LocalDateTime.of(2020,06,14,10,0));
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}