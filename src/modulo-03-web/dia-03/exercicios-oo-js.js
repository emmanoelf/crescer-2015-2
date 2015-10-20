function Item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
};

function CarrinhoDeCompras(){
  this.itens = [];
};

CarrinhoDeCompras.prototype.adicionarItem = function(item){
    this.itens.push(item);
  }
};

CarrinhoDeCompras.prototype.removerItem = function(skuInformada){
  for(var i = 0, len = this.itens.length; i < len; i++){
    if(this.itens[i].sku === skuInformada){
      this.itens.splice(i, 1);
    }
  }
};
