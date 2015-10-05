	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


<script type="text/javascript" src="resources/modal/js/jquery.js"></script>
<script type="text/javascript"
	src="resources/modal/js/jquery.simplemodal.js"></script>
<script type="text/javascript" src="resources/modal/js/basic.js"></script>

<link type="text/css" href="resources/modal/css/demo.css"
	rel="stylesheet" media="screen" />

<!-- Contact Form CSS files -->
<link type="text/css" href="resources/modal/css/basic.css"
	rel="stylesheet" media="screen" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver granja</title>

<script type="text/javascript">
	var idGranja = ${farm.idFarm};
	$( document ).ready(function() {
	
		var suma = 0;
		$( ".huevos" ).each(function( index,item ) {
		  suma = suma +parseInt($(item).html());
		  
		});
		
		
		$('#huevosTotales').html("Esta granja tiene un total de "+suma+" huevos")
		
		
		
	});
	
	
	
	
	
	function agregarGallina() {

		$('#idGranja').val(idGranja);
		$('#addChicken').submit();

	}

	function eliminarGranja() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "eliminarGranja.htm",
			datatype : "text/jason",
			data : "idFarm=" + idGranja,
			success : function(response) {

				if (response == "true") {

					location.href = 'eliminarGranjaExito.htm';
				} else {

					location.href = 'eliminarGranjaError.htm';

				}

			},
			error : function(response) {
				console.log(response);
			}

		});

	}

	function modificarGallina(eggs, name, idFarm, idChicken) {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "modificarGallinaForm.htm",
			datatype : "text/jason",
			data : "name=" + name + "&eggs=" + eggs + "&idFarm=" + idFarm
					+ "&idChicken=" + idChicken,
			success : function(response) {
				$.modal(response);

			},
			error : function(response) {
				console.log(response);
			}

		});

	}
</script>

</head>
<body>

	<h1>Granja: ${farm.name}</h1>


	<c:if test="${fn:length(farm.chickens) ne 0}">


		<c:forEach items="${farm.chickens}" var="chicken">
			<div class="tile-container bg-darkCobalt"
				onclick="modificarGallina('${chicken.eggs}','${chicken.name}','${chicken.idFarm}','${chicken.idChicken}')">
				<div data-role="tile" class="tile-wide fg-white">
					<div class="tile-content slide-down">
						<div class="slide">

							<div class="image-container image-format-hd" style="width: 100%;">
								<div class="frame">
									<div
										style="width: 100%; height: 174.375px; background-image: url(&quot;resources/images/farm/chciken.jpg&quot;); background-size: cover; background-repeat: no-repeat; border-radius: 0px;"></div>
								</div>
							</div>
						</div>
						<div class="slide-over op-green text-small padding10">
							<c:choose>
								<c:when test="${chicken.eggs > 0}">

									<p>Esta gallina tiene<span class="huevos"> ${chicken.eggs}</span> huevos</p>
								</c:when>

								<c:otherwise>
									<p>Esta gallina no tiene huevos!</p>

								</c:otherwise>
							</c:choose>

						</div>
						<div class="tile-label" style="color: black">${chicken.name}</div>
					</div>
				</div>





			</div>
		</c:forEach>
	</c:if>
	<div class="tile-container bg-darkCobalt">

		<div onclick="eliminarGranja()" data-role="tile"
			class="tile bg-red fg-white">
			<div class="tile-content iconic">
				<span class="icon mif-minus"></span> <span class="tile-label">Eliminar
					granja</span>
			</div>
		</div>
		
		<p style="color:white" id="huevosTotales"></p>

	</div>
	<button class="button primary" onclick="agregarGallina()">Agregar
		gallina</button>




	<form:form style="display: none;" method="post" name="farm"
		id="addChicken" action="agregarGallina.htm" modelAttribute="farm">
		<form:input type="text" path="name" id="name" />
		<form:input type="text" path="idFarm" id="idGranja" />
		<input type="button" value="ver granja" />

	</form:form>


	<form:form style="display: none;" method="post" name="chickenDTO"
		id="modificarGallina" action="modificarGallina.htm"
		modelAttribute="chickenDTO">
		<form:input type="text" path="name" id="nombreGallina" />
		<form:input type="text" path="idFarm" id="idGranjaGallina" />
		<form:input type="text" path="idChicken" id="idChickenGallina" />
		<form:input type="text" path="eggs" id="eggsGallina" />

	</form:form>

	<button class="button primary"
		onclick="location.href='administrarGranjas.htm';">Volver</button>


</body>
</html>