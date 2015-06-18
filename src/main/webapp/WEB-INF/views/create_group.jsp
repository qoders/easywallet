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

<div class="container" style="margin-top: 100px;">
    <div class="row">
        <div class="col-lg-3 col-sm-4" id="sidebar">
            <h2>Dashboard</h2>
            <ul class="nav">
                <li><a href="#">Add Bill</a></li>
                <li><a href="#">Create Group</a></li>
                <li><a href="#">Settle Up</a></li>
                <li><a href="#">Reminder</a></li>
            </ul>
        </div>
        <div class="col-sm-8 col-lg-9" id="content">

            <div class="row">
                <div class="col-sm-12">
                    <div class="form-wrap" style="margin:20px 0px;">
                        <form:form modelAttribute="newgroup" method="POST">
                            <div class="form-heading">
                                <h2>Create Group</h2>
                            </div>
                            <div class="form-body">
                                <div class="form-group">
                                    <label for="">Group Name</label>
                                    <input type="text" name="title" class="form-control" id="group" placeholder="e.g. MUM Ko Boka Haru">
                                </div>
                                <div class="form-group">
                                    <label for="">Add Members</label>
                                    <input type="text" class="form-control" id="members-search-input" placeholder="Type to search members">
                                    <div class="search-result">
                                    	<ul>
                                    		<!-- <li>
	                                    		<span class="name">Bishwojit Nepali</span>
	                                    		<span class="email">bishwojit.nepali@gmail.com</span>
                                    		</li>
                                    		<li>
	                                    		<span class="name">Manoj Nepali</span>
	                                    		<span class="email">manojgautam@gmail.com</span>
                                    		</li> -->
                                    	</ul>
                                    </div>
                                </div>
                                <div class="user-display-wrap">
                                	<ul id="group-members">
                                		<!-- <li>Bishowjit Nepali
                                			<input type="hidden" name="members[]"/>
                                			<span class="remove">&times;</span>
                                		</li> -->
                                	</ul>
                                </div>
                                
                                <button type="submit" class="btn btn-primary">Save Group</button>
                            </div>
                            <div class="form-footer"></div>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>



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
