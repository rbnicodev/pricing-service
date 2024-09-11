/*
package dev.rbnico.pricing_service.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PriceServiceTest {

    @Autowired
    private PriceService priceService;

    @Test
    void testGetPriceByParams() {
        BigInteger productId = BigInteger.valueOf(35455);
        BigInteger brandId = BigInteger.valueOf(1);
        LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 6, 14, 16, 0);
        LocalDateTime date3 = LocalDateTime.of(2020, 6, 14, 21, 0);
        LocalDateTime date4 = LocalDateTime.of(2020, 6, 15, 10, 0);
        LocalDateTime date5 = LocalDateTime.of(2020, 6, 16, 21, 0);


        List<PriceDTO> result1 = priceService.getPriceByParams(productId, brandId, date1);
        List<PriceDTO> result2 = priceService.getPriceByParams(productId, brandId, date2);
        List<PriceDTO> result3 = priceService.getPriceByParams(productId, brandId, date3);
        List<PriceDTO> result4 = priceService.getPriceByParams(productId, brandId, date4);
        List<PriceDTO> result5 = priceService.getPriceByParams(productId, brandId, date5);

        assertEquals(1, result1.size(), "Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(2, result2.size(), "Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(1, result3.size(), "Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(2, result4.size(), "Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(2, result5.size(), "Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)");
    }
}
* */