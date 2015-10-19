function daisyGame(numeroDePetalas){
   if(numeroDePetalas %2 === 0){
     return "Love me";
   }else{
     return "Love me not";
   }
}

function maiorTexto(array){
  var maior = 0;
  for (var prop in array) {
    if(typeof array[prop] === 'string'){
      if (array[maior].length < array[prop].length){
        maior = prop;
      }
    }
  }
  return array[maior];
}


function imprime(array, func){
	if(typeof func === 'function'){
		for(var prop in array){
			if(typeof array[prop] === 'string'){
				func(array[prop])
			}
		}
	}else{
		return 'Jabulani: TypeError: ' + typeof func + ' is not a function';
	}
}
