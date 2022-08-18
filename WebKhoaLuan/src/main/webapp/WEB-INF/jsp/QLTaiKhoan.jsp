<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<script type="text/javascript" src="main.js" ></script>-->

<h2 class="text-center mt-5">QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG</h2>
<c:url value="/quantri/QLTaiKhoan" var="action" />
<div class="container">
    <div class="form-outline mb-4">
        <label class="form-label" for="vaiTro">Vai trò người dùng</label>
        <select id="vaiTro" name="vaiTro">
            <c:forEach items="${chucvu}" var="c">
                <option value="${c.maChucVu}">${c.tenChucVu}</option>
            </c:forEach>
        </select>
    </div>
    <c:if test="${message != null}">
        <div class ="alert alert-danger">
            ${message}
        </div>
    </c:if>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ</th>
                <th scope="col">Tên</th>
                <th scope="col">G.Tính</th>
                <th scope="col">N.Sinh</th>
                <th scope="col">Đ.Chỉ</th>
                <th scope="col">Email</th>
                <th scope="col">SĐT</th>
                <th scope="col">Username</th>
                <th scope="col">H.Động</th>
                <th scope="col">C.Vụ</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${nguoidung}" var="nd">
                <tr>
                    <td>${nd.nguoidungPK.maND}</td>
                    <td>${nd.ho}</td>
                    <td>${nd.ten}</td>
                    <td>${nd.gioiTinh}</td>
                    <td>${nd.ngaySinh}</td>
                    <td>${nd.diaChi}</td>
                    <td>${nd.email}</td>
                    <td>${nd.sdt}</td>
                    <td>${nd.username}</td>
                    <td>${nd.hoatDong}</td>
                    <td>${nd.chucvu.tenChucVu}</td>
                    <td><a href=" <c:url value="/quantri/QLTaiKhoan/${nd.nguoidungPK.maND}" />"> Xóa </a></td>
                    <td><a href="<c:url value='/update/${nd.username}' />" >Sửa</a></td>
<!--                        <input href="/quantri/QLKhoaLuan/delete + ${nd.nguoidungPK.maND}" type="submit" class="btn btn-primary btn-block mb-4" value="Xóa tài khoản"/>
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật"/>-->
                    
                </tr>
            </c:forEach>
<!--            <form action="${action}" >
                <td >
                        <form action="${action}{}"  method="delele"><input type="submit" value="Delete"/></form>
                    
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật tài khoản"/>
                </td>
            </form>-->
        </tbody>

    </table>

    <!--    <hr>
    
        <div class="mt-4">
            
        </div>-->
</div>
<!--<script src="<c:url value="/static/main.js" />"></script>
<script>

                        var modal = document.getElementById(${nd.nguoidungPK.maND});


                        window.onclick = function (event) {
                            if (event.target == modal) {
                                modal.style.display = "none";
                            }
                        }
</script>-->
<%--<form:form method="post" action="" modelAttribute="nguoidung" enctype="multipart/form-data" > 
    <div class="form-group">
        <label for="file">Ảnh đại diện</label>
        <form:input type="file" path="file" id="image" cssClass="form-control" />
    </div>
        
    <div class="form-group">
        <input type="submit" value="Thêm tài khoản người dùng" class="btn btn-danger" />
    </div>
</form:form>--%>