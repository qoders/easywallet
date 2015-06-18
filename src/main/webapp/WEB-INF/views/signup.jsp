<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EasyWallet - Manage all your expenses effortlessly</title>

     <!-- Bootstrap Core CSS -->
    	<link rel="stylesheet" href="<spring:url value="/static/css/bootstrap.min.css"/>" type="text/css">
	  
	    
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
	                <a class="navbar-brand page-scroll" href="/"><span>Easy</span>Wallet</a>
	            </div>
				
				
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                	<security:authorize access="isAnonymous()">
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/login" />">Login</a>
	                    </li>
	                    <li>
	                        <a class="page-scroll" href="<spring:url value="/signup" />">Sign Up</a>
	                    </li>
	                    </security:authorize>
	                    <security:authorize access="isAuthenticated()">
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
	                    </security:authorize>
	                    <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Language <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				            <li><a href="?language=en">English</a></li>
				            <li><a href="?language=vi">Vietnamese</a></li>
				            <li><a href="?language=ne">Nepali</a></li>
				          </ul>
				        </li>
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container-fluid -->
	    </nav>

    <section id="login-form-wrap">
        <div class="form-wrap">
          
                <h2>Sign Up</h2>
            
           <form:form id="signupForm" modelAttribute="userDetail" name="signupForm" method="post" action="addUser">	
	
            <div class="form-body">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First Name">
                    <form:errors path="firstName" cssStyle="color : red;" /><br/>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last Name">
                    <form:errors path="lastName" cssStyle="color : red;" /><br/>
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                    <form:errors path="email" cssStyle="color : red;" /><br/>
                </div>
                 <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="Username">
                	<form:errors path="username" cssStyle="color : red;" /><br/>
                	
                </div>
                <div class="form-group">
                    <label for="">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                	<form:errors path="password" cssStyle="color : red;" /><br/>
                </div>
                <div class="form-group">
                    <label for="firstName">Gender</label><br>
                    <label>
                        <input type="radio" name="gender" value="M" name="gender"> Male
                    </label>
                    <label>
                        <input type="radio" name="gender" value="F" name="gender"> Female
                    </label>
                </div>
                <form:errors path="gender" cssStyle="color : red;" /><br/>
                <button type="submit" class="btn btn-primary">Signup</button>
            </div>
            <div class="form-footer"></div>
            
            </form:form> 
       </div>
    </section>
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
</body>

</html>
