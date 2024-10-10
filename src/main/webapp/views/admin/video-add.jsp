<%--
  Created by IntelliJ IDEA.
  User: Tama OwO
  Date: 10/8/2024
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>
<form action="<c:url value="/admin/video/insert"/>" method="post" enctype="multipart/form-data">
    <label for="title">Video Title:</label><br>
    <input type="text" id="title" name="title"><br>

    <label for="poster">Link poster:</label><br>
    <input type="text" id="poster" name="poster"><br>

    <label for="poster1">Upload Poster:</label><br>
    <img height="150" width="200" src="" id="posterr" />
    <input type="file" onchange="chooseFile(this)" id="poster1" name="poster1"><br>

    <label for="poster1">Choose Category:</label><br>
    <select name="categoryid" id="categoryid">
        <c:forEach items="${listcate}" var="cate">
            <option value =${cate.categoryid}>${cate.categoryname}</option>
        </c:forEach>
    </select><br>

    <label for="active">Active:</label><br>
    <input type="radio" id="activeon" name="active" value="1">
    <label for="activeon">Hoạt động</label>
    <input type="radio" id="activeoff" name="active" value="0">
    <label for="activeoff">Khoá</label>
    <br>
    <hr>
    <input type="submit" value="Submit">
</form>