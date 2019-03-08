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

	<h1>수업내용</h1>
	<div id="student-container" style="border: 1px solid black;">
		<h2>학생정보검색</h2>
		<p>총 학생수(student Table)는 ${count1 }명 입니다.</p>
		<form name="frm" action="${path }/student/selectOne.do">
			<table id="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="전체조회" onclick="fn_total();"/>
						<input type="submit" value="검색" />
						<input type="button" value="삭제" onclick="fn_submit();"/>
					</td>
				</tr>
			</table>
		</form>
		<script >
			function fn_total() {
				frm.action="${path }/student/total.do";
				frm.submit();
			}
			
			function fn_submit() {
				frm.action="${path }/student/delete.do";
				frm.submit();
			}
		</script>

		<%-- <c:if test="${param.no!=null }"> --%>
		<c:if test="${not empty param.no }">
			<table>
				<tr>
					<td colspan="6">${param.no }번학생 정보</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>주소</th>
					<th>등록일</th>
				</tr>
				<tr>
				<!-- 객체로 받을때 객체 변수값으로 받아야함 -->
					<td>${map['studentNo'] }</td>
					<td>${map['studentName'] }</td>
					<td>${map['studentTel'] }</td>
					<td>${map['studentEmail'] }</td>
					<td>${map['studentAddr'] }</td>
					<td>${map['reg_date'] }</td>
				
				
<%-- 
				맵으로 받을때는 테이블의 컬럼명으로 받아야 한다. 
					<td>${map['STUDENT_NO'] }</td>
					<td>${map['STUDENT_NAME'] }</td>
					<td>${map['STUDENT_TEL'] }</td>
					<td>${map['STUDENT_EMAIL'] }</td>
					<td>${map['STUDENT_ADDR'] }</td>
					<td>${map['REG_DATE'] }</td>
 --%>
 
				</tr>
			</table>
		</c:if>
	</div>
	<hr>

<%-- 
	<hr>
	<h1>연습</h1>
	<div id="student-container" style="border: 1px solid black;">
		<h2>학생정보검색</h2>
		<p>총 학생수(student Table)는 ${count1 }명 입니다.</p>
		<form action="${path }/student/selectOne.do">
			<table id="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="검색" /> <input
						type="button" value="삭제" id="student_del" /></td>
				</tr>
			</table>
			<c:if test="${param.no!=null }">
				<table>
					<tr>
						<td colspan="6">${param.no }번학생 정보</td>
					</tr>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>연락처</th>
						<th>이메일</th>
						<th>주소</th>
						<th>등록일</th>
					</tr>
					<tr>
						<td>${map['STUDENT_NO'] }</td>
						<td>${map['STUDENT_NAME'] }</td>
						<td>${map['STUDENT_TEL'] }</td>
						<td>${map['STUDENT_EMAIL'] }</td>
						<td>${map['STUDENT_ADDR'] }</td>
						<td>${map['REG_DATE'] }</td>
					</tr>
				</table>
			</c:if>
		</form>
		<form action="${path }/student/delOne.do" id="del_frm">
			<input type="hidden" name="delNo" />
		</form>
		<script>
			$(function(){
				$("#student_del").on("click",function(){
					console.log($("input[name='delNo']").val($("input[name='no']").get(1).value));
					$("input[name='delNo']").val($("input[name='no']").get(1).value);
					$("#del_frm").submit();
				})
			})
		</script>
	</div>
	 --%>
	
</body>
</html>