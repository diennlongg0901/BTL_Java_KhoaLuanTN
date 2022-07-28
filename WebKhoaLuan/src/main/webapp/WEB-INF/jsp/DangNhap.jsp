<%-- 
    Document   : DangNhap
    Created on : Jul 27, 2022, 9:32:47 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/DangNhap" var="action" />
<form action="${action}" method="post" >
    <div class="form-group">
        <label for="usernameId">
            <spring:message code="user.username" />
        </label>
        <input name="username" id="usernameId"
               class="form-control" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            <spring:message code="user.password" />
        </label>
        <input id="passwordId" name="password"
               class="form-control" type="password" />
    </div>
    <div class="form-group">
        <input type="submit"
               value="<spring:message code="user.login" />"/>
    </div>
</form>
