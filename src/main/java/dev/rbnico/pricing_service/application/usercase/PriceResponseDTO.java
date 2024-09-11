package dev.rbnico.pricing_service.application.usercase;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import dev.rbnico.pricing_service.application.dto.PriceDTO;
import dev.rbnico.pricing_service.domain.model.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class PriceResponseDTO {
    private BigInteger productId;
    private BigInteger brandId;
    private BigInteger priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public PriceResponseDTO(PriceEntity entity) {
        this(new PriceDTO(entity));
    }    

    public PriceResponseDTO(PriceDTO dto) {
        if (dto != null) {
            this.productId = dto.getProductId();
        this.brandId = dto.getBrandId();
        this.priceListId = dto.getPriceListId();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.price = dto.getPrice();
        }        
    }  
}