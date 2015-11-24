package br.com.cwi.crescer.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE_NAME, sequenceName = Cliente.SEQUENCE_NAME, allocationSize = 1)
public class Cliente {

    public static final String SEQUENCE_NAME = "SEQ_Cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "IDCliente")
    private Long idCliente;

    @Column(name = "Nome", length = 70)
    @Basic(optional = false)
    private String nome;

    @Column(name = "CPF", length = 11)
    @Basic(optional = false)
    private String cpf;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Endereco", length = 50)
    private String endereco;

    @Column(name = "Bairro", length = 50)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "IDCidade")
    private Cidade cidade;

    @Column(name = "CEP", length = 8)
    private int cep;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao", length = 1)
    private SituacaoCliente situacao;

    public Long getIdCliente() {
        return idCliente;
    }

    public static enum SituacaoCliente {
        ATIVO, INATIVO;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getIdCidade() {
        return cidade;
    }

    public void setIdCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
