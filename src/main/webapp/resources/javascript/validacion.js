function passwdIguales(clave1,clave2){
	    //tofix comprobar que no sean vacios

	    if (clave1 == clave2)
	       return true;
	    else
	       return false;
	} 

	function campoVacio(campo) {
		console.log(campo.length);
		if ($(campo).length > 0) {
			
			return true;

		} else {

			return false;

		}

	}
	
	function justNumbers(e)
	{
	var keynum = window.event ? window.event.keyCode : e.which;
	if ((keynum == 8) || (keynum == 46))
	return true;
	 
	return /\d/.test(String.fromCharCode(keynum));
	}
	