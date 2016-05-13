$(document).ready(function(){
	
	$("#confirm-delete-contato").on("show.bs.modal", function(e){
		$(this).find(".modal-body").text($.i18n.prop("mensagem.excluir", $(e.relatedTarget).data("nome")));
		$(this).find("#button-delete-contato").attr("data-id", $(e.relatedTarget).data("id"));
	});
	
	$("#save-contato").on("show.bs.modal", function(e){
		
		if($(e.relatedTarget).data("action") == "adicionar"){
			$(this).find(".modal-title").text($.i18n.prop("titulo.addContato"));
			
		}else if($(e.relatedTarget).data("action") == "editar"){
			$(this).find(".modal-title").text($.i18n.prop("titulo.editarContato"));
		}
	});
	
	$("#button-salvar-contato").on("click", function(e){
		e.preventDefault();
		
		$("#salvar-contato-form").submit();
	});
	
	$("#button-delete-contato").on("click", function(e){
		e.preventDefault();
		
		var id = $(this).attr("data-id");
		var url = "/demo/contato/delete";
		var data = {id : id};
		
		$("#tabela-contatos").load(url, data);
	});
	
	$.i18n.properties({
		name: "messages",
		path: "../",
		mode: "both",
	});
	
});