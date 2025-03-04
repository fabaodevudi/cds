package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "GRAVADORA")
@Data
@EqualsAndHashCode(callSuper = true)
public class Gravadora extends PanacheEntity {

    @Column(name = "nome_gravadora", length = 60)
    private String nomeGravadora;

    @Column(name = "endereco", length = 60)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "contato", length = 20)
    private String contato;

    @Column(name = "url", length = 80)
    private String url;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;
}