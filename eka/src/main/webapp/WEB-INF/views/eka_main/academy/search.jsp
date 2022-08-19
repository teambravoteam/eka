<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" import="java.sql.Connection" import="java.sql.DriverManager" import="java.sql.SQLException" import="java.sql.Statement" import="java.sql.ResultSet" import="org.jdom2.*" import="org.jdom2.output.*"%>

<!DOCTYPE html>
<html lang="ko">

<%
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

String ds = "";
double clat = Double.parseDouble(request.getParameter("center_lat"));
double clng = Double.parseDouble(request.getParameter("center_lng"));

//콘솔 출력 테스트
System.out.println(clat);
System.out.println(clng);

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
	System.out.println("JDBC Connector 연결 성공 !");

	stmt = con.createStatement();
	rs = stmt.executeQuery(qu);

	System.out.println("SQLServerStatement 개체 생성 !");

	//org.jdom2.* 사용
	Element root = new Element("markers");
	Document doc = new Document(root);
%>

        <head>
          <meta charset="utf-8">
            <meta name="viewport" content="initial-scale=1.0">
              <title>Seminar Load</title>

              <style>
                body {
                  font-family: "맑은 고딕", "고딕", "굴림";
                }
                body,
                html {
                  margin: 0;
                  padding: 0;
                }
                #wrapper {
                  width: 100%;
                  margin: 0 auto;
                }
                /* Always set the map height explicitly to define the size of the div
       *element that contains the map. */
                #map {
                  height: 100%;
                }
                /* Optional: Makes the sample page fill the window. */
                #classlist {
                  width: 45%;
                  margin-top: 15vh;
                  margin-left: 5vh;
                  height: 85vh;
                  float: left;
                }
                #maplist {
                  position: fixed;
                  margin-top: 15vh;
                  margin-left: 45%;
                  width: 55%;
                  height: 85vh;
                  float: left;
                }
              </style>

            </head>
            <body>
              <div>
                <div id="wrapper">

                  <div id="classlist">
                    <br>
                      <br>
                        조건에 맞는 세미나 목록입니다
                        <br>
                          <br>

<%
				//등록된 원데이클래스 불러오기
				while (rs.next()) {

					//하버사인 공식 (검색지점으로부터의 거리 계산)

					double distance;
					double radius = 6371; // 지구 반지름(km)
					double toRadian = Math.PI / 180;

					double locationlat = Double.parseDouble(rs.getString("lat"));
					double locationlng = Double.parseDouble(rs.getString("lon"));

					double deltaLatitude = Math.abs(clat - locationlat) * toRadian;
					double deltaLongitude = Math.abs(clng - locationlng) * toRadian;

					double sinDeltaLat = Math.sin(deltaLatitude / 2);
					double sinDeltaLng = Math.sin(deltaLongitude / 2);
					double squareRoot = Math.sqrt(sinDeltaLat * sinDeltaLat
					+ Math.cos(clat * toRadian) * Math.cos(locationlat * toRadian) * sinDeltaLng * sinDeltaLng);

					distance = 2 * radius * Math.asin(squareRoot);

					System.out.println(distance);

					// 검색기준지점으로부터 하버사인 거리가 0.3km 미만인 클래스만 카카오맵에 출력

					if (distance < 0.3) {

						out.println("<table>");

						out.println("<tr>");
						out.println("<td>" + rs.getString("address") + "</td>");
						out.println("</tr>");

						out.println("<tr>");
						out.println("<td>" + rs.getString("name") + "</td>");
						out.println("</tr>");

						out.println("<tr>");
						out.println("<td>" + rs.getString("lat") + "</td>");
						out.println("</tr>");

						out.println("<tr>");
						out.println("<td>" + rs.getString("lon") + "</td>");
						out.println("</tr>");

						out.println("</table>");

						continue;

					}

				}
%>
                            </div>
                            <div id="maplist">
                              <div id="map"></div>
                              <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fc2120b8ad3fcff0b18376b88b35a6f5&libraries=services"></script>

                              <!-- 카카오 마커 등록 -->

                              <script>

                                var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                                  mapOption = {
                                    center: new kakao.maps.LatLng(<%=clat%>, <%=clng%>), // 지도의 중심좌표
                                    level: 4 // 지도의 확대 레벨
                                  };
                                var map = new kakao.maps.Map(mapContainer, mapOption)

                                // 인포윈도우를 생성합니다
                                var infowindow = new kakao.maps.InfoWindow();

                                // Change this depending on the name of your PHP or XML file
                                downloadUrl('./xml?dclat=<%=clat%>&dclng=<%=clng%>', function (data) {
                                    var xml = data.responseXML;
                                 	var markers = xml.documentElement.getElementsByTagName('marker');
                                    Array.prototype.forEach.call(markers, function (markerElem) {
                                    var pname = markerElem.getAttribute('name');
                                    var paddress = markerElem.getAttribute('address');
                                    var point = new kakao.maps.LatLng(parseFloat(markerElem.getAttribute('lat')), parseFloat(markerElem.getAttribute('lon')));

                                    // 아래 내용은 infowindow html 구현, document.createElement

                                    var infowincontent = document.createElement('div');

                                    // Strong은 html 구현으로서 굵은 글씨를 의미. 마찬가지로 세줄아래의 br도 줄 띄우기.
                                    var strong = document.createElement('strong');
                                    strong.textContent = pname
                                    strong.style = "display: inline-block; white-space: normal; overflow:hidden; text-overflow: ellipsis; line-height:1.5; height:3.0em";
                                    infowincontent.appendChild(strong);
                                    infowincontent.appendChild(document.createElement('br'));

                                    var text = document.createElement('text');
                                    text.textContent = paddress
                                    infowincontent.appendChild(text);

                                    // 마커 특성 설정
                                    var marker = new kakao.maps.Marker({map: map, position: point});

                                    // 마커에 마우스 오버 이벤트를 등록합니다
                                    kakao.maps.event.addListener(marker, 'mouseover', function () {
                                      infowindow.setContent(infowincontent);
                                      infowindow.open(map, marker);

                                    });

                                  });
                                });

                                function downloadUrl(url, callback) {
                                  var request = window.ActiveXObject
                                    ? new ActiveXObject('Microsoft.XMLHTTP')
                                    : new XMLHttpRequest;

                                  request.onreadystatechange = function () {
                                    if (request.readyState == 4) {
                                      request.onreadystatechange = doNothing;
                                      callback(request, request.status);
                                    }
                                  };

                                  request.open('GET', url, true);
                                  request.send(null);
                                }

                                function doNothing() {}
                              </script>

                            </div>
                          </div>
                        </div>

<%
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
                        </body>
                      </html>
