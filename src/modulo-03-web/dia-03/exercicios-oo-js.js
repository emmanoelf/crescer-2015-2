function Item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
}

function CarrinhoDeCompras(item){
  this.item = item;
}

CarrinhoDeCompras.prototype.adicionarItem = function(item){
  
}
