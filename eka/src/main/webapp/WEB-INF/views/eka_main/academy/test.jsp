<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*"%>
	<meta name="viewport" content="width=device-width,initial-scale=1.0" />

	<h2>JDBC드라이버 테스트</h2>

	<%
	Connection conn = null;

	try {
		String jdbcUrl = "jdbc:mysql://localhost:3306/dbtest";
		String dbId = "jspid";
		String dbPass = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		out.println("제대로 연결되었습니다.");
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>