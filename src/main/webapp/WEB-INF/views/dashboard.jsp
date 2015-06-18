<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <title><spring:message code="Pages.Index.Title" text="EasyWallet - Manage all your expenses effortlessly"/></title>

	    <c:if test="${cookie.enableBootstrap.value=='true'}">
    	<!-- Bootstrap Core CSS -->
    	<link rel="stylesheet" href="<spring:url value="/static/css/bootstrap.min.css"/>" type="text/css">
	    </c:if>
	    
	    <!-- Custom Fonts -->
	    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	    <link rel="stylesheet" href="<spring:url value="/static/font-awesome/css/font-awesome.min.css"/>" type="text/css">
	    
	    <!-- Plugin CSS -->
	    <link rel="stylesheet" href="<spring:url value="/static/css/animate.min.css"/>" type="text/css">
	
	    <!-- Custom CSS -->
	    <link rel="stylesheet" href="<spring:url value="/static/css/creative.css"/>" type="text/css">
	
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body id="page-top">
		<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	        <div class="container-fluid">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand page-scroll" href="index.html"><span>Easy</span>Wallet</a>
	            </div>
				
				
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <security:authorize access="isAnonymous()">
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/login" />">Login</a>
	                    </li>
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/signup" />">Sign Up</a>
	                    </li>
	                </ul>
	            </div>
	            </security:authorize>
	            <security:authorize access="isAuthenticated()">
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/dashboard" />">Dashboard</a>
	                    </li>
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="#" />">Welcome: 
	                        <security:authentication property="principal.firstName" /> 
	                        <security:authentication property="principal.lastName" /></a>
	                    </li>
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/logout" />">Logout</a>
	                    </li>
	                </ul>
	            </div>
	            </security:authorize>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container-fluid -->
	    </nav>
	    
	    <div class="container" style="margin-top: 100px;">
		    <div class="row">
		        <div class="col-lg-3 col-sm-4" id="sidebar">
		            <h2>Dashboard</h2>
		            <ul class="nav">
		            <li><a href="/dashboard">Dashboard</a></li>
		                <li><a href="/receipt/add">Add Receipt</a></li>
				        <li><a href="/group/add">Create Group</a></li>
				        <li><a href="/group/">My Groups</a></li>
		                <li><a href="#">Settle Up</a></li>
		                <li><a href="#">Reminder</a></li>
		            </ul>
		        </div>
		        <div class="col-sm-8 col-lg-9" id="content">
		            <div class="row">
		                <div class="col-sm-4">
		                    <span>Your Total Balance</span>
		                    <h3><fmt:formatNumber value="${total}" currencySymbol="$"  type="currency"/></h3>
		                </div>
		                <div class="col-sm-4">
		                    <span>You Owe</span>
		                    <h3><fmt:formatNumber value="${totalOwn}" currencySymbol="$"  type="currency"/></h3>
		                </div>
		                <div class="col-sm-4">
		                    <span>Your are Owed</span>
		                    <h3><fmt:formatNumber value="${totalHave}" currencySymbol="$" type="currency"/></h3>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-sm-12">
		                    <h2>You own</h2>
		                    <div class="expenses-list">
		                    	<c:if test="${empty ownList}">
		                    		Hurray! you own noone!
	                    		</c:if>
		                    	<c:forEach var="comp" items="${ownList}">
		                        <div class="receipt">
		                            <div class="title">${comp.receipt}</div>
		                            <p class="description">${comp.description}</p>
		                            <span class="receipt-date"><fmt:formatDate type="date" value="${comp.receipt.date }" /></span>
		                            <a href="#" class="btn btn-primary">Settle Up</a>
		                        </div>
		                        </c:forEach>
		                    </div>
		                </div>
		                <div class="col-sm-12">
		                    <h2>You have</h2>
		                    <div class="expenses-list">
		                    	<c:if test="${empty haveList}">
		                    		Oh c'mon, let go and buy something.
	                    		</c:if>
		                        <c:forEach var="comp" items="${haveList}">
		                        <div class="receipt">
		                            <div class="title">${comp.receipt}</div>
		                            <p class="description">${comp.description}</p>
		                            <span class="receipt-date"><fmt:formatDate type="date" value="${comp.receipt.date }" /></span>
		                            <a href="#" class="btn btn-primary btn-settle-up" data-companion="${comp.id}" onclick="confirm('Are you sure you want to settle this expense?')">Settle Up</a>
		                        </div>
		                        </c:forEach>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>


	    <footer>
	        <div class="container">
	            <p>Copyright &copy; 2015. All rights reserved at EasyWallet.com</p>
	        </div>
	    </footer>
		
		
		<script src="<spring:url value="/static/js/jquery-1.11.3.min.js"/>"></script>
		<!-- Bootstrap Core JavaScript -->
    	<script src="<spring:url value="/static/js/bootstrap.min.js" />"></script>
		<script src="<spring:url value="/static/js/jquery.cookie.js" />"></script>
		<script src="<spring:url value="/static/js/style-switcher.js" />"></script>
		
		<!-- Plugin JavaScript -->
	    <script src="<spring:url value="/static/js/jquery.easing.min.js" />"></script>
	    <script src="<spring:url value="/static/js/jquery.fittext.js" />"></script>
	    <script src="<spring:url value="/static/js/wow.min.js" />"></script>
		<!-- Custom Theme JavaScript -->
   		<script src="<spring:url value="/static/js/creative.js" />"></script>
   		<script src="<spring:url value="/static/js/scripts.js" />"></script>
	</body>
</html>