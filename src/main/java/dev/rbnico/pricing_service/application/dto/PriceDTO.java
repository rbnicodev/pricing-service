package dev.rbnico.pricing_service.application.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import dev.rbnico.pricing_service.domain.model.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PriceDTO {
    private BigInteger productId;
    private BigInteger brandId;
    private BigInteger priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private Integer priority;

    public PriceDTO(PriceEntity entity) {
        if (entity != null) {
            this.productId = (entity.getProduct() != null) ? entity.getProduct().getId() : null;
            this.brandId = (entity.getBrand() != null) ? entity.getBrand().getId() : null;
            this.priceListId = (entity.getPriceList() != null) ? entity.getPriceList().getId() : null;
            this.startDate = entity.getStartDate();
            this.endDate = entity.getEndDate();
            this.price = entity.getPrice();
            this.priority = entity.getPriority();
        }
    }    
}
