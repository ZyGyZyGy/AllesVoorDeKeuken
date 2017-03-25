<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Artikel toevoegen' />
</head>
<body>
	<v:menu />
	<h1>Artikel toevoegen</h1>
	<form method='post' id='toevoegform'>
		<label>Naam:<span>${fouten.naam}</span>
		<input name="naam" value="${param.naam}" required autofocus></label>
		<label><input type="radio" name="soort" id="food" value="F" required><span>${fouten.soort}</span>Food</label><br>
		<label>Houdbaarheid:
		<input type="number" name="houdbaarheid" id="houdbaarheid" required></label>
		<label><input type="radio" name="soort" id="nonfood" value="NF"><span>${fouten.soort}</span>Non-Food</label><br>
		<label>Garantie:
		<input type="number" name="garantie" id="garantie" required></label>
		<label>Aankoopprijs:<span>${fouten.aankoopprijs}</span>
		<input name="aankoopprijs" value="${param.aankoopprijs}" type="number" min="0.01" step="0.01" required></label>
		<label>Verkoopprijs:<span>${fouten.verkoopprijs}</span>
		<input name="verkoopprijs" value="${param.verkoopprijs}" type="number" step="0.01" required></label>
		<input type="submit" value="Toevoegen" id="toevoegknop">
	</form>
	<script>
		document.getElementById('toevoegform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
		document.getElementById('food').onclick = enableDisableInputs;
		document.getElementById('nonfood').onclick = enableDisableInputs;
		enableDisableInputs();
		function enableDisableInputs() {
			document.getElementById('houdbaarheid').disabled = !document
					.getElementById('food').checked;
			document.getElementById('garantie').disabled = !document
					.getElementById('nonfood').checked;
		}
	</script>
</body>
</html>
