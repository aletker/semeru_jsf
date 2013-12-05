/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "cidade")
public class TipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // esse campo vai ser gerado pelo banco e sera autoincremento
    @Column(name = "idTipoLogradouro", nullable = false)
    private Integer idTipoLogradouro;
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeEndereco")
    
    private List<Endereco> enderecos;

}
