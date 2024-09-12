package dev.rbnico.pricing_service.infrastructure.adapter.input.web;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.rbnico.pricing_service.application.usercase.GetPriceUseCase;
import dev.rbnico.pricing_service.application.usercase.PriceResponseDTO;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private GetPriceUseCase getPriceUseCase;

    @GetMapping
    public PriceResponseDTO getPrices(@RequestParam BigInteger productId,
                                            @RequestParam BigInteger brandId,
                                            @RequestParam("date") String dateStr) {
        LocalDateTime date = LocalDateTime.parse(dateStr);
        PriceResponseDTO result = getPriceUseCase.execute(productId, brandId, date);
        return result;
    }
}