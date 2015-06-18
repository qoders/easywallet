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
                <div class="col-sm-12">
                    <div class="form-wrap" style="margin:20px 0px;">
                        <form:form modelAttribute="newgroup" method="POST">
                            <div class="form-heading">
                                <h2>List of Groups</h2>
                            </div>
                            
                            <ul>
                            <c:forEach items="${groupList}" var="group">
                            	<li>${group.title}</li>
                            </c:forEach>
                            </ul>
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
