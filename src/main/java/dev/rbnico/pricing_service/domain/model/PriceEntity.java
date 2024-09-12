package dev.rbnico.pricing_service.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "PriceEntity")
@Table(name = "PRICES")
public class PriceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate; 

    @ManyToOne()
    @JoinColumn(name = "price_list")
    private PriceListEntity priceList;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "curr", nullable = false, length = 3)
    private String curr;

    @Transient
    private Currency currency;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void loadCurrency() {
        if (this.curr != null) {
            this.currency = Currency.getInstance(curr);
        }
    }

    @PrePersist
    @PreUpdate
    private void saveCurrency() {
        if (this.currency != null) {
            this.curr = currency.getCurrencyCode();
        }
    }

}
