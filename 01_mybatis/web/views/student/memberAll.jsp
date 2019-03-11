<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form action="${path }/member/memberSearch.do">
		<input type="text" name="keyword"/>
		<input type="submit" value="검색"/>
	</form>
	<table>
		<tr>
			<th>MEMBER_ID</th>
			<th>MEMBER_PWD</th>
			<th>MEMBER_NAME</th>
			<th>GENDER</th>
			<th>AGE</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>ADDRESS</th>
			<th>HOBBY</th>
			<th>ENROLL_DATE</th>
		</tr>
		<c:if test="${not empty list }">
			<c:forEach var="m" items="${list }">
<%-- 
				<tr>
					<td>${m['memberId'] }</td>
					<td>${m['memberPwd'] }</td>
					<td>${m['memberName'] }</td>
					<td>${m['gender'] }</td>
					<td>${m['age'] }</td>
					<td>${m['email'] }</td>
					<td>${m['phone'] }</td>
					<td>${m['address'] }</td>
					<td>${m['hobby'] }</td>
					<td>${m['enrollDate'] }</td>
				</tr>
				 --%>
				<tr>
					<td>${m['MEMBER_ID'] }</td>
					<td>${m['MEMBER_PWD'] }</td>
					<td>${m['MEMBER_NAME'] }</td>
					<td>${m['GENDER'] }</td>
					<td>${m['AGE'] }</td>
					<td>${m['EMAIL'] }</td>
					<td>${m['PHONNE'] }</td>
					<td>${m['ADDRESS'] }</td>
					<td>${m['HOBBY'] }</td>
					<td>${m['ENROLL_DATE'] }</td>
				</tr>
				
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			<td colspan="10">검색결과가 없습니다.</td>
		</c:if>
	</table>

</body>
</html>