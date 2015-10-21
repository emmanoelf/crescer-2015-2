String.prototype.palindromo = function(){
  return this.split('').reverse().join('') === this.toString();
}
