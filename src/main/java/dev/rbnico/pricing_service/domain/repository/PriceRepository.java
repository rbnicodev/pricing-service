package dev.rbnico.pricing_service.domain.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.rbnico.pricing_service.domain.model.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, BigInteger> {

    @Query("SELECT p FROM PriceEntity p WHERE p.product.id = :productId AND p.brand.id = :brandId AND :date BETWEEN p.startDate AND p.endDate")
    List<PriceEntity> findPricesByParams(@Param("productId") BigInteger productId,
                                         @Param("brandId") BigInteger brandId,
                                         @Param("date") LocalDateTime date);
}