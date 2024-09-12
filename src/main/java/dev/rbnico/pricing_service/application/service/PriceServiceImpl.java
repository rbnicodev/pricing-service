package dev.rbnico.pricing_service.application.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import dev.rbnico.pricing_service.domain.model.PriceEntity;
import dev.rbnico.pricing_service.domain.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    private PriceRepository priceRepository;

    public List<PriceDTO> getPriceByParams(BigInteger productId, BigInteger brandId, LocalDateTime date) {
        List<PriceEntity> prices = priceRepository.findPricesByParams(productId, brandId, date);
        if (prices == null) return null;
        return prices.stream().map(price -> new PriceDTO(price)).collect(Collectors.toList());
    }
}
