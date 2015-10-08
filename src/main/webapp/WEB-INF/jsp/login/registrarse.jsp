<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/jquery/jquery.js"></script>

<!-- <link rel="stylesheet" -->
<!-- 	href="resources/Metro-UI-CSS-master/build/css/metro.css"> -->
<!-- <script src="resources/Metro-UI-CSS-master/build/js/metro.js"></script> -->
<!-- <link href="resources/Metro-UI-CSS-master/build/css/metro.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <link href="resources/Metro-UI-CSS-master/build/css/metro-icons.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <link -->
<!-- 	href="resources/Metro-UI-CSS-master/build/css/metro-responsive.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <link href="resources/Metro-UI-CSS-master/build/css/metro-schemes.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <script src="resources/Metro-UI-CSS-master/build/js/metro.js"></script> -->


<!-- head de prueba -->
<head lang="en">


<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/build/css/metro.css">
<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/build/css/metro-icons.css">
<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/build/css/metro-responsive.css">
<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/build/css/metro-schemes.css">


<script src="resources/Metro-UI-CSS-master/build/js/metro.js"></script>
<script src="resources/javascript/validacion.js"></script>

</head>

<!-- fin head de prueba -->

<script type="text/javascript">
	function validar() {

		var nombreUsuario =$('#nombreUsuario').val();
				
		var flag = campoVacio(nombreUsuario)
		
		var cont = 0;
		console.log(flag);
		if(!flag){
			
			cont ++;
		}else{
			alert('El campo nombre de usuario es requerido.')
			
		}
		
		var flag2 = passwdIguales($('#passwd1').val(),$('#passwd2').val());
		if (flag2){
			
			
			cont ++;
		}else {
			
			alert('las contraseñas no coinciden');
			
		}
		
		if($('#passwd1').val().length > 0 && $('#passwd2').val().length > 0){
			
			cont++;
		}else {
			
			alert('Las passwords deben tener ambas al menos 1 caracter.')
			
		}
		
		if(cont == 3){
			
			$('#agregarUsuario').submit();
			
		}
		
		

	}
	
</script>
</head>




<body class="metro">




	<div class="grid">
		<div class="row">
			<div class="span6 offset4">
				<div class="example">
					<form:form method="post" name="usuarioDTO" id="agregarUsuario"
						action="agregarUsuario.htm" modelAttribute="usuarioDTO">
						<fieldset>
							<div class="input-control modern text">
								<form:input id="nombreUsuario" type="text" path="nombreUsuario" />
								<span class="label">Ingrese nombre de usuario</span> <span
									class="informer"></span> <span class="placeholder">Nombre
									de usuario</span>
							</div>
							<br />
							<div class="input-control modern text">
								<form:input id="passwd1" type="password" path="passwd"/> <span class="label">Ingrese
									su passwd.</span> <span class="informer"></span> <span
									class="placeholder">Password</span>
							</div>
							<br />
							<div class="input-control modern text">
								<input id="passwd2" type="password"> <span class="label">Repita
									su passwd</span> <span class="informer"></span> <span
									class="placeholder">password</span>
							</div>
					</form:form>
					</fieldset>
					</form>
				</div>
							<br /> <button onclick="validar()"	class="button success block-shadow-success text-shadow">Registrarse</button>


			</div>


		</div>
	</div>
	</div>

</body>
</html>