<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="vdab" uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<vdab:head title='Alles voor de keuken' />
<body>
	<header>
		<vdab:menu />
		<h1>Alles voor de keuken</h1>
		<img src='<c:url value="/images/logo${logoNr}.jpg"/>' alt='logo' id='logo' />
	</header>
</body>
</html>
