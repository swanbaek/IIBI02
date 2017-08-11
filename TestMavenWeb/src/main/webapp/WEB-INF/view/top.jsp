<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String myctx=request.getContextPath(); //=> "/MVCWeb"
%>    
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=myctx%>/index.do"><span>Brand</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="<%=myctx%>/index.do">Home</a></li>
					<li><a href="<%=myctx%>/join.do">Join</a></li>
					<c:if test="${loginUser eq null}">
						<li><a href="<%=myctx%>/login.do">Login</a></li>
					</c:if>
					<c:if test="${loginUser ne null }">
						<li class="bg-info"><a href="#">${loginUser.userid}님 로그인 중</a></li>
						<li><a href="<%=myctx%>/logout.do">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-pills">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Profile</a></li>
						<li><a href="#">Messages</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-center">Subscribe</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form role="form">
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Enter your email"> <span
									class="input-group-btn"> <a class="btn btn-primary"
									type="submit">Go</a>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	 <div class="section">
		<div class="container"> 
			<div class="row">
				<div class="col-md-3">
				
			
				
					<ul class="list-group">
						<li class="list-group-item"><a href="<%=myctx%>/memoList.do">Memo</a></li>
						<li class="list-group-item"><a href="<%=myctx%>/boardList.do">Board</a></li>
						<li class="list-group-item"><a href="<%=myctx%>/member/list.do">Member</a></li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
				<div class="col-md-9">
				
				
				