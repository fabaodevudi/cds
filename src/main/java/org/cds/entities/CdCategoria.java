package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CD_CATEGORIA")
@Data
@EqualsAndHashCode(callSuper = true)
public class CdCategoria extends PanacheEntity {
    @Column(name = "menor_preco", precision = 14, scale = 2)
    private BigDecimal menorPreco;

    @Column(name = "maior_preco", precision = 14, scale = 2)
    private BigDecimal maiorPreco;

    @ManyToMany(mappedBy = "categorias")
    private List<CD> cds;
}
