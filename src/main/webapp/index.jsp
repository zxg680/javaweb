<html>
<body>
<h2>Hello World!</h2>

Your application has successfully deployed<br/>
<br/>
Java runteime version:<%= System.getProperty("java.version") %>
<br/>

getRequestURL: <%= request.getRequestURL() %><br/>
getRequestURI:<%= request.getRequestURI() %><br/>
getServletPath:<%= request.getServletPath() %>

</body>
</html>
