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
	
	
	