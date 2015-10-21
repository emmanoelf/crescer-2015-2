function Item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
};


Item.prototype.calcularSubTotal = function(){
  return this.quantidade * this.valorUnitario;
}
