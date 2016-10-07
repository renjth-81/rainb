$(document).ready(function() {
	addProduct();
});

function addProduct(){
	var contextPath = $('#context_path').val();
	$('#add_btn').click(function(){
		var formData = new FormData();
		formData.append('name',$('#prod_name').val());
		formData.append('desc',$('#desc').val());
		formData.append('price',$('#price').val());
		formData.append('stock',$('#stock').val());
		formData.append('name',$('#image')[0].files[0]);
		
		$.ajax({
			  url: contextPath + '/admsaveprod.json',
			  data: formData,
			  processData: false,
			  contentType: false,
			  type: 'POST',
			  success: function(data){
			    alert(data.result);
			  }
			});
		
	});
}

