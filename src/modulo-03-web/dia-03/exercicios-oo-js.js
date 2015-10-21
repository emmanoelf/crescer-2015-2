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
  };

CarrinhoDeCompras.prototype.removerItem = function(skuInformada){
  for(var i = 0, len = this.itens.length; i < len; i++){
    if(this.itens[i].sku === skuInformada){
      this.itens.splice(i, 1);
    }
  }
};

CarrinhoDeCompras.prototype.atualizarQuantidade = function (skuInformada, novaQuantidade){
  return this.itens.map(function(item){
    if(item.sku === skuInformada){
      return item.quantidade = novaQuantidade;
    }
  });
};

Item.prototype.calcularSubTotal = function(){
  return this.quantidade * this.valorUnitario;
}

CarrinhoDeCompras.prototype.sortearDesconto = function(){
  return Math.random() < 0.4;
}

CarrinhoDeCompras.prototype.calcularValorTotal = function(){
  var total = this.itens.map(function(item){
    return item.calcularSubTotal();
  })
  .reduce(function(acumulador, item){
    return acumulador + item;
  });
  return this.sortearDesconto()? (total *= 0.9) : total;
};

CarrinhoDeCompras.prototype.focarCompra = function(){
  var self = this;
  this.intervalo = setInterval(function(){
    this.itens.forEach(function(elem){
      elem.valorUnitario += elem.valorUnitario *1;
    });
  }.bind(this), 5000);
}

CarrinhoDeCompras.prototype.concluirCompra = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
}
