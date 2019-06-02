<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="<%=request.getContextPath()%>/resources/styles/bulma.min.css"
	rel="stylesheet" />

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
  response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
  response.setDateHeader("Expires", 0); // Proxies.
%>
</head>
<body>
	<div class="container">
		<h1 class="is-size-1-desktop">Login JSP</h1>
		<form action="j_security_check" method="POST">
			<div class="tile is-vertical is-4">
				<div class="field">
					<label class="label" for="j_username">Username</label>
					<div class="control">
						<input type="text" class="input is-rounded" id="j_username"
							name="j_username" />
					</div>
				</div>
				<div class="field">
					<label class="label" for="j_password">Password</label>
					<div class="control">
						<input type="password" class="input is-rounded" id="j_password"
							name="j_password" /> <br />
					</div>
				</div>
				<div class="field is-grouped">
					<div class="control">
						<button class="button is-primary">Log In</button>
						<button class="button is-danger" value="Reset">Reset</button>
					</div>
				</div>
			</div>

		</form>
	</div>
</body>
</html>
