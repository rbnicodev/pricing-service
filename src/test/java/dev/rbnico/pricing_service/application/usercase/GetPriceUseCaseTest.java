/*
* package dev.rbnico.pricing_service.application.usercase;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class GetPriceUseCaseTest {

    @Autowired
    private GetPriceUseCase getPriceUseCase;

    @Test
    void testGetPriceByParams() {
        BigInteger productId = BigInteger.valueOf(35455);
        BigInteger brandId = BigInteger.valueOf(1);
        LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 6, 14, 16, 0);
        LocalDateTime date3 = LocalDateTime.of(2020, 6, 14, 21, 0);
        LocalDateTime date4 = LocalDateTime.of(2020, 6, 15, 10, 0);
        LocalDateTime date5 = LocalDateTime.of(2020, 6, 16, 21, 0);


        PriceResponseDTO result1 = getPriceUseCase.execute(productId, brandId, date1);
        PriceResponseDTO result2 = getPriceUseCase.execute(productId, brandId, date2);
        PriceResponseDTO result3 = getPriceUseCase.execute(productId, brandId, date3);
        PriceResponseDTO result4 = getPriceUseCase.execute(productId, brandId, date4);
        PriceResponseDTO result5 = getPriceUseCase.execute(productId, brandId, date5);

        assertEquals(BigInteger.valueOf(1), result1.getPriceListId(), "Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(BigInteger.valueOf(2), result2.getPriceListId(), "Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(BigInteger.valueOf(1), result3.getPriceListId(), "Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(BigInteger.valueOf(3), result4.getPriceListId(), "Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)");
        assertEquals(BigInteger.valueOf(4), result5.getPriceListId(), "Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)");
    }
}*/