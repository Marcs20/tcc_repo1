package com.teste.app1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_receita")
@NoArgsConstructor
@Getter
@Setter
public class Receita extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    private String nome;

    private String categoria;

    private Float valor;


}
