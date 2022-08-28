const loginCtrl = (function() {
	var _init,
		_signUp;
	
	_init = function() {
		console.log(1);
	};
	
	_moveSignUp = function() {
		location.href = "/user/signUpPage";
	};
	
	return {
		init			: _init,
		moveSignUp		: _moveSignUp
	};
}());
