<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript" src="resources/jquery/jquery.js"></script>

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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function campoVacio() {
		if ($("#nombreGranja").val().length < 1) {
			alert("El granja debe contener al menos 1 caracter");

		} else {

			$('#createFarm').submit();

		}

	}
</script>

</head>
<body>
		<div class="grid">
			<div class="row cells2">
				<div class="cell">
					<form:form method="post" name="farm" id="createFarm"
						action="saveFarm.htm" modelAttribute="farm">
						<div class="input-control text full-size">
							<form:input type="text" path="name" id="nombreGranja" />
							<input type="button" onclick="campoVacio()"
								value="agregar granja" />
						</div>
					</form:form>
					
				</div>
				<div class="cell">
				<button class="button primary"  onclick="location.href='inicio.htm';">Volver</button></div>
			</div>
			
	</div>




</body>
</html>