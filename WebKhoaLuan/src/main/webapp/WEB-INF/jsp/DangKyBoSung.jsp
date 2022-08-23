<%-- 
    Document   : DangKyBoSung
    Created on : Aug 12, 2022, 4:05:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h4 class="mt-4" id="title"></h4>
<div class="form-outline mt-4">
    <label class="form-label" for="vaiTro">Vai trò người dùng</label>
    <select id="vaiTro" onchange="chonCV()">
        <c:forEach items="${chucvu}" var="c">
            <option value="${c.maChucVu}" >${c.tenChucVu}</option>
        </c:forEach>
    </select>
</div>
<form:form method="post" action="${action}" modelAttribute="sinhvien" >

    <div class="form-outline mt-4">
        <label class="form-label" for="username">Username</label>
    </div>

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

<form:form method="post" action="${action}" modelAttribute="giangvien">
                <div class="form-outline mt-4">
                    <label class="form-label giangVien" for="hocVi" hidden="hidden" >Học vị</label>
                    <input type="text" id="hocVi" class="form-control giangVien" hidden="hidden"/>
                </div>

                <div class="form-outline mt-4">
                    <label class="form-label giangVien" for="hocHam" hidden="hidden" >Học hàm</label>
                    <input type="text" id="hocHam" class="form-control giangVien" hidden="hidden"/>
                </div>

                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4 giangVien" hidden="hidden" value="Xác nhận"/>
                    <input type="reset" class="btn btn-primary btn-block mb-4 giangVien" hidden="hidden" value="Hủy"/>
                </div>
</form:form>

<form:form method="post" action="${action}" modelAttribute="giaovu">
                <div class="form-outline mt-4">
                    <label class="form-label giaoVu" for="phongBan" hidden="hidden" >Phòng ban</label>
                    <input type="text" id="phongBan" class="form-control giaoVu" hidden="hidden"/>
                </div>

                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4 giaoVu" hidden="hidden" value="Xác nhận"/>
                    <input type="reset" class="btn btn-primary btn-block mb-4 giaoVu" hidden="hidden" value="Hủy"/>
                </div>
</form:form>

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