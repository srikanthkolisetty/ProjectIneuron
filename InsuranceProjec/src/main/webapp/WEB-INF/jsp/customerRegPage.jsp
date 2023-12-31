<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand">Insurance Policy Management</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse p-2" id="navbarNav">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-5"></ul>
				<div class="d-flex navbar-nav fs-5">
					<li class="nav-item"><a class="nav-link active text-warning"
						aria-current="page" href="http://localhost:8080/">
							Home </a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="http://localhost:8080/userLogin">Customer</a>
					</li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="http://localhost:8080/adminLogin">
							Admin </a></li>
				</div>
			</div>
		</div>
	</nav>

	<div class="bg-light">
		<form:form method="post" action="http://localhost:8080/signupData" modelAttribute="customer">
			<div class="text-center mx-auto my-4 border border-1 bg-white"
				style="width: 600px">
				<h2 class="display-5 mb-5">Customer Details Form</h2>

				<div class="mb-3">
					<label>Customer Name <form:input type="text"
							path="name" class="form-control" style="width: 18rem" />
						<form:errors path="name" cssClass="text-danger" />
					</label>
				</div>

				<div class="mb-3">
					<label>Username <form:input type="text"
							path="userName" class="form-control" style="width: 18rem" /> <form:errors
							path="userName" cssClass="text-danger" />
					</label>
				</div>

				<div class="mb-3">
					<label>Password <form:input type="password"
							path="password" class="form-control" style="width: 18rem" /> <form:errors
							path="password" cssClass="text-danger" />
					</label>
				</div>

				<div class="mb-3">
					<label>Customer Age <form:input type="text"
							path="age" class="form-control" style="width: 18rem" />
						<form:errors cssClass="text-danger" path="age" /></label>
				</div>
				<div class="mb-3">
					<label> Customer Gender <form:select
						path="gender" id="gender" class="form-control"
						style="width: 18rem">
							<form:option value="Select">Select</form:option>
							<form:option value="M">Male</form:option>
							<form:option value="F">Female</form:option>
					</form:select>
					<form:errors cssClass="text-danger" path="gender" />
					</label>
				</div>
				<div class="mb-3">
					<label>Customer Address <form:input
							type="text" path="address" class="form-control"
							style="width: 18rem" /> <form:errors path="address"
							cssClass="text-danger" />
					</label>
				</div>

				<div class="mb-3">
					<label>Customer Phone No <form:input
							type="text" name="phoneNumber" path="phoneNumber"
							class="form-control" style="width: 18rem" />
						<form:errors path="phoneNumber" cssClass="text-danger" />
					</label>
				</div>

				<div class="mb-3">
					<button name="subm" class="btn btn-primary" type="submit">
						Register</button>
				</div>
				<br/>
				<br/>
			</div>
		</form:form>
	</div>
	<footer class="bg-dark text-white text-center text-lg-start p-3 fixed-bottom">
      <div class="text-center p-3">ME Insurance Company</div>
    </footer>
</body>
</html>
