<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bookhaus | Contact</title>

    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/custom.css" rel="stylesheet">
	<link href="css/simple-sidebar.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<div id="wrapper">
  		<jsp:include page="header.jsp"></jsp:include>
        <section id="page-wrapper">
        	<h3 class="heading">Contact and Store Information</h3>
			<div class="row">
				<div class="col-md-7">
					<c:forEach var="store" items="${storeList}">
						<div class="store-info">
							<h3>${store.storeName}</h3>
							<div class="row">
								<div class="col-xs-6">
									<p>${store.address}</p>
									<p>${store.city}, ${store.zip} ${store.state}</p>
									<p>
										<span class="glyphicon glyphicon-earphone"></span>${store.phone}</p>
									<p>
										<span class="glyphicon glyphicon-envelope"></span>${store.email}</p>
								</div>
								<div class="col-xs-6">
									<p>${store.hours}</p>
								 	<a href="#" class="locate-link" data-title="${store.storeName}" data-latitude="${store.latitude}" data-longitude="${store.longitude}">Locate on Map</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="col-md-5">
					<h4 id="store-showing"></h4>
					<div id="map-canvas"></div>
				</div>
			</div>
        </section><!-- /page wrapper -->
    </div><!--  wrapper -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>    
	<script src="js/script.js"></script>
    <script src="js/contact.js"></script>
  </body>
</html>