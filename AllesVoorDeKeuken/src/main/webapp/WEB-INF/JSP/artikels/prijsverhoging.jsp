<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Prijsverhoging' />
</head>
<body>
	<v:menu />
	<h1>Prijsverhoging</h1>
	<form method="post">
		<label>Percentage:<span>${fouten.percentage}</span>
		<input name="percentage" type="number" value="${param.percentage}" min="0.01" step="0.01" required autofocus ></label>
		<input type="submit" value="Uitvoeren">
	</form>
	<script>
		document.getElementById('opslagform').onsubmit = function() {
			document.getElementById('submitknop').disabled = true;
		};
	</script>
</body>
</html>