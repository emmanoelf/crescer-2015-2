package br.com.cwi.crescer.model;


public class Cliente {

    private Long idCliente;
    private String nmCliente;
    private String nrCpf;

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNmCliente() {
        return this.nmCliente;
    }

    public String getNrCpf() {
        return this.nrCpf;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNmCliente(String nomeCliente) {
        this.nmCliente = nomeCliente;
    }

    public void setNrCpf(String cpf) {
        this.nrCpf = cpf;
    }

}
