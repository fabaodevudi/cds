package org.cds.entities;// CD.java
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cds.entities.Gravadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CD")
@Data
@EqualsAndHashCode(callSuper = true)
public class CD extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "codigo_gravadora")
    private Gravadora gravadora;

    @Column(name = "nome_cd", length = 60)
    private String nomeCd;

    @Column(name = "preco_venda", precision = 14, scale = 2)
    private BigDecimal precoVenda;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "cd_indicado")
    private CD cdIndicado;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @ManyToMany
    @JoinTable(
            name = "CD_CATEGORIAS",
            joinColumns = @JoinColumn(name = "codigo_cd"),
            inverseJoinColumns = @JoinColumn(name = "codigo_categoria")
    )
    private List<CdCategoria> categorias;
}

