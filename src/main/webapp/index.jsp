<html>
<body>
<h2>Hello World!</h2>

<jsp:useBean id="step" class="FastFood.state.State"/>
<jsp:useBean id="service" class="FastFood.service.Service"/>
<h1><% step.Step(); %></h1>
</body>
</html>
