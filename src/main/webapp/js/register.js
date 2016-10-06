$(document).ready(function() {
	register();
});

function register(){
	var contextPath = $('#context_path').val();
	$('#register_btn').click(function(){
		$.post(
		 	contextPath + '/signup.json',
		 	{
		 		'username' : $('#username').val(),
		 		'password' : $('#password').val()
		 	}
		).done(
		  function(json){
			  if(json.result==true){
				  $('#username').val('');
				  $('#password').val('');
				  alert('Sign up successful. Please login');
			  }else{
				  alert('Username already taken. Please try another one');
			  }
		  }		
		).fail();
	});
}

