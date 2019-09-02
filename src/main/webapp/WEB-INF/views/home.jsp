<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>문제야 문제 온 세상 속에</title>
<link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.png">
<link href="<c:url value='/resources/css/first.css' />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 여기부터 재건축 -->
<script src="<c:url value="/resources/js/first.js"/>"></script>

</head>

<body ng-app="lynnApp" ng-controller="MainCtrl">
<%
	String username="";
	if(session.getAttribute("user")!= null){
		username=session.getAttribute("user").toString();
	}
%>

	ID = ${sessionScope.user}
	<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".modal">Modal Open</button>
	<div class="container">
		<h3 id="idInfo">Test</h3>
		<p>
			위의 버튼 3개만 이용하여 추가, 수정, 삭제 이벤트를 구현 <br> 1) 추가 : "입력하세요" 입력창을 이용하여 데이터 생성<br> 2) 수정 : 선택(체크박스)를 선택된 내용만 "입력하세요" 입력창으로 데이터를 가져온 후
			수정<br> 3) 삭제 : 선택(체크박스)를 선택된 내용만 데이터를 삭제<br> 4) 유저 : 추가 시 사용자가 누군지 myModal를 이용하여 정보를 받아서 데이터 처리하기<br> 5) 기능 : localStorage
			에서 처리 하던 부분를 Spring (Controller)를 이용하여 처리<br> 참조 : 체크박스 이벤트는 위에 있는 script의 이벤트를 같이 이용하여 처리
		</p>
	</div>
	<div class="container">
		<h1 class="text-center">Test</h1>
		<form id="edit" name="crudForm">
			<div class="form-group row">
				<div class="col-xs-2">
					<label for="text">한줄평 :</label>
				</div>
				<div class="col-xs-6">
					<input type="text" class="form-control" id="text" name="text" placeholder="입력하세요." autocomplete="off" ng-model="dataInfo.comment">
				</div>
				<div class="col-xs-1">
					<button type="button" class="btn btn-primary" id="submit" ng-click="formAction('insert')">추가</button>
				</div>
				<div class="col-xs-1">
					<button type="button" class="btn btn-success disabled" id="update" ng-click="formAction('update')">수정</button>
				</div>
				<div class="col-xs-1">
					<button type="button" class="btn btn-danger disabled" id="remove" ng-click="formAction('delete')">삭제</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>선택</th>
					<th>번호</th>
					<th>한줄평</th>
					<th>글쓴이</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="item in storage">
					<td><input type="checkbox" ng-model="item.isChecked" ng-click="updateCheckNumb($index)"></td>
					<td>{{item.pno}}</td>
					<td>{{item.comment}}</td>
					<td>{{item.writer}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<h2>Storage status</h2>
	{{storage}}<br>
	<h2>crudForm status</h2>
	{{crudForm}}
	<!-- Modal -->
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-lock"></span>Login
						</h4>
					</div>
					<div class="modal-body" style="padding: 40px 50px;">
						<form method="POST" id="login">
							<div class="switch_box box_1">
								<input type="checkbox" id="switchFlag" class="switch_1" name="switchFlag" ng-model="loginCheckbox">
							</div>
							<div class="form-group">
								<label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label> <input type="text" class="form-control"
									name="username" id="usrname" placeholder="Enter email" required="required" ng-model="userInfo.username" autocomplete="off">
							</div>
							<div class="form-group">
								<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> <input type="password" class="form-control"
									name="password" id="psw" placeholder="Enter password" required="required" ng-model="userInfo.password" autocomplete="off">
							</div>
							<button type="submit" class="btn btn-success btn-block" ng-click="modalMethod()">
								<span class="glyphicon glyphicon-off"></span> Login
							</button>
						</form>
						User Info :: {{userInfo}}<br>
						message :: {{message}}
					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>
