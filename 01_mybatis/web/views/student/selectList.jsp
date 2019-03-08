<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%-- <c:if test="${param.no!=null }"> --%>
	<c:if test="${not empty list }">
		<table>
			<tr>
				<td colspan="6">${param.no }번학생정보</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			<%-- <c:forEach var="i" begin="0" end="${fn:length(list) }"> --%>
			<c:forEach var="map" items="${list }">
				<tr>
				
	<%-- 			
					<!-- 객체로 받을때 객체 변수값으로 받아야함 -->
					<td>${list[i].studentNo }</td>
					<td>${list[i].studentName }</td>
					<td>${list[i].studentTel }</td>
					<td>${list[i].studentEmail }</td>
					<td>${list[i].studentAddr }</td>
					<td>${list[i].reg_date }</td>
	 --%>
	 
	 				<td>${map['studentNo'] }</td>
					<td>${map['studentName'] }</td>
					<td>${map['studentTel'] }</td>
					<td>${map['studentEmail'] }</td>
					<td>${map['studentAddr'] }</td>
					<td>${map['reg_date'] }</td>
	
					 
					<!-- 맵으로 받을때는 테이블의 컬럼명으로 받아야 한다. -->
					<%-- 
						<td>${map['STUDENT_NO'] }</td>
						<td>${map['STUDENT_NAME'] }</td>
						<td>${map['STUDENT_TEL'] }</td>
						<td>${map['STUDENT_EMAIL'] }</td>
						<td>${map['STUDENT_ADDR'] }</td>
						<td>${map['REG_DATE'] }</td>
	 --%>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>