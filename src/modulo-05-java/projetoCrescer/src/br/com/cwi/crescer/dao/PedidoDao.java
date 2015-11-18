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
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }
}
