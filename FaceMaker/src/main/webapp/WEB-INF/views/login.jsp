<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
function login() {
	if(document.getElementById("id").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("password").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "${root}/login";
		document.getElementById("loginform").submit();
	}
}
	 
function moveJoin() {
	document.location.href = "${root}/add";
}	
</script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<form id="loginform" method="post" action="">
		<input type="hidden" name="act" id="act" value="login">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" ">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
			</div>
			
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="javascript:login();">로그인</button>
				<button type="button" class="btn btn-primary" onclick="javascript:moveJoin();">회원가입</button>
			</div>
		</form>
	</div>
</div>
