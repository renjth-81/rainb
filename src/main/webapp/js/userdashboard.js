$(document).ready(function() {
	getAllUsers();
});

function getAllUsers() {
	var contextPath = $('#context_path').val();
	$('#get_users').click(function() {
		$.get(contextPath + '/usrall.json').done(function(json) {
			alert(json.users.length);
		}).fail(function() {
			alert('failed');
		});
	});
}