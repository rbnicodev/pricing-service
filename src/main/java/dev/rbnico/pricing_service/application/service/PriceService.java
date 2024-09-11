package dev.rbnico.pricing_service.application.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import dev.rbnico.pricing_service.application.dto.PriceDTO;


public interface PriceService {

    /**
     * 
     * @param productId
     * @param brandId
     * @param date
     * @return
     */
    public List<PriceDTO> getPriceByParams(BigInteger productId, BigInteger brandId, LocalDateTime date);
}