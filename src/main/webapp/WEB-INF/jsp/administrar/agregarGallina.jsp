<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>




<head>

<script type="text/javascript" src="resources/jquery/jquery.js"></script>

<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/build/css/metro.css">
<script src="resources/Metro-UI-CSS-master/build/js/metro.js"></script>
<link href="resources/Metro-UI-CSS-master/build/css/metro.css"
	rel="stylesheet">
<link href="resources/Metro-UI-CSS-master/build/css/metro-icons.css"
	rel="stylesheet">
<link
	href="resources/Metro-UI-CSS-master/build/css/metro-responsive.css"
	rel="stylesheet">
<link href="resources/Metro-UI-CSS-master/build/css/metro-schemes.css"
	rel="stylesheet">
<script src="resources/Metro-UI-CSS-master/build/js/metro.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Gallinas</title>


<script type="text/javascript">
var farmId = ${chickenDTO.idFarm};


function camposVacios(){
	
	var flag = true;
	
	if($("#nombre").val().length < 1) {
		flag = false;
		
	}
	
	if($("#huevos").val().length < 1) {
		
		falg= false;
		
	}
	
	
	return flag;
	
	
	
	
}

function agregarGallina() {

	
	var nombre = $('#nombre').val();
	var huevos = $('#huevos').val();
	console.log(nombre);
	console.log(huevos);
		
	if(camposVacios()){
	$.ajax({
		type : "POST",
		traditional : true,
		url : "addChicken.htm",
		datatype : "text/jason",
		data : "name=" + nombre + "&eggs=" + huevos	+ "&idFarm=" + farmId,
		success : function(response) {
			
			if(response == "true"){
			$('#nombre').val('');
			$('#huevos').val('0');
			}else{
				
				alert('Ocurrio un error :( ');
				
			}
			
		},
		error : function(response) {
			console.log(response);
		}

	});
	
	}else {
		
		alert('toda gallina debe tener un nombre ');
		
		
		
	}

}



</script>

</head>
<body>
	<div data-text="example" class="example">
		<div class="grid">
			<div class="row cells2">
				<div class="cell">
					<label>Ingrese nombre de la gallina (maximo 11 caracteres)</label>
					<div  class="input-control text full-size">
						<input maxlength="11" id="nombre" type="text">
					</div>
				</div>
				<div class="cell">
					<label>Ingrese Cantidad de huevos</label>
					<div class="input-control text full-size">
						<input id="huevos" value="0" type="text">
					</div>
				</div>
				<button class="button primary" onclick="agregarGallina()">Agregar Otra gallina</button>
				<button class="button primary"  onclick="location.href='inicio.htm';">Volver</button>
			</div>
		</div>
	</div>



</body>
</html>