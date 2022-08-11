<%-- 
    Document   : DangKy
    Created on : Aug 10, 2022, 10:33:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/quantri/DangKy" var="action" />
<div class="container">
    <h2 class="text-center mt-5">ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG</h2>
    <div class="form-group container">
        <form:form method="post" action="${action}" modelAttribute="nguoidung" >

            <div class="form-outline mt-4">
                <label class="form-label" for="vaiTro">Vai trò người dùng</label>
                <form:select id="vaiTro" path="chucvu" onchange="chonCV()">
                    <c:forEach items="${chucvu}" var="c">
                        <form:option value="${c.maChucVu}" path="chucvu" >${c.tenChucVu}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="ho">Họ</label>
                <form:input type="text" id="ho" path="ho" class="form-control" />
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="ten">Tên</label>
                <form:input type="text" id="ten" path="ten" class="form-control" />
            </div>

            <label class="form-label mt-4" for="gioiTinh">Giới tính</label>
            <div class="d-flex">
                <div class="form-check form-check-inline">
                    <form:radiobutton class="form-check-input" path="gioiTinh" value="nam" checked="checked" />
                    <label class="form-check-label" for="nam">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton class="form-check-input" path="gioiTinh" value="nữ" />
                    <label class="form-check-label" for="nu">Nữ</label>
                </div>
            </div>

            <label for="date" class="col-1 col-form-label mt-4">Ngày sinh</label>
            <div class="col-5">
                <div class="input-group date" id="datepicker">
                    <form:input type="text" class="form-control" id="ngaySinh" path="ngaySinh"/>
                    <span class="input-group-append">
                        <span class="input-group-text bg-light d-block">
                            <i class="fa fa-calendar"></i>
                        </span>
                    </span>
                </div>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="username">Username</label>
                <form:input type="text" id="username" path="username" class="form-control" />
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>

        <hr>
        <p id="demo"></p>

        <div class="form-outline mt-4">
            <label class="form-label" id="labelNganh" for="nganh" hidden="hidden" >Ngành</label>
            <select id="nganh" hidden="hidden">
                <c:forEach items="${nganh}" var="n">
                    <option value="${n.nganhPK.maNganh}" >${n.tenNganh}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-outline mt-4">
            <label class="form-label" id="labelKhoa" for="khoa" hidden="hidden" >Khoa</label>
            <select id="khoa" hidden="hidden">
                <c:forEach items="${khoa}" var="k">
                    <option value="${k.maKhoa}" >${k.tenKhoa}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-outline mt-4">
            <label class="form-label" id="labelHocVi" for="hocVi" hidden="hidden" >Học vị</label>
            <input type="text" id="hocVi" class="form-control" hidden="hidden"/>
        </div>

        <div class="form-outline mt-4">
            <label class="form-label" id="labelHocHam" for="hocHam" hidden="hidden" >Học hàm</label>
            <input type="text" id="hocHam" class="form-control" hidden="hidden"/>
        </div>

        <div class="form-outline mt-4">
            <label class="form-label" id="labelPhongBan" for="phongBan" hidden="hidden" >Phòng ban</label>
            <input type="text" id="phongBan" class="form-control" hidden="hidden"/>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#datepicker').datepicker();
    });
</script>

<script type="text/javascript">
    function chonCV() {
        var x = document.getElementById("vaiTro").value;

        if (x === "ROLE_SV") {
            document.getElementById("demo").innerHTML = "Thông tin dành riêng cho sinh viên: ";
            document.getElementById("labelNganh").hidden = false;
            document.getElementById("nganh").hidden = false;
            document.getElementById("labelKhoa").hidden = false;
            document.getElementById("khoa").hidden = false;
            document.getElementById("labelHocVi").hidden = true;
            document.getElementById("hocVi").hidden = true;
            document.getElementById("labelHocHam").hidden = true;
            document.getElementById("hocHam").hidden = true;
            document.getElementById("labelPhongBan").hidden = true;
            document.getElementById("phongBan").hidden = true;
        } else if (x === "ROLE_GV") {
            document.getElementById("demo").innerHTML = "Thông tin dành riêng cho giảng viên: ";
            document.getElementById("labelNganh").hidden = true;
            document.getElementById("nganh").hidden = true;
            document.getElementById("labelKhoa").hidden = true;
            document.getElementById("khoa").hidden = true;
            document.getElementById("labelHocVi").hidden = false;
            document.getElementById("hocVi").hidden = false;
            document.getElementById("labelHocHam").hidden = false;
            document.getElementById("hocHam").hidden = false;
            document.getElementById("labelPhongBan").hidden = true;
            document.getElementById("phongBan").hidden = true;
        } else if (x === "ROLE_GVU") {
            document.getElementById("demo").innerHTML = "Thông tin dành riêng cho giáo vụ: ";
            document.getElementById("labelNganh").hidden = true;
            document.getElementById("nganh").hidden = true;
            document.getElementById("labelKhoa").hidden = true;
            document.getElementById("khoa").hidden = true;
            document.getElementById("labelHocVi").hidden = true;
            document.getElementById("hocVi").hidden = true;
            document.getElementById("labelHocHam").hidden = true;
            document.getElementById("hocHam").hidden = true;
            document.getElementById("labelPhongBan").hidden = false;
            document.getElementById("phongBan").hidden = false;
        }
    }
</script>
