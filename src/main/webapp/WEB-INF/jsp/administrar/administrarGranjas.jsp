<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>Administrar granjas</title>

<script type="text/javascript">
	function administrarGranja(name){
		$('#nombreGranja').val(name);
		$('#showFarm').submit();
		
		
	}
</script>

</head>
<body>

<c:forEach items="${farms}" var="farm">

   

<div onclick="administrarGranja('${farm.name}')" class="tile-container bg-darkCobalt">

            <div class="tile-wide fg-white" data-role="tile">
                <div class="tile-content slide-down-2">
                    <div class="slide">
                        
                    <div style="width: 100%; height: 100%;" class="image-container image-format-fill"><div class="frame"><div style="width: 100%; height: 100%; background-image: url(&quot;resources/images/farm/farm.jpg&quot;); background-size: cover; background-repeat: no-repeat; border-radius: 0px;"></div></div></div></div>
                    <div class="slide-over bg-green text-small padding10">

<c:choose>
  <c:when test="${farm.chickenCount == 0}">
  <p>No hay gallinas en esta granja</p>
   </c:when>
   <c:otherwise>
   <p> En esta granja hay ${farm.chickenCount} gallinas.</p>
   
   
    </c:otherwise>
    </c:choose>
                    </div>
                    <div class="tile-label">${farm.name}</div>
                </div>
            </div>

        </div>

</c:forEach>
<button class="button primary"  onclick="location.href='inicio.htm';">Volver</button>
<form:form style="display: none;" method="post" name="farm" id="showFarm"
				action="verGranja.htm" modelAttribute="formFarm">
				 <form:input type="text" path="name" id="nombreGranja" />
				 <form:input type="text" path="idFarm" id="farmId" />
				  <input type="button" value="ver granja"/>
				 
					</form:form>

</body>
</html>