<%--
  Created by IntelliJ IDEA.
  User: zhao_temporary
  Date: 2022/3/21
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="http://localhost:8089/bookMarket/uploadServlet" method="post" enctype="multipart/form-data" >
    用户名:<input type="text" name="username" /><br/>
    头像:<input type="file" name="photo" /><br/>
    <input type="submit" value="上传">

</form>
</body>
</html>
