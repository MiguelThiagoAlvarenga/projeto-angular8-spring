package com.empresa.cadastroproposta.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nome")
    private String nome;

    @Basic
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Basic
    @Column(name = "idade")
    private Integer idade;

    @Basic
    @Column(name = "sexo")
    private String sexo;

    @OneToOne
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id")
    private EstadoCivil estadoCivil;

    @Basic
    @Column(name = "estado")
    private String estado;

    @Basic
    @Column(name = "dependentes")
    private Integer dependentes;

    @Basic
    @Column(name = "renda")
    private Double renda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }
}
