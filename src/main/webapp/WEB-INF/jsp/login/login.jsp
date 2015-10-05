<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</head>
<body class="metro">

			<form class="metro" name='f'
						action="<c:url value='j_spring_security_check' />" method='POST'>

						<p>usuario</p>
						<div data-role="input-control" class="input-control text">
							<input style="width: 200px" class="form-control input-sm texto"
								type='text' placeholder="type text" name='j_username' value=''>
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<p>contrase&ntilde;a</p>
						<div data-role="input-control" class="input-control password">
							<input autofocus="" placeholder="type password"
								style="width: 200px" class="form-control input-sm texto"
								type='password' name='j_password' />
							<button tabindex="-1" class="btn-reveal" type="button"></button>
						</div>



				</div>
				</form>

</body>
</html>