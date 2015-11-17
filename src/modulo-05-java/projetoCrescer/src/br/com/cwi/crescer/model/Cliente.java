package br.com.cwi.crescer.model;


public class Cliente {

    private Long idCliente;
    private String nmCliente;
    private String nrCpf;

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return this.nmCliente;
    }

    public String getCPF() {
        return this.nrCpf;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nmCliente = nomeCliente;
    }

    public void setCPF(String cpf) {
        this.nrCpf = cpf;
    }

}
