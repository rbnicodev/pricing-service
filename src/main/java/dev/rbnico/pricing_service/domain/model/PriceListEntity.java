package dev.rbnico.pricing_service.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "PriceListEntity")
@Table(name = "PRICE_LISTS")
public class PriceListEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "priceList")
    private Set<PriceEntity> prices;

    //Others fields
}