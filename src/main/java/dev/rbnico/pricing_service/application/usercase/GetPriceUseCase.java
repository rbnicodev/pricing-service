package dev.rbnico.pricing_service.application.usercase;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import dev.rbnico.pricing_service.application.service.PriceService;

@Component
public class GetPriceUseCase {

    @Autowired
    private PriceService priceService;

    public PriceResponseDTO execute(BigInteger productId, BigInteger brandId, LocalDateTime date) {
        List<PriceDTO> prices = priceService.getPriceByParams(productId, brandId, date);
        if (prices == null || prices.size() == 0) return null;
        PriceDTO result = prices.stream().max(Comparator.comparingInt(PriceDTO::getPriority)).orElse(null);
        return new PriceResponseDTO(result);
    }
}