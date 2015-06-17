<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
	                        <a class="page-scroll" href="<spring:url value="/login" />">Sign Up</a>
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
	                        <a class="page-scroll" href="<spring:url value="/doLogout" />">Logout</a>
	                    </li>
	                </ul>
	            </div>
	            </security:authorize>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container-fluid -->
	    </nav>
	    
	    <header>
	        <div class="header-content">
	            <div class="header-content-inner">
	                <h1>Manage all your expenses effortlessly with EasyWallet</h1>
	                <hr>
	                <!--<p>EasyWallet will act as your personal wallet and will help in managing the group expenses and settlements effortlessly. Sign Up now to get your wallet and split expenses in group easily.</p>-->
	                <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a>
	            </div>
	        </div>
	    </header>
	
	    <section class="bg-primary" id="about">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-8 col-lg-offset-2 text-center">
	                    <h2 class="section-heading">We've got what you need!</h2>
	                    <hr class="light">
	                    <p class="text-faded">EasyWallet will act as your personal wallet and will help in managing the group expenses and settlements effortlessly. Sign Up now to get your wallet and split expenses in group easily.</p>
	                    <a href="login.html" class="btn btn-default btn-xl">Get Started!</a>
	                </div>
	            </div>
	        </div>
	    </section>
	
	    <section id="services">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12 text-center">
	                    <h2 class="section-heading">How does it work?</h2>
	                    <hr class="primary">
	                </div>
	            </div>
	        </div>
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>
	                        <h3>Create Wallet</h3>
	                        <p class="text-muted">By siging up with us, you can create your wallet.</p>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-paper-plane wow bounceIn text-primary" data-wow-delay=".1s"></i>
	                        <h3>Add Receipt</h3>
	                        <p class="text-muted">Add the bill of expenses that you did on behalf of your group.</p>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>
	                        <h3>Add Companions</h3>
	                        <p class="text-muted">After creating the bill, you can add companions involved in that expenses.</p>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-heart wow bounceIn text-primary" data-wow-delay=".3s"></i>
	                        <h3>Settle Up</h3>
	                        <p class="text-muted">You can settle up the individual receipts or all receipts at once.</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
	
	
	
	    <aside class="bg-dark">
	        <div class="container text-center">
	            <div class="call-to-action">
	                <h2>Ready for the effortless experience?</h2>
	                <a href="signup.html" class="btn btn-default btn-xl wow tada">Sign Up Now!</a>
	            </div>
	        </div>
	    </aside>
	
	    <section class="no-padding" id="team-members">
	        <div class="container">
	            <div class="row no-gutter">
	                <div class="col-lg-12 text-center">
	                    <h2 class="section-heading">Our Team Members!</h2>
	                    <hr class="primary">
	                    <p>Four Qoders didn't talk much, they coded it.</p>
	                </div>
	                <div class="col-sm-6">
	                    <a href="#" class="portfolio-box">
	                        <img src="<spring:url value="/static/img/members/2.jpg" />" class="img-responsive" alt="">
	                        <div class="portfolio-box-caption">
	                            <div class="portfolio-box-caption-content">
	                                <div class="project-category text-faded">
	                                    Trinh Hoang Nhu
	                                </div>
	                                <div class="project-name">
	                                    Team Lead & Backend Developer
	                                </div>
	                            </div>
	                        </div>
	                    </a>
	                </div>
	                <div class="col-sm-6">
	                    <a href="#" class="portfolio-box">
	                        <img src="<spring:url value="/static/img/members/1.jpg" />" class="img-responsive" alt="">
	                        <div class="portfolio-box-caption">
	                            <div class="portfolio-box-caption-content">
	                                <div class="project-category text-faded">
	                                    Bishwajit Nepali
	                                </div>
	                                <div class="project-name">
	                                    Lead Analyst & Backend Developer
	                                </div>
	                            </div>
	                        </div>
	                    </a>
	                </div>
	
	                <div class="col-sm-6">
	                    <a href="#" class="portfolio-box">
	                        <img src="<spring:url value="/static/img/members/3.jpg" />" class="img-responsive" alt="">
	                        <div class="portfolio-box-caption">
	                            <div class="portfolio-box-caption-content">
	                                <div class="project-category text-faded">
	                                    Manoj Gautam
	                                </div>
	                                <div class="project-name">
	                                    Lead Analyst and Backend Developer
	                                </div>
	                            </div>
	                        </div>
	                    </a>
	                </div>
	                <div class="col-sm-6">
	                    <a href="#" class="portfolio-box">
	                        <img src="<spring:url value="/static/img/members/4.jpg" />" class="img-responsive" alt="">
	                        <div class="portfolio-box-caption">
	                            <div class="portfolio-box-caption-content">
	                                <div class="project-category text-faded">
	                                    Binod Gurung
	                                </div>
	                                <div class="project-name">
	                                    Front End Engineer & Web Developer
	                                </div>
	                            </div>
	                        </div>
	                    </a>
	                </div>
	            </div>
	        </div>
	    </section>
	
	    <section id="contact">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-8 col-lg-offset-2 text-center">
	                    <h2 class="section-heading">Let's Get In Touch!</h2>
	                    <hr class="primary">
	                    <p>If you have any suggestions or queries regarding our application please contact us via phone or email us. Feedback matters.</p>
	                </div>
	                <div class="col-lg-4 col-lg-offset-2 text-center">
	                    <i class="fa fa-phone fa-3x wow bounceIn"></i>
	                    <p>641-444-4444</p>
	                </div>
	                <div class="col-lg-4 text-center">
	                    <i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
	                    <p><a href="mailto:your-email@your-domain.com">feedback@easywallet.com</a></p>
	                </div>
	            </div>
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