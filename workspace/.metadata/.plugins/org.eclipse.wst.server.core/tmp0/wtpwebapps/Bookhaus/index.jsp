<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bookhaus | Home</title>

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
        	<h3 class="heading">New &amp; Popular Items</h3>
    		<div class="row">
            	<div data-category="Books" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/B17.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=1&amp;category=Books">The Alchemist: a graphic novel</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$15.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	<div data-category="Books" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/B06.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=2&amp;category=Books">The C Programming Language</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$50.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	<div data-category="Music" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/M07.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=7&amp;category=Music">The Piano Guys 2</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$12.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	
			
            	<div data-category="Books" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/B12.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=9&amp;category=Books">Harry Potter and the goblet of fire</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$10.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	
            	<div data-category="Music" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/M01.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=1&amp;category=Music">The Piano Guys</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$11.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	<div data-category="Music" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/M03.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=3&amp;category=Music">Nothing but the beat: David Guetta</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$11.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
			
            	<div data-category="Books" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/B21.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=20&amp;category=Books">Theory of Computer Science: Automata, Languages and Computation</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$10.0</span>
	                        </p>
	                    </div>
	                </div>
                </div>
                
                <div data-category="Office Supplies" class="col-lg-3 col-md-4 col-sm-6">
					<div class="product">
	                    <div class="figure">
	                        <img alt="" src="img/S01.png" class="img-responsive">
	                    </div>
	                    <div class="brand-name">
	                        <a href="ProductDetail?id=1&amp;category=Office Supplies">color pen set</a>
	                    </div>
	                    <div class="price">
	                        <p class="amount">Price:
	                            <span>$20.0</span>
	                        </p>
	                    </div>
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
  </body>
</html>