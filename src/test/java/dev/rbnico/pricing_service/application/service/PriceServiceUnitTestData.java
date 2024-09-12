package dev.rbnico.pricing_service.application.service;

import dev.rbnico.pricing_service.domain.model.BrandEntity;
import dev.rbnico.pricing_service.domain.model.PriceEntity;
import dev.rbnico.pricing_service.domain.model.PriceListEntity;
import dev.rbnico.pricing_service.domain.model.ProductEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PriceServiceUnitTestData {

    public static List<PriceEntity> getData() {
        BrandEntity brand1 = BrandEntity.builder().id(BigInteger.ONE).name("ZARA").build();

        PriceListEntity list1 = PriceListEntity.builder().id(BigInteger.ONE).name("list1").build();
        PriceListEntity list2 = PriceListEntity.builder().id(BigInteger.TWO).name("list2").build();
        PriceListEntity list3 = PriceListEntity.builder().id(BigInteger.valueOf(3)).name("list3").build();
        PriceListEntity list4 = PriceListEntity.builder().id(BigInteger.valueOf(4)).name("list4").build();

        ProductEntity product1 = ProductEntity.builder().id(BigInteger.valueOf(35455)).name("product1").build();

        LocalDateTime startDate1 = LocalDateTime.of(2020,06,14,0,0);
        LocalDateTime endDate1 = LocalDateTime.of(2020, 12,31,23,59);

        LocalDateTime startDate2 = LocalDateTime.of(2020,06,14,15,0);
        LocalDateTime endDate2 = LocalDateTime.of(2020, 06,14,18,30);

        LocalDateTime startDate3 = LocalDateTime.of(2020,06,15,0,0);
        LocalDateTime endDate3 = LocalDateTime.of(2020, 6,15,11,0);

        LocalDateTime startDate4 = LocalDateTime.of(2020,06,15,16,0);
        LocalDateTime endDate4 = LocalDateTime.of(2020, 12,31,23,59);

        PriceEntity entity1 = PriceEntity.builder().id(BigInteger.valueOf(1)).brand(brand1).startDate(startDate1).endDate(endDate1).priceList(list1).product(product1).priority(0).price(BigDecimal.valueOf(35.50)).curr("EUR").build();
        PriceEntity entity2 = PriceEntity.builder().id(BigInteger.valueOf(2)).brand(brand1).startDate(startDate2).endDate(endDate2).priceList(list2).product(product1).priority(1).price(BigDecimal.valueOf(25.45)).curr("EUR").build();
        PriceEntity entity3 = PriceEntity.builder().id(BigInteger.valueOf(3)).brand(brand1).startDate(startDate3).endDate(endDate3).priceList(list3).product(product1).priority(1).price(BigDecimal.valueOf(30.50)).curr("EUR").build();
        PriceEntity entity4 = PriceEntity.builder().id(BigInteger.valueOf(4)).brand(brand1).startDate(startDate4).endDate(endDate4).priceList(list4).product(product1).priority(1).price(BigDecimal.valueOf(38.95)).curr("EUR").build();

        List<PriceEntity> list = Arrays.asList(entity1, entity2, entity3, entity4);
        return list;
    }
}
