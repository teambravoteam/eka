<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" import="java.io.FileWriter" import="java.sql.Connection" import="java.sql.DriverManager" import="java.sql.SQLException" import="java.sql.Statement" import="java.sql.ResultSet" import="org.jdom2.*" import="org.jdom2.output.*"%>

<%
String dsxml = request.getParameter("dsxml");
double ddclat = Double.parseDouble(request.getParameter("dclat"));
double ddclng = Double.parseDouble(request.getParameter("dclng"));

Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try {

	System.out.println("드라이버 로드 성공 !");

	String url = "jdbc:mysql://localhost:3306/eka?useSSL=false&allowPublicKeyRetrieval=true";
	String account = "eka";
	String pass = "eka";
	String qu = "SELECT * FROM Academy";

	// 이 때 *은 모든 필드(컬럼)을 의미하며 콤마로 별도의 필드(컬럼)을 지정해 줄 수 있다.

	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection(url, account, pass);
	System.out.println(con.toString());
	System.out.println("XML JDBC Connector 연결 성공 !");

	stmt = con.createStatement();
	rs = stmt.executeQuery(qu);

	System.out.println("XML SQLServerStatement 개체 생성 !");

	//org.jdom2.* 라이브러리 사용
	Element mapmarker2 = new Element("markers");
	Document doc = new Document(mapmarker2);

	while (rs.next()) {

		//하버사인 공식 (검색지점으로부터의 거리 계산)

		double distance;
		double radius = 6371; // 지구 반지름(km)
		double toRadian = Math.PI / 180;

		double locationlat = Double.parseDouble(rs.getString("lat"));
		double locationlng = Double.parseDouble(rs.getString("lon"));

		double deltaLatitude = Math.abs(ddclat - locationlat) * toRadian;
		double deltaLongitude = Math.abs(ddclng - locationlng) * toRadian;

		double sinDeltaLat = Math.sin(deltaLatitude / 2);
		double sinDeltaLng = Math.sin(deltaLongitude / 2);
		double squareRoot = Math.sqrt(sinDeltaLat * sinDeltaLat
		+ Math.cos(ddclat * toRadian) * Math.cos(locationlat * toRadian) * sinDeltaLng * sinDeltaLng);

		distance = 2 * radius * Math.asin(squareRoot);

		// 검색기준지점으로부터 하버사인 거리가 0.3km 미만인 클래스만 카카오맵에 출력 (향후 해당값은 검색조건필터로 활용가능)

		if (distance < 0.4) {

	Element data = new Element("marker");

	data.setAttribute("name", rs.getString("name"));
	data.setAttribute("address", rs.getString("address"));
	data.setAttribute("lat", rs.getString("lat"));
	data.setAttribute("lon", rs.getString("lon"));

	mapmarker2.addContent(data);

	XMLOutputter xout = new XMLOutputter();
	Format f = xout.getFormat();
	f.setEncoding("utf-8");
	f.setIndent("\t");
	f.setLineSeparator("\r\n");
	f.setTextMode(Format.TextMode.TRIM);
	xout.setFormat(f);

	String result = xout.outputString(doc);

	out.clear();
	out.print(result);

	continue;
		}
	}
} catch (SQLException e) {
	System.out.println("SQLException : " + e.getMessage());

} finally {
	if (stmt != null) {
		try {
	stmt.close();
		} catch (Exception e) {
	e.printStackTrace();
		}
	}
	if (rs != null) {
		try {
	rs.close();
		} catch (Exception e) {
	e.printStackTrace();
		}
	}
	if (con != null) {
		try {
	con.close();
		} catch (Exception e) {
	e.printStackTrace();
		}
	}
}
%>