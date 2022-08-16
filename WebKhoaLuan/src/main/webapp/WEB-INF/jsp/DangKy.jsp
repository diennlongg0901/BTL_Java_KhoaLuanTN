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
<c:url value="/quantri/DKBoSung" var="action1" />
<div class="container">
    <h2 class="text-center mt-5">ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG</h2>
    <div class="form-group container">
        <h4 class="mt-4">Thông tin chung  tài khoản người dùng:</h4>
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
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo tài khoản người dùng"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>

        <h4 class="mt-4" id="title"></h4>
        <form:form method="post" action="${action1}" modelAttribute="sinhvien" >
            <div class="form-outline mt-4">
                <label class="form-label sinhVien" for="khoa" hidden="hidden" >Khoa</label>
                <select class="sinhVien" id="khoa" hidden="hidden">
                    <c:forEach items="${khoa}" var="k">
                        <option value="${k.maKhoa}" >${k.tenKhoa}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label sinhVien" for="nganh" hidden="hidden" >Ngành</label>
                <form:select class="sinhVien" id="nganh" path="nganh" hidden="hidden">
                    <c:forEach items="${nganh}" var="n">
                        <form:option value="${n.nganhPK.maNganh}" >${n.tenNganh}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4 sinhVien" hidden="hidden" value="Xác nhận"/>
                <input type="reset" class="btn btn-primary btn-block mb-4 sinhVien" hidden="hidden" value="Hủy"/>
            </div>
        </form:form>

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
        const gv = document.getElementsByClassName("giangVien");
        const gvu = document.getElementsByClassName("giaoVu");
        const sv = document.getElementsByClassName("sinhVien");
        if (x === "ROLE_SV") {
            document.getElementById("title").innerHTML = "Thông tin dành riêng cho sinh viên: ";
            sv[0].hidden = false;
            sv[1].hidden = false;
            sv[2].hidden = false;
            sv[3].hidden = false;
            sv[4].hidden = false;
            sv[5].hidden = false;
            gv[0].hidden = true;
            gv[1].hidden = true;
            gv[2].hidden = true;
            gv[3].hidden = true;
            gv[4].hidden = true;
            gv[5].hidden = true;
            gvu[0].hidden = true;
            gvu[1].hidden = true;
            gvu[2].hidden = true;
            gvu[3].hidden = true;
        } else if (x === "ROLE_GV") {
            document.getElementById("title").innerHTML = "Thông tin dành riêng cho giảng viên: ";
            sv[0].hidden = true;
            sv[1].hidden = true;
            sv[2].hidden = true;
            sv[3].hidden = true;
            sv[4].hidden = true;
            sv[5].hidden = true;
            gv[0].hidden = false;
            gv[1].hidden = false;
            gv[2].hidden = false;
            gv[3].hidden = false;
            gv[4].hidden = false;
            gv[5].hidden = false;
            gvu[0].hidden = true;
            gvu[1].hidden = true;
            gvu[2].hidden = true;
            gvu[3].hidden = true;
        } else if (x === "ROLE_GVU") {
            document.getElementById("title").innerHTML = "Thông tin dành riêng cho giáo vụ: ";
            sv[0].hidden = true;
            sv[1].hidden = true;
            sv[2].hidden = true;
            sv[3].hidden = true;
            sv[4].hidden = true;
            sv[5].hidden = true;
            gv[0].hidden = true;
            gv[1].hidden = true;
            gv[2].hidden = true;
            gv[3].hidden = true;
            gv[4].hidden = true;
            gv[5].hidden = true;
            gvu[0].hidden = false;
            gvu[1].hidden = false;
            gvu[2].hidden = false;
            gvu[3].hidden = false;
        } else {
            sv[0].hidden = true;
            sv[1].hidden = true;
            sv[2].hidden = true;
            sv[3].hidden = true;
            sv[4].hidden = true;
            sv[5].hidden = true;
            gv[0].hidden = true;
            gv[1].hidden = true;
            gv[2].hidden = true;
            gv[3].hidden = true;
            gv[4].hidden = true;
            gv[5].hidden = true;
            gvu[0].hidden = true;
            gvu[1].hidden = true;
            gvu[2].hidden = true;
            gvu[3].hidden = true;
        }
    }
</script>