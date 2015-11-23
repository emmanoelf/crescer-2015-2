INSERT INTO CIDADE (IDCidade, Nome, UF) VALUES (1,'Sao Leopoldo', 'RS');
COMMIT

INSERT INTO SERVICO (IDServico, Descricao) VALUES (SEQ_Servico.nextVal, 'Lavagem de cobertor');
COMMIT

INSERT INTO MATERIAL (IDMaterial, Descricao) VALUES (SEQ_Material.nextVal, 'Sabão em pó');
COMMIT

INSERT INTO CLIENTE (IDCliente, Nome, CPF, Endereco) 
      VALUES (SEQ_Cliente.nextVal, 'EmmanoELF', '123456789', 'Avenida sem nome ggwp' );
INSERT INTO CLIENTE (IDCliente, Nome, CPF, Email, Endereco, Bairro, IDCidade, CEP, Situacao) 
      VALUES (SEQ_Cliente.nextVal, 'EmmanoELF', '789456123','emmanoelvis@', 'Avenida sem nome ggwp', 'celeste', 1, 12345, 'A' );
COMMIT

INSERT INTO PRODUTO(IDProduto, IDServico, IDMaterial, Valor) VALUES (SEQ_Produto.nextVal,1,1, 7.50);
COMMIT

INSERT INTO PEDIDO(IDPEDIDO, IDCLIENTE, DATAINCLUSAO,DATAENTREGA, VALOR, SITUACAO)
      VALUES(SEQ_pedido.nextval, 1, '21/11/15', '22/11/15', 10, 'A');
COMMIT

INSERT INTO PEDIDO(IDPEDIDO, IDCLIENTE, DATAINCLUSAO,DATAENTREGA, VALOR, SITUACAO)
      VALUES(SEQ_pedido.nextval, 1, '29/11/2015', '30/11/2015', 10, 'A');
COMMIT

INSERT INTO ITEM(IDITEM, IDPEDIDO, IDPRODUTO, PESO, VALORUNITARIO, VALORDESCONTO, VALORTOTAL, SITUACAO) 
      VALUES(SEQ_Item.nextVal, 3, 1, 37.9, 11, 10.99, 9.99, 'K');
COMMIT