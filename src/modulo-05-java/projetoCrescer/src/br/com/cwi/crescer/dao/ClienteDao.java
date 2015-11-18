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
            stringBuilder.append("insert into lavanderia.cliente");
            stringBuilder.append("(idCliente, nmCliente, nrCpf) values(cliente_seq.nextVal,?,?)");
            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
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
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public void delete(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from cliente where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente load(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idcliente, nmcliente, nrcpf ");
            sql.append("from cliente where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente = new Cliente();
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }
            return cliente;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int update(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nmcliente = ?, nrcpf = ? where idcliente = ? ");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> find(Cliente filter) throws SQLException {
        List<Cliente> list = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idCliente, nmCliente, nrCpf from Cliente where 1=1 ");
            List<Object> parameters = new ArrayList<Object>();
            if (filter.getNmCliente() != null) {
                query.append(" and nmCliente = ? ");
                parameters.add(filter.getNmCliente());
            }
            if (filter.getNrCpf() != null) {
                query.append(" and nrCpf = ? ");
                parameters.add(filter.getNrCpf());
            }
            if (filter.getIdCliente() != null) {
                query.append(" and idcliente = ? ");
                parameters.add(filter.getIdCliente());
            }
            PreparedStatement statement = conexao.prepareStatement(query.toString());

            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
                list.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

}
