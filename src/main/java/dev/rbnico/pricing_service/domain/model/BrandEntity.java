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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "BrandEntity")
@Table(name = "BRANDS")
public class BrandEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "brand")
    private Set<PriceEntity> prices;

    //Others fields
}
