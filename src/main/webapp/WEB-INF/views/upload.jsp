<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<input id="fileupload" type="file" name="file" data-url="/api/upload" data-form-data='{"path": "receipt"}'>
		
		<script src="<c:url value="/static/js/jquery-1.11.3.min.js"/>"></script>
		<script src="<c:url value="/static/js/jquery.ui.widget.js"/>"></script>
		<script src="<c:url value="/static/js/jquery.iframe-transport.js"/>"></script>
		<script src="<c:url value="/static/js/jquery.fileupload.js"/>"></script>
		<script>
		$(function () {
		    $('#fileupload').fileupload({
		        dataType: 'json',
		        done: function (e, data) {
		           var img = $('<img/>');
		           img.attr('src',data.result.path + data.result.thumbnail);
		           img.appendTo('body');
		        }
		    });
		});
		</script>
	</body> 
</html>