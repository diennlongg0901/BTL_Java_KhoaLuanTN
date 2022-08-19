<%-- 
    Document   : update
    Created on : Aug 18, 2022, 2:13:05 PM
    Author     : PC
--%>

<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Update người dùng</h1>
<!DOCTYPE html>
<div class="container">
    
    <c:form method="post" modelAttribute="nguoidung"
            action="/update">
        <table border="0" cellpadding="2" cellspacing="2">

            <tr>
                <td>Name</td>
                <td><c:input path="username"/>

                </td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td>
                    <c:input path="diachi"/>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <c:input path="email"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value="Save"/>
                </td>
            </tr>

        </table>
    </c:form>
</div>