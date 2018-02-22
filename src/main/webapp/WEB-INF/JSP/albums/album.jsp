<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>

<!doctype html>
<html lang='nl'>
<title>${album.naam}</title>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
</head>
<body>
	<h1>${album.naam}</h1>
	<h2>${album.artiest.naam}</h2>
	<h3>Tracks:</h3>
	<table>
		<tr>
			<th>Tracknaam</th>
			<th>Duurtijd</th>
		</tr>
		<c:forEach items="${album.tracks}" var="track">
			<tr>
				<td>${track.naam}</td>
				<td>${track.tijd}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Totale duurtijd van het album: ${albumtijd}</p>
</body>
</html>