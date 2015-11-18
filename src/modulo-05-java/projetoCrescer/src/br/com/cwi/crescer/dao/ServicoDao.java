package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" insert into servico ");
            stringBuilder.append("(idServico, dsServico) values (?, ?) ");
            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setLong(1, servico.getIdServico());
            statement.setString(2, servico.getDsServico());
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Servico> listAll() throws SQLException {
        List<Servico> list = new ArrayList<Servico>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idServico, dsServico from Servico ");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setIdServivo(resultSet.getLong(1));
                servico.setDsServico(resultSet.getString(2));
                list.add(servico);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

}
