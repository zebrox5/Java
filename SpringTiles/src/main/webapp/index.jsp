<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<!-- Redirecting it to home page as index.jsp is the first page -->
	<%
		response.sendRedirect("home");
	%>
</body>
</html>
