package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class CD extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cd")
    public Long codigoCD;

    @ManyToOne
    @JoinColumn(name = "codigo_gravadora")
    public Gravadora gravadora;

    @ManyToOne
    @JoinColumn(name = "Codigo_Banda")
    private Banda banda;

    @Column(name = "nome_cd", length = 255)
    public String nomeCD;

    @Column(name = "preco_venda", precision = 10, scale = 2)
    public BigDecimal precoVenda;

    @Column(name = "data_lancamento")
    public LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "codigo_autor")
    private Autor autor;

}