var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

//função auxiliar para questões 1.x
function ordenarPorTitulo(indice, array){
  return array.sort(function(elem1, elem2){
    return elem1.titulos[indice].qtd < elem2.titulos[indice].qtd;
    })
}

function ordenarPorNacionais(array){
  return ordenaPorTitulo(0, array);
};

function ordenarPorContinentais(array){
  return ordenaPorTitulo(1, array);
};

function ordenarPorMundiais(array){
  return ordenaPorTitulo(2, array);
};

function somarPorNacionais(array){
  var soma = 0;
  for(var i = 0, len = array.length; i < len; i++){
    soma += soma + array[i].titulos[0].qtd;
  }
  return soma;
};

function somarPorContinentais(array){
  var soma = 0;
  for(var i = 0, len = array.length; i < len; i++){
    soma += array[i].titulos[1].qtd;
  }
  return soma;
}

//função para auxiliar para o metodo somarPorTodosTítulos
function somarPorMundiais(array){
  var soma = 0;
  for(var i = 0, len = array.length; i < len; i++){
    soma += array[i].titulos[2].qtd;
  }
  return soma;
}

function somarPorTodosTitulos(array){
  return somarPorNacionais(array) + somarPorContinentais(array) + somarPorMundiais(array);
}

function apenasOsMelhores(array){
  return array.filter(function(mais18){
    return mais18.titulos[0].qtd > 18;
  });
};
