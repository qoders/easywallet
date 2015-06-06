<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Welcome</title>
	</head>
	<body>
		Change language: 
		<c:forEach items="${languages}" var="lang">
			<a href="?language=${lang.key}">${lang.value}</a> | 
		</c:forEach>
		<spring:message code="Pages.Index.Welcome" htmlEscape="false"/> in ${pageContext.response.locale.displayLanguage} (${language})
	</body>
</html>