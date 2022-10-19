const loginCtrl = (function() {
	var _init,
		_signUp,
		_login;
	
	_init = function() {
		console.log(1);
	};
	
	_moveSignUp = function() {
		location.href = "/user/signUp";
	};
	
	_login = function() {
		$.ajax({
			type : "POST",
			url : "/user/loginProc",
			data : {
				id: $('#id').val(),
				password: $('#password').val() 
			},
			success : function(res){
				location.href = "/main";
				return false;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				alert("통신 실패.");
				return false;
			}
		});
	}
	
	return {
		init			: _init,
		moveSignUp		: _moveSignUp,
		login			: _login
	};
}());
