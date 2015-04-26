<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bookhaus | Search Results</title>

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
        	<h3 class="heading">${param.category} <c:if test="${not empty param.genre}"> | ${param.genre}</c:if>
			</h3>
			<div class="clearfix">
				<form class="sort-form form-horizontal">
					<div class="form-group">
						<label for="sort-sel" class="col-xs-5 control-label">Sort By: </label>
						<div class="col-xs-7">
							<select class="form-control" id="sort-sel">
							  <option value="1" selected>Select Sort Order</option>
							  <option value="2">Price - Ascending</option>
							  <option value="3">Price - Descending</option>
							</select>
						</div>
					</div>
				</form>
			</div>
        	<div id="content">
				<div id="my-tab-content">
					<div id="categoryItems">
						<c:choose>
							<c:when test="${fn:length(navResults) gt 0}">
								<div class="row" id="sort-container">
									<c:forEach var="result" items="${navResults}">
										<div data-category="${result.category}" class="col-lg-3 col-md-4 col-sm-6 sort-element" data-price="${result.price}">
											<div class="product">
												<div class="figure">
													<img alt="" src="img/${result.imagePath}"
														class="img-responsive">
												</div>
												<div class="brand-name">
													<a
														href="ProductDetail?id=${result.id}&category=${result.category}">${result.title}</a>
												</div>
												<div class="price">
													<p class="amount">
														Price: <span>$${result.price}</span>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:when>
							<c:otherwise>
								<h3>There are no items available in this category.</h3>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>
        </section><!-- /page wrapper -->
    </div><!--  wrapper -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/sort.js"></script>
  </body>
</html>