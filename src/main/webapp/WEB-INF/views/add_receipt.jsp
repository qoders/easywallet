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
                <li><a href="#">Add Bill</a></li>
                <li><a href="#">Create Group</a></li>
                <li><a href="#">Settle Up</a></li>
                <li><a href="#">Reminder</a></li>
            </ul>
        </div>
        <div class="col-sm-8 col-lg-9" id="content">

            <div class="row">
                <div class="col-sm-6">
                    <div class="form-wrap" style="margin:20px 0px;">
                        <form:form modelAttribute="newreceipt" method="POST">
                            <div class="form-heading">
                                <h2>Create Receipt</h2>
                            </div>
                            <div class="form-body">
                                <div class="form-group">
                                    <label for="">Title</label>
                                    <input type="text" class="form-control" name="title" id="title" placeholder="eg. Mashu Bhaat Party">
                                </div>
                                <div class="form-group">
                                    <label for="">Total</label>
                                    <input type="text" class="form-control" name="total" id="total" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="">Description</label>
                                    <textarea type="text" class="form-control" name="description"  id="description"></textarea>
                                </div>
                                <!-- <div class="form-group">
                                    <label for="">Date</label>
                                    <input type="date" class="form-control" name="date" id="date" placeholder="">
                                </div> -->
                                <hr>
                                <h3>Companions</h3>
                                <div class="added-companions">
                                    <!-- <div class="companions">
                                        <div class="name">Users FirstLast Name</div>
                                        <input type="hidden" value="2" name="companions[0]"/>
                                        <span class="close" title="Remove">&times;</span>
                                        <input class='form-control' type="number" name="companions[0].amount" placeholder="Amount Spent"/>
                                        <textarea class="form-control" name="companions[0].description" placeholder="Description of Expense"></textarea>
                                    </div> -->
                                </div>
                                <hr>
                                <button type="button" class="btn btn-success" id="add-companions">Add Companions</button>
                                <button type="submit" class="btn btn-primary">Save Group</button>
                            </div>
                            <div class="form-footer"></div>
                        </form:form>
                    </div>

                </div>
                <div class="col-sm-6">
                    <div class="form-wrap add-companions" style="margin:20px 0px;">
                        <div class="form-heading">
                            <h2>Add Companions to the Receipt</h2>
                        </div>
                        <h3>Groups</h3>
                        <div class="group">
                            <div class="group-title">Boka Group 1</div>
                            <div class="members">
                                <ul>
                                    <li class="member" ><span>Nhu Trin</span> <a href="#" class="btn-add-member" data-member-email = "nhutrin@gmail.com">Add</a></li>
                                </ul>
                            </div>
                            <a href="#" class="btn-add-group" data-group-id="2">Add</a>
                        </div>
                        <div class="group">
                            <div class="group-title">Kabo Group</div>
                            <div class="members">
                                <ul>
                                    <li class="member"><span>Binod Gurung</span> <a href="#" class="btn-add-member" data-member-email = "tamu.bnod1@gmail.com">Add</a></li>
                                </ul>
                            </div>
                            <a href="#" class="btn-add-group" data-group-id="2">Add</a>
                        </div>
                        <h3>Members</h3>
                        <div class="member">
                            <span>Falano Falano Wappe</span> <a href="#" class="btn-add-member" data-member-id = "13">Add</a>
                        </div>
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
