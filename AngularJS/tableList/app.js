angular.module('sortApp', [])

.controller('mainController', function ($scope) {



    /*============== ORDENED ==============*/
    // create the list of sushi rolls 
    $scope.sushi = [
        {
            name: 'Cali Roll',
            fish: 'Crab',
            tastiness: 2
        },
        {
            name: 'Philly',
            fish: 'Tuna',
            tastiness: 4
        },
        {
            name: 'Tiger',
            fish: 'Eel',
            tastiness: 7
        },
        {
            name: 'Rainbow',
            fish: 'Variety',
            tastiness: 6
        }
  ];

    /*============== TARGETED ===============*/
    //container {[relatorio
    $scope.relatorio = [{ //especialidade esta nessa camada
        "especialidade": [ //itemespecialidade
            {
                "descricao": "Tabelionato de Notas",
                "valores": [ //itemreceitas
                    {
                        "data": "25/05/2015",
                        "descricao": "Procurações - Procuração com valor econômico 500,00 0.00 Livro: 3810 - EE Folhas:323 a 324 Nota: 102139 ",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    },
                    {
                        "data": "25/05/2015",
                        "descricao": "Procurações",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    }
                ]
            },
            {
                "descricao": "Registro de Imoveis",
                "valores": [
                    {
                        "data": "25/05/2015",
                        "descricao": "Procurações - Procuração com valor econômico 500,00 0.00 Livro: 3810 - EE Folhas:323 a 324 Nota: 102139 ",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    },
                    {
                        "data": "25/05/2015",
                        "descricao": "Procurações",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    }
                ]
            }
        ],
        'data': '25/05/2015',
        'total': {
            "dayrevenue": "32",
            "dayexpense": "23",
            "accumulatedrevenue": "98",
            "accumulatedexpense": "89",
            "balancerevenue": "65",
            "balanceexpense": "56"
        },
        'despesa': [{
            "idExpense": 20,
            "effectuationDate": "25/05/2015",
            "salaryDate": "28/01/2016 00:00:00",
            "description": "Expediente - Provedor – Internet -",
            "fiscalDocument": {
                "idFiscalDocument": 17,
                "register": "2165415"
            },
            "condition": "P",
            "value": 30,
            "status": "A",
            "account": {
                "idAccount": 8,
                "description": "Provedor – Internet",
                "accountGroup": {
                    "idAccountGroup": 4,
                    "description": "Expediente"
                }
            },
            "user": {
                "idUser": 1
            },
            "supplier": {
                "idSupplier": 21,
                "company": {
                    "idCompany": 23,
                    "fantasyName": "Vivo"
                }
            },
            "recurrences": []
    }, {
            "idExpense": 21,
            "effectuationDate": "25/01/2016 00:00:00",
            "description": "Salários e encargos - 13º Salário  - testeeee",
            "fiscalDocument": {
                "idFiscalDocument": 18,
                "register": "5848894"
            },
            "condition": "N",
            "value": 554.54,
            "status": "A",
            "account": {
                "idAccount": 6,
                "description": "13º Salário ",
                "accountGroup": {
                    "idAccountGroup": 3,
                    "description": "Salários e encargos"
                }
            },
            "user": {
                "idUser": 1
            },
            "supplier": {
                "idSupplier": 22,
                "company": {
                    "idCompany": 24,
                    "fantasyName": "13°"
                }
            },
            "recurrences": []
    }, {
            "idExpense": 24,
            "effectuationDate": "25/05/2015",
            "description": "Expediente - Encadernações - 6544654",
            "fiscalDocument": {
                "idFiscalDocument": 21,
                "register": "45654564654546546465"
            },
            "condition": "N",
            "value": 6545.46,
            "status": "A",
            "account": {
                "idAccount": 7,
                "description": "Encadernações",
                "accountGroup": {
                    "idAccountGroup": 4,
                    "description": "Expediente"
                }
            },
            "user": {
                "idUser": 1
            },
            "supplier": {
                "idSupplier": 25,
                "company": {
                    "idCompany": 27,
                    "fantasyName": "TESTE FORNECEDOR - TESTE FORNECEDOR - TESTE FORNECEDOR - TESTE - TESTE - TESTE - TESTE -TESTE - TESTE"
                }
            },
            "recurrences": []
    }, {
            "idExpense": 25,
            "effectuationDate": "16/01/2016 00:00:00",
            "salaryDate": "28/01/2016 00:00:00",
            "description": "Expediente - Encadernações - 87979",
            "fiscalDocument": {
                "idFiscalDocument": 22,
                "register": "68697987987"
            },
            "condition": "P",
            "value": 300.04,
            "status": "A",
            "account": {
                "idAccount": 7,
                "description": "Encadernações",
                "accountGroup": {
                    "idAccountGroup": 4,
                    "description": "Expediente"
                }
            },
            "user": {
                "idUser": 1
            },
            "supplier": {
                "idSupplier": 26,
                "company": {
                    "idCompany": 28,
                    "fantasyName": "A B C D E F G H I J K L M N O P Q R S T U V X Y Z A B C D E F G H I J K L M N O P Q R S T U V X Y Z A B C D E F G H I J K L M N O P Q R S T U V X Y Z"
                }
            },
            "recurrences": []
    }]
    }, {
        "especialidade": [
            {
                "descricao": "Tabelionato de Notas",
                "valores": [
                    {
                        "data": "26/05/2015",
                        "descricao": "Procurações - Procuração com valor econômico 500,00 0.00 Livro: 3810 - EE Folhas:323 a 324 Nota: 102139 ",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    },
                    {
                        "data": "26/05/2015",
                        "descricao": "Procurações",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    }
                ]
            },
            {
                "descricao": "Registro de Imoveis",
                "valores": [
                    {
                        "data": "26/05/2015",
                        "descricao": "Procurações - Procuração com valor econômico 500,00 0.00 Livro: 3810 - EE Folhas:323 a 324 Nota: 102139 ",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    },
                    {
                        "data": "26/05/2015",
                        "descricao": "Procurações",
                        "receita": "R$ 25",
                        "despesa": "R$ 25"
                    }
                ]
            }
        ],
        'data': '26/05/2015'
    }];


    $scope.transport = {
        "send": {
            "revenue": "73",
            "expense": "37"
        },
        "receive": {
            "revenue": "46",
            "expense": "64"

        }
    };


    $scope.balance = {
        mes:[{
            descricao: 'janeiro',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        },{
            descricao: 'fevereiro',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        },{
            descricao: 'março',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        },{
            descricao: 'abril',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        },{
            descricao: 'maio',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        },{
            descricao: 'junho',
            despesa: 12000.00,
            receita: 7000.00,
            liquido: 7000.00
        }],
        especialidade:[{
                descricao:'Tabelionato de Nota',
                valor: 5000000.00
            },
            {
                descricao:'Registro Civil',
                valor: 5000000.00
            }
        ],
        receita: 500.50,
        despesa:789,
        liquido: 565565
    };

});