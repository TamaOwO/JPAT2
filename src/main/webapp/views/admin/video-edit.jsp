<%--
  Created by IntelliJ IDEA.
  User: Tama OwO
  Date: 10/8/2024
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp" %>

< action="${pageContext.request.contextPath}/admin/video/update" method="post" enctype="multipart/form-data">
    <input type="text" id="videoid" name="videoid" hidden="hidden" value="${video.videoid}"><br>

    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title" value="${video.title}"><br>

    <label for="poster">Images:</label><br>
    <input type="text" id="poster" name="poster"><br>

    <label for="poster1">Upload File:</label><br>
    <input type="file" id="poster1" name="poster1" onchange ="chooseFile(this)"><br>

    <c:if test="${video.poster.substring(0,5)=='https'}">
        <c:url value="${video.poster}" var="imgUrl"></c:url>
    </c:if>

    <c:if test="${video.poster.substring(0,5)!='https'}">
        <c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
    </c:if>

    <img id = "imagess" height="150" width="200" src="${imgUrl}"/>

    <label for="poster1">Choose Category:</label><br>
    <select name="categoryid" id="categoryid">
        <c:forEach items="${listcate}" var="cate">
            <option value =${cate.categoryid}>${cate.categoryname}</option>
        </c:forEach>
    </select><br>

    <label for="action">Status:</label><br>

    <input type="radio" id="actionon" name="action" value="1" ${video.action==1?'checked':''}>
    <label for="action">Hoạt động</label><br>

    <input type="radio" id="actionoff" name="action" value="0" ${video.action==0?'checked':''}>
    <label for="action">Khoá</label>

    <input type="text" id="description" name="description" value= "${video.action==0?'checked':''}"><br>
    <label for="description">Description:</label><br>

    <input type="submit" value="Insert">
</form>
