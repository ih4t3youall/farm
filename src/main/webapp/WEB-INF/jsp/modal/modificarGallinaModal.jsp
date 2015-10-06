<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function justNumbers(e)
{
var keynum = window.event ? window.event.keyCode : e.which;
if ((keynum == 8) || (keynum == 46))
return true;
 
return /\d/.test(String.fromCharCode(keynum));
}



</script>
</head>
<body>

	<div class="grid">
			<div class="row cells2">
				<div class="cell">
					<form:form method="post" name="chickenUpdate" id="chicken"
						action="updateChicken.htm" modelAttribute="chickenDTO">
						<div class="input-control text full-size">
							<p>Huevos</p>
							<form:input type="text" onkeypress="return justNumbers(event);" path="eggs"  />
							<p>Nombre</p>
							<form:input  type="text" path="name"  />
							<form:input type="text" path="idFarm" style="display: none;"/>
							<form:input type="text" path="idChicken" style="display: none;" />
							
							<input type="button" onclick="$('#chicken').submit()"value="Modificar Gallina" />
							<input type="button"  onclick="$('#eliminarGallina').submit()" value="Arrivederci Gallina(eliminar)"/>
						</div>
					</form:form>
					
				</div>
					</div>
				<div class="cell">
				
				
<!-- 				<button class="button primary"  onclick="$('#eliminarGallina').submit()">Arrivederci Gallina(eliminar)</button> -->
			
				
			</div>
			
	</div>
	<form:form method="post" name="chickenUpdate" id="eliminarGallina" 
						action="deleteChicken.htm" modelAttribute="chickenDTO" style="display: none;">
						<div class="input-control text full-size">
							<form:input type="text" path="idChicken"  />
						</div>
					</form:form>


</body>
</html>