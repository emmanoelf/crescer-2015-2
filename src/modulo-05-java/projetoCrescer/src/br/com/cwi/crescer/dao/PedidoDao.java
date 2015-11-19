package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

    public void insert(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("insert into pedido");
            query.append("(idPedido, idCliente, dsPedido) values (pedido_seq.nextVal, ?, ?)");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> listAll() throws SQLException {
        List<Pedido> list = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idPedido, idCliente, dsPedido from pedido");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                list.add(pedido);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    public void update(Pedido pedido) throws SQLException{
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("update pedido set idCliente = ?, dsPedido = ? where idPedido = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.setLong(3, pedido.getIdPedido());
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(Long idPedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("delete from pedido where idPedido = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idPedido);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Pedido load(Long idPedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idpedido, idcliente, dspedido from pedido where idpedido = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idPedido);
            ResultSet resultSet = statement.executeQuery();
            Pedido pedido = new Pedido();
            if (resultSet.next()) {
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
            } else {
                throw new RuntimeException("Nenhum registro foi encontrado.");
            }
            return pedido;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find(Pedido filter) throws SQLException {
        List<Pedido> list = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idPedido, idCliente, dsServico from pedido where 1=1");
            List<Object> parameters = new ArrayList<Object>();
            if (filter.getDsPedido() != null) {
                query.append(" and dspedido = ? ");
                parameters.add(filter.getDsPedido());
            }
            if (filter.getIdCliente() != null) {
                query.append(" and idcliente = ? ");
                parameters.add(filter.getIdCliente());
            }
            if (filter.getIdPedido() != null) {
                query.append(" and idpedido = ? ");
                parameters.add(filter.getIdPedido());
            }
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                list.add(pedido);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    public List<Pedido> listOrdersPerClient(Long idCliente) throws SQLException {
        List<Pedido> list = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idpedido, idcliente, dspedido from pedido where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                list.add(pedido);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }
}