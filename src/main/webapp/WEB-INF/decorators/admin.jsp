<%--
  Created by IntelliJ IDEA.
  User: Tama OwO
  Date: 9/23/2024
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/" var="URL"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Page Title</title>
</head>
<body>
<sitemesh:write property ="body" />
<script>
    function chooseFile(fileInput){
        console.log(fileInput.files[0])
        if(fileInput.files && fileInput.files[0]){
            var reader = new FileReader()
            reader.onload = function (e){
                document.getElementById("Hinh").setAttribute('src', e.target.result);
            }
            reader.readAsDataURL(fileInput.files[0])
        }
    }
</script>
</body>
</html>
