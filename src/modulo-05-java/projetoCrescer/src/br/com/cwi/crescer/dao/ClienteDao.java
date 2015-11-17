package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection();) {
            /*
             * PreparedStatement statement = conexao.prepareStatement(" insert into cliente (idCliente, nmCliente, nrCpf) values (?, ?, ?)");
             * Statement stmp = conexao.createStatement();
             * stmp.execute(" insert into Cliente (idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ", '" + cliente.getNomeCliente() + "', '" +
             * cliente
             * .getCPF() + "') ");
             */
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" insert into cliente ");
            stringBuilder.append("(idCliente, nmCliente, nrCpf) values(?, ?, ?)");
            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setLong(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNomeCliente());
            statement.setString(3, cliente.getCPF());
            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Cliente> listAll() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idCliente, nmCliente, nrCpf from Cliente");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNomeCliente(resultSet.getString(2));
                cliente.setCPF(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
