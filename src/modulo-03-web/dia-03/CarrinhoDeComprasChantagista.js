CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

function CarrinhoDeComprasChantagista(){
  CarrinhoDeCompras.apply(this, arguments);
}

CarrinhoDeCompras.prototype.forcarCompra = function(){
  if(!this.intervalo){
    var self = this;
    this.intervalo = setInterval(function(){
      this.itens.forEach(function(elem){
        elem.valorUnitario += elem.valorUnitario *.1;
      });
    }.bind(this), 5000);
  }
}

CarrinhoDeCompras.prototype.concluirCompra = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
}
