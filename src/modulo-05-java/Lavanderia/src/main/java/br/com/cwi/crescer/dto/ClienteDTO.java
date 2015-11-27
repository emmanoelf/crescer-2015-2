package br.com.cwi.crescer.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ClienteDTO {

    private Long id;

    @NotBlank
    @Length(max = 70)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Email
    @Length(max = 100)
    private String email;

    @Length(max = 50)
    private String endereco;

    @Length(max = 50)
    private String bairro;

    private Long idCidade;

    private Long cep;

    private SituacaoCliente situacaoCliente;

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

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public SituacaoCliente getSituacaoCliente() {
        return situacaoCliente;
    }

    public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
        this.situacaoCliente = situacaoCliente;
    }

}
