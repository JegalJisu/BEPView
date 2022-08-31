const signUpCtrl = (function() {
	var _init;
	
	_init = function() {
		$("input[name=id]").keyup(function(event) {
			if (!(event.keyCode >=37 && event.keyCode<=40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
			}
		});
	};
	
	return {
		init			: _init
	};
}());
