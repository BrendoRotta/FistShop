package com.lojavirtual.rottareal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private float valor;
}
