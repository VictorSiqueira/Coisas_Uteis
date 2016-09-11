/**
 * metodo para adicionar a partir do evento de clique no botao de add
 */
$('#submitAdd').on('click', function(){
	sendData(mountDataToSend(),"addObj", "POST", onSuccess, onError);
});

/**
 * metodo para atualiar a partir do evento de clique no botao de update
 */
$('#submitUpdate').on('click', function(){
	sendData(mountDataToSend(),"updateObj", "POST", onSuccess, onError);
});

/**
 * metodo para onter todos os registros a partir do evento de clique no botao de get all
 */
$('#submitById').on('click', function(){
	sendData(mountDataToSend(), "getById", "GET", onSuccess, onError );
});

/**
 * metodo para onter todos os registros a partir do evento de clique no botao de get all
 */
$('#submitAll').on('click', function(){
	sendData({}, "getAllObj", "GET", onSuccess, onError );
});

/**
 * metodo para excluir a partir do evento de clique no botao de delete
 */
$('#submitDelete').on('click', function(){
	sendData(mountDataToSend(), "deleteObj", "POST", onSuccess, onError );
});

/**
 * metodo para montar o objeto a ser enviado ao servidor
 * @returns {___anonymous659_711}
 */
function mountDataToSend (){
	var obj = {
			nome : $('#name').val(),
			status: "A"			
	};
	if($('#id').val() != undefined && $('#id').val() != ''){
		obj.id = $('#id').val();
	}
	return obj;
}

/**
 * função generica para respostas de sucesso
 * @param result
 */
function onSuccess(result){
    alert(result);
}

/**
 * função generica para respostas de erro
 * @param result
 */
function onError(result){
    console.log(result);
}

/**
 * metodo que envia ao servidor a chamada ia ajax
 * @param obj
 * @param endpoint
 * @param type
 * @param successCallback
 * @param errorCallback
 */
function sendData(obj, endpoint, type, successCallback, errorCallback){
	$.ajax({
	    type: type,
	    url: "http://localhost:8080/ServerModel/service/obj/"+endpoint,
	    //ta sendo strinfado pois da problema para receber no server 
	    //e dá dor de cabeça, assim é mais simples e acertivo
	    data: JSON.stringify(obj),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(result){
	    	successCallback(result)
	    },	    
	    error: function (result){
	    	errorCallback(result)
	    }
	});
}
