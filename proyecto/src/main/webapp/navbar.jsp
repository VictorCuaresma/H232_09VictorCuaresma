<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JAS DIGITAL MEDIO</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500');

body {
  overflow-x: hidden;
  font-family: 'Varela Round', sans-serif;
  font-size: 16px;
    background: url('https://png.pngtree.com/thumb_back/fw800/background/20230610/pngtree-the-holy-of-guadalupe-is-shown-in-a-dark-room-image_2950194.jpg') center center fixed;
}

/* Toggle Styles */

#viewport {
  padding-left: 250px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#content {
  width: 100%;
  position: relative;
  margin-right: 0;
}

/* Sidebar Styles */

#sidebar {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 250px;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: #FFEB3B; /* Amarillo */
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#sidebar header {
  background-color: #FFEB3B; /* Amarillo */
  font-size: 20px;
  line-height: 52px;
  text-align: center;
}

#sidebar header a {
  color: #fff;
  display: block;
  text-decoration: none;
}

#sidebar header a:hover {
  color: #fff;
}

#sidebar .nav {
  
}

#sidebar .nav a {
  background: none;
  border-bottom: 1px solid #455A64;
  color: #FFF; /* Blanco */
  font-size: 14px;
  padding: 16px 24px;
}

#sidebar .nav a:hover {
  background: none;
  color: #ECEFF1;
}

#sidebar .nav a i {
  margin-right: 16px;
}

</style>	
</head>
<body>
	<nav class="navbar navbar-static-top navbar-inverse bg-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target=".navbarSupportedContent">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><b>Hackathon 2023-2: El despertar de la fuerza!!!</b></a>
			</div>
			<div class="collapse navbar-collapse navbarSupportedContent">
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a class="nav-link" href="home.jsp">PRINCIPAL</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">TABLAS<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="Listar">Bienes</a></li>
						</ul>
					</li>
					<li class="nav-item active">
					<a class="nav-link" href="#">
					<i class="fa fa-user-circle" aria-hidden="true"></i>SALIR<span
							class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
</body>
</html>
