package com.empresa.cadastroproposta.models;

import javax.persistence.*;

@Entity
@Table(name = "proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "resulatdo_analise")
    private String resultadoAnalise;

    @Basic
    @Column(name = "aprovada")
    private Boolean aprovada;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_limite", referencedColumnName = "id")
    private LimiteCred limiteCred;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultadoAnalise() {
        return resultadoAnalise;
    }

    public void setResultadoAnalise(String resultadoAnalise) {
        this.resultadoAnalise = resultadoAnalise;
    }


    public Boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(Boolean aprovada) {
        this.aprovada = aprovada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LimiteCred getLimiteCred() {
        return limiteCred;
    }

    public void setLimiteCred(LimiteCred limiteCred) {
        this.limiteCred = limiteCred;
    }
}
