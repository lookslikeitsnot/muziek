<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Albums</title>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
</head>
<body>
	<h1>Albums</h1>
	<ul class='zonderbolletjes'>
		<c:forEach items='${albums}' var='album'>
			<c:url value='/albums/album.htm' var='url'>
				<c:param name='id' value='${album.id}' />
			</c:url>
			<li><a href='${url}'>${album.naam}</a> - ${album.artiest.naam}</li>
		</c:forEach>
	</ul>
</body>
</html>