package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/*
Pausa na metade do video 11
*/
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue // esse campo vai ser gerado pelo banco e sera autoincremento
    @Column(name="idPessoa", nullable=false)
    private Integer idPessoa;
    @Column(name="nome", nullable=false, length = 80)
    private String nome;
    @Column(name="email", nullable=false, length = 80)
    private String email;
    @Column(name="telefone1", nullable=false, length = 14)
    private String telefone1;
    @Column(name="telefone2", nullable=false, length = 14)
    private String telefone2;
    @Column(name="cpf", length = 14)
    private String cpf;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "PessoaSexo")
    private Pessoa pessoa;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
        
}
