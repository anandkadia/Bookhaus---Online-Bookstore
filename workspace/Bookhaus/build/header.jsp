<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header>
	<!-- Search Bar on top -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Bookhaus" style="margin-left: 50px;"><img
					src="img/logo.png"> </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="dropdown <c:if test="${param.category eq 'Books'}">open</c:if>" id="navBooks">
						<a href="#"	class="dropdown-toggle" data-toggle="dropdown"> BOOKS <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="Navigation?category=Books&genre=architecture" <c:if test="${param.genre eq 'architecture'}">class="active"</c:if>>Architecture</a></li>
							<li><a href="Navigation?category=Books&genre=fantasy" <c:if test="${param.genre eq 'fantasy'}">class="active"</c:if>>Fantasy</a></li>
							<li><a href="Navigation?category=Books&genre=fiction" <c:if test="${param.genre eq 'fiction'}">class="active"</c:if>>Fiction</a></li>
							<li><a href="Navigation?category=Books&genre=science" <c:if test="${param.genre eq 'science'}">class="active"</c:if>>Science</a></li>
							<li><a href="Navigation?category=Books&genre=travel" <c:if test="${param.genre eq 'travel'}">class="active"</c:if>>Travel</a></li>
						</ul></li>
					<li class="dropdown <c:if test="${param.category eq 'Music'}">open</c:if>" id="navMusic">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> MUSIC <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="Navigation?category=Music&genre=country" <c:if test="${param.genre eq 'country'}">class="active"</c:if>>Country</a></li>
							<li><a href="Navigation?category=Music&genre=pop" <c:if test="${param.genre eq 'pop'}">class="active"</c:if>>Pop</a></li>
							<li><a href="Navigation?category=Music&genre=rock" <c:if test="${param.genre eq 'rock'}">class="active"</c:if>>Rock</a></li>
						</ul></li>
					<li><a href="Navigation?category=Office%20Supplies">OFFICE SUPPLIES</a></li>
					<li><a href="Navigation?category=Accessories">ACCESSORIES</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<form class="navbar-form navbar-left" method="GET" action="BasicSearch" id="basic-search-form">
						<div class="search-box">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Search" name="searchTokens" value="${param.searchTokens}"> <span
									class="input-group-btn">
									<button class="btn btn-primary" type="submit">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</span>
							</div>
						</div>
					</form>
					<li style="padding-top: 8px"><a href="InitAdvanceSearch">Advance Search</a></li>
					<li style="padding-top: 8px"><a href="Contact">Contact Us</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
</header>