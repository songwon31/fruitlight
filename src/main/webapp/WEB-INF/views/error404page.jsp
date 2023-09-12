<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error404page.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css"/>
		<title>main </title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
	<div id="wrapper" class="wrapper">
        <div id="cnts" class="cnts">
            <h1 id="ErrorMessage" class="ErrorMessage">404 페이지를 찾을 수 없습니다.</h1>
            <p id="ErrorMessageInfo" class="ErrorMessageInfo">올바른 URL을 입력하였는지 확인하세요.</p>
            <p class="bt">
                <a href="javascript:history.back();">
                	<img src="https://ssl.nexon.com/S2/p3/etc/2016/bt_prev.gif" width="175" height="48">
                </a>
                <a href="main">
                	<img src="https://ssl.nexon.com/S2/p3/etc/2016/bt_home.gif" width="175" height="48">
                </a>
            </p>
        </div>
    </div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>