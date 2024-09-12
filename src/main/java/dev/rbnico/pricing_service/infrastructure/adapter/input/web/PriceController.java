package dev.rbnico.pricing_service.infrastructure.adapter.input.web;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponseDTO> getPrices(@RequestParam BigInteger productId,
                                            @RequestParam BigInteger brandId,
                                            @RequestParam("date") String dateStr) {
        try {
            LocalDateTime date = (dateStr != null) ? LocalDateTime.parse(dateStr) : LocalDateTime.now();
            PriceResponseDTO result = getPriceUseCase.execute(productId, brandId, date);
            if (result == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (DateTimeParseException dateException) {
            //TODO: Create custom exceptions to correctly report errors to the user
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}