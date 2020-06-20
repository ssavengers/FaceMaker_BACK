<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyB8grAj7r7Y0Xy7uDqWCmIg6ZD-b-QtdaY"></script>

<script type="text/javascript">
$(document).ready(function() {
   $("#main").click(function(){
      $("#memberform").attr("action", "${root}/list").submit();
   });
});
</script>
</head>
<body>
   <div align="center">
      <c:if test="${userinfo == null}">
         <h3>${msg}</h3>
         <%@ include file="login.jsp"%>
      </c:if>
      <c:if test="${userinfo != null}">
         <form method="get" id="memberform" action="">
            <div>
               welcome!<strong>${userinfo.id}</strong> <a href="${root}/logout">logout</a>
            </div>
            <button type="button" class="btn btn-primary" id="main">main</button>
		</form>
  	</c:if>
  </div>

</body>
</html>