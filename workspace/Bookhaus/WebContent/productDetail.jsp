<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bookhaus | Product Details</title>

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
			<c:choose>
				<c:when test="${not empty product}">
					<button class="btn btn-primary" onclick="window.history.back();"><span style="margin-right: 4px;" class="glyphicon glyphicon-chevron-left"></span>Back</button>
					<h3 class="heading">${product.title}</h3>
					<div class="row product-detail">
						<div class="col-md-4">
							<img alt="${product.title}" src="img/${product.imagePath}"
								class="img-responsive">
						</div>
						<div class="col-md-8">
							<div class="info">
								<c:choose>
									<c:when test="${product.category == 'Books'}">
										<p class="genre"><strong>Genre: </strong> ${product.genre}</p>
										<p><strong>ISBN: </strong> ${product.isbn}</p>
										<p><strong>Author/s: </strong> ${product.author}</p>
										<p><strong>Publisher/s: </strong> ${product.publisher}</p>
										<p><strong>Published Date: </strong> ${product.publishedDate}</p>
										<br>
										<p>${product.description}</p>
										<br>
										<p><strong>Price: </strong>$${product.price}</p>
									</c:when>
									<c:when test="${product.category == 'Music'}">
										<p class="genre"><strong>Genre: </strong> ${product.genre}</p>
										<p><strong>Artist: </strong> ${product.artist}</p>
										<p><strong>Year: </strong> ${product.year}</p>
										<br>
										<p>${product.description}</p>
										<br>
										<p><strong>Price: </strong>$${product.price}</p>									
									</c:when>
									<c:when test="${product.category == 'Accessories'}">
										<br>
										<p>${product.description}</p>
										<br>
										<p><strong>Price: </strong>$${product.price}</p>									
									</c:when>
									<c:when test="${product.category == 'Office Supplies'}">
										<br>
										<p>${product.description}</p>
										<br>
										<p><strong>Price: </strong>$${product.price}</p>										
									</c:when>
								</c:choose>
								<br>
								<br>
								<h4>Store Availability <a href="Contact" class="pull-right"><span class="glyphicon glyphicon-map-marker"></span> Store Locator</a></h4>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>STORE NAME</th>
											<th>QUANTITY</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="store" items="${product.storeAvailability}">
											<tr>
												<td>${store.storeName}, ${store.city}, ${store.state}</td>
												<td>${store.quantity}</td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<h3>There are no items available with Product ID: ${param.id}</h3>
				</c:otherwise>
			</c:choose>


		</section>
		<!-- /page wrapper -->
	</div>
	<!--  wrapper -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.1.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>