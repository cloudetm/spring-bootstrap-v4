<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
	
	<title>Boot Sample | Home</title>
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/styles.css" rel="stylesheet">
	
</head>
<body>
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded navbar-inverse bg-inverse">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <h1 class="navbar-brand mb-0">Spring</h1>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="new-client">New Client</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="all-clients">All Clients</a>
      </li>
    </ul>
  </div>
</nav>

<c:choose>
	<c:when test="${mode == 'MODE_HOME'}">
		<div class="container" id="homeDiv">
			<div class="jumbotron text-center">
				<h1>Welcome to Clients</h1>		
			</div>
		</div>
	</c:when>
	
	<c:when test="${mode == 'MODE_CLIENTS'}">
		<div class="container text-center" id="clientsDiv">
			<div class="container text-center">
				<h3>Clients</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Date Created</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="client" items="${clients}">
								<tr>
									<td>${client.id}</td>
									<td>${client.first_name}</td>
									<td>${client.last_name}</td>
									<td>${client.email}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${client.dateCreated}"/></td>
									<td><a href="update-client?id=${client.id}"><input type="button" value="Update"></a></td>
									<td><a href="delete-client?id=${client.id}"><input type="button" value="Delete"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>	
		</div>
	</c:when>
	
	<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
		<div class="container">
			<h3>Manage Client</h3>
			<hr>
			<form class="form-horizontal" method="post" action="save-client">
				<input type="hidden" name="id" value="${client.id}"/>
				<div class="form-group">		
					<div class="col-lg-6">
						<label>First Name</label>
						<input type="text" class="form-control" name="first_name" value="${client.first_name}"/>
					</div>			
				</div>
				<div class="form-group">		
					<div class="col-lg-6">
						<label>Last Name</label>
						<input type="text" class="form-control" name="last_name" value="${client.last_name}"/>
					</div>			
				</div>
				<div class="form-group">		
					<div class="col-lg-6">
						<label>Email</label>
						<input type="text" class="form-control" name="email" value="${client.email}"/>
					</div>			
				</div>
				<div>
					<input type="submit" class="btn btn-outline-primary" value="save">
				</div>
			</form>
		</div>
	</c:when>
	<c:when test="${mode == 'MODE_UPDATE'}">
	
	</c:when>
</c:choose>







	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
