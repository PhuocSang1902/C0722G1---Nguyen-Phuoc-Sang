<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 18/11/2022
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Convert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/translate" method="post">
    <div class="mb-3">
        <label for="vnWord" class="form-label">Từ tiếng việt</label>
        <input type="text" class="form-control" id="vnWord" placeholder="Nhập từ" name="vnWord">
    </div>
    <input type="submit" value="Dịch">
</form>

<c:if test="${result != null}">
    <div class="mb-3">
        <label for="result" class="form-label">Từ tiếng anh</label>
        <input type="text" class="form-control" id="result" name="result" value="${result}">
    </div>
</c:if>
</body>
</html>