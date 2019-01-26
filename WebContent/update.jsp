<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
        <div>
            <div>
            <!-- 图片位置 -->
            <div>
            ${session.getAttribute("cake") }
            <p>商品名称：${cake.cakeName }</p>
            <p>商品大小：${cake.cakeSize }</p>
            <p>商品价格：${cake.cakePrice }</p>
            <p>商品类型：${cake.cakeTypeId }</p>
        </div>
</body>
</html>