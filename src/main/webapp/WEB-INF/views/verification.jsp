<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                <a class="navbar-brand page-scroll" href="index.html"><span>Easy</span>Wallet</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="/login">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="">Sign Up</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <section id="login-form-wrap">
        <div class="form-wrap">
          
                <h2>Verification</h2>
            <p> We have sent verification code to your email.Please go through your email, Enter your verification code  </p>
           <form:form id="verificationForm" modelAttribute="verificationDetail" name="verificationForm" method="post" action="verifyUser">	
	
            <div class="form-body">
                
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" name="email" class="form-control" id="email" value="${email}">
                    <form:errors path="email" cssStyle="color : red;" /><br/>
                </div>
                 <div class="form-group">
                    <label for="username">Verification Code</label>
                    <input type="text" name="verificationCode" class="form-control" id="verificationCode"  placeholder="verificationCode">
                	<form:errors path="verificationCode" cssStyle="color : red;" /><br/>
                	
                </div>
                
                <button type="submit" class="btn btn-primary">Verify</button>
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
