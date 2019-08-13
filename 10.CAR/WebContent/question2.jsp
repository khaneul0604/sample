<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판 메인메뉴</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		<script src="js/jquery.xml2json.js">
		
		</script>
		
		<style>
		table {margin-top: 30px}
		</style>
		
	</head>
	<body>
		<h1>Q & A</h1>
		
		<input type="button"  value="글작성" onclick="location.href='input.jsp'"/>
				<table border="1" class="table table-striped"> 
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>답변</td>
					</tr>
					<c:forEach var="question" items="${questions}"> 
					<tr>
						<td>${question.questnum}</td>
						<td>${question.questTitle}</td>
						<td>${question.memberNum}</td>
						<td>${question.answer}</td>
					</tr>		
					</c:forEach>
				</table>
				
			<c:if test="${pageGroupResult.beforPage}">
				<a href="question_req_list?reqPage=${pageGroupResult.groupStartNumber-1}">《</a>
			</c:if>
	 
					<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
						<c:choose>
							<c:when test="${pageGroupResult.selectPageNumber==index}">
								<span class="badge badge-secondary"><a href="question_req_list?reqPage=${index}">${index}</a></span>
							</c:when>
							<c:otherwise>
								<a href="question_req_list?reqPage=${index}">${index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	
	 		<c:if test="${pageGroupResult.afterPage}">
				<a href="question_req_list?reqPage=${pageGroupResult.groupEndNumber+1}">》</a>
			</c:if> 
	</body>
</html>