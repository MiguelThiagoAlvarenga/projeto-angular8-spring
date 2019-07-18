package com.empresa.cadastroproposta.models;

import javax.persistence.*;

@Entity
@Table(name = "estado_civil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "descricao")
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
