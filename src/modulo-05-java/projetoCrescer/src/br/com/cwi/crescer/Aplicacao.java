package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Pedido;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {

        // Cliente cliente = new Cliente();
        // cliente.setIdCliente(1L);
        // cliente.setNmCliente("Jão2");
        // cliente.setNrCpf("123456789");
        // ClienteDao clienteDao = new ClienteDao();
        // clienteDao.insert(cliente);

        /*
         * ClienteDao clienteDao = new ClienteDao();
         * List<Cliente> lista = clienteDao.listAll();
         * for (Cliente cliente : lista) {
         * System.out.println(cliente.getNmCliente());
         * }
         */
        /*
         * Servico servico = new Servico();
         * servico.setIdServivo(1L);
         * servico.setDsServico("Limpeza");
         * ServicoDao servicoDao = new ServicoDao();
         * servicoDao.insert(servico);
         */
        /*
         * ServicoDao servicoDao = new ServicoDao();
         * List<Servico> list = servicoDao.listAll();
         * for (Servico servico : list) {
         * System.out.println(servico.getIdServico() + " " + servico.getDsServico());
         * }
         */

        // ClienteDao clienteDao = new ClienteDao();
        // clienteDao.load(1L);
        /*
         * Scanner scanner = new Scanner(System.in);
         * System.out.println("Escolha:");
         * System.out.println("1 - Lista encadeada\n2 - Lista duplamente encadeada");
         * ILinkedList list;
         * int opcao = scanner.nextInt();
         * if (opcao == 1) {
         * list = new LinkedList();
         * } else {
         * list = new DoublyLinkedList();
         * }
         * int opcaoMenu = 9;
         * while (opcaoMenu != 0) {
         * System.out.println("Escolha:");
         * System.out.println("1 - Inserir");
         * System.out.println("2 - Remover");
         * System.out.println("3 - Listar");
         * System.out.println("4 - Imprimir");
         * System.out.println("5 - Sair");
         * opcaoMenu = scanner.nextInt();
         * }
         */
        /*
         * ClienteDao clienteDao = new ClienteDao();
         * clienteDao.delete(1L);
         */

        // Pedido pedido = new Pedido();
        // pedido.setIdCliente(2L);
        // pedido.setDsPedido("Ghost Blade");
        //
        // PedidoDao pedidoDao = new PedidoDao();
        // pedidoDao.insert(pedido);

        // Cliente cliente = new Cliente();
        // cliente.setNmCliente("Zedão");
        // cliente.setNrCpf("3327184");
        // ClienteDao clienteDao = new ClienteDao();
        // clienteDao.insert(cliente);

        // PedidoDao pedidoDao = new PedidoDao();
        // List<Pedido> list = pedidoDao.listOrdersPerClient(2L);
        // for (Pedido pedido : list) {
        // System.out.println(pedido.getIdPedido() + " " + pedido.getIdCliente() + " " + pedido.getDsPedido());
        // }

        // Pedido pedido = new Pedido();
        // pedido.setIdCliente(3L);
        // pedido.setDsPedido("Ghost Blade");
        // PedidoDao pedidoDao = new PedidoDao();
        // pedidoDao.insert(pedido);

        PedidoDao pedidoDao = new PedidoDao();
        List<Pedido> list = pedidoDao.listOrdersPerClient(3L);
        for (Pedido pedido : list) {
            System.out.println(pedido.getIdPedido());
        }

        // pedidoDao.delete(1L);

        // Pedido pedido = new Pedido();
        // pedido.setIdPedido(2L);
        // pedido.setIdCliente(1L);
        // pedido.setDsPedido("Void Staff");
        // pedidoDao.update(pedido);

        // pedidoDao.load(2L);
    }
}