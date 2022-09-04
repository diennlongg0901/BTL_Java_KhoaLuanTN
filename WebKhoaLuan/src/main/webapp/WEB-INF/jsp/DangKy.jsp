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
    <h2 class="text-center mt-5"><strong>ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG</strong></h2>
    <div class="form-group container">
        <!-- NHẬP THÔNG TIN CHUNG CỦA TÀI KHOẢN NGƯỜI DÙNG -->
        <h4 class="mt-4">Thông tin chung  tài khoản người dùng:</h4>
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
            <div class="form-outline mt-4">
                <label class="form-label" for="vaiTro">Chức vụ người dùng</label>
                <form:select id="vaiTro" path="chucvu" onchange="chonChucVu()">
                    <form:option value="">Chức vụ</form:option>
                    <c:forEach items="${chucvu}" var="c">
                        <form:option value="${c.maCV}" >${c.tenCV}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="ho" path="ho" class="form-control" placeholder="Họ" />
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="ten" path="ten" class="form-control" placeholder="Tên" />
                </div>
            </div>               
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Email" />
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="diaChi" path="diaChi" class="form-control" placeholder="Địa chỉ" />
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="sdt" path="sdt" class="form-control" placeholder="Số điện thoại" />
                </div>
            </div>                
            <div class ="row">
                <div class="form-outline mt-4 col">                    
                    <form:input type="text" id="username" path="username" class="form-control" placeholder="Username" />
                </div>

                <div class="col mt-4">
                    <div class="input-group date" id="datepicker">
                        <form:input type="text" class="form-control" id="ngaySinh" path="ngaySinh" placeholder="Ngày sinh" />
                        <span class="input-group-append">
                            <span class="input-group-text bg-light d-block">
                                <i class="fa fa-calendar"></i>
                            </span>
                        </span>
                    </div>
                </div>
            </div>
            <div class ="row">
                <div class="d-flex col mt-4">
                    <label class="form-label col-xl-2" for="gioiTinh">Giới tính:</label>
                    <div class="form-check form-check-inline">
                        <form:radiobutton class="form-check-input" path="gioiTinh" value="Nam" checked="checked" />
                        <label class="form-check-label" for="nam">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:radiobutton class="form-check-input" path="gioiTinh" value="Nữ" />
                        <label class="form-check-label" for="nu">Nữ</label>
                    </div>
                </div>
                <div class="col mt-4">   
                    <form:input type="file" id="anh" path="file" class="form-control"  />
                </div>
            </div>

            <!-- NHẬP THÔNG TIN RIÊNG CHO TỪNG TÀI KHOẢN NGƯỜI DÙNG -->
            <h4 id="title" class="mt-4 "></h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <label class="form-label sinhVien" for="khoa" hidden="hidden">Khoa</label>
                    <select id="khoa" class="sinhVien" hidden="hidden">
                        <c:forEach items="${khoa}" var="k">
                            <option value="${k.maKhoa}" >${k.maKhoa} - ${k.tenKhoa}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="makhoa" path="khoaDK" class="form-control sinhVien" hidden="hidden" placeholder="Mã khoa sinh viên" />
                </div>
            </div>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <label class="form-label sinhVien" for="nganh" hidden="hidden">Ngành</label>
                    <select id="nganh" class="sinhVien" hidden="hidden">
                        <c:forEach items="${nganh}" var="n">
                            <option value="${n.nganhPK.maNganh}">${n.nganhPK.maNganh} - ${n.tenNganh}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="maNganh" path="nganhDK" class="form-control sinhVien" hidden="hidden" placeholder="Mã ngành sinh viên" />
                </div>
            </div>
        </div>
        <div class="form-outline">
            <form:input type="text" id="hocVi" path="hocVi" class="form-control giangVien" hidden="hidden" placeholder="Học vị giảng viên" />
            <form:input type="text" id="hocHam" path="hocHam" class="form-control mt-4 giangVien" hidden="hidden" placeholder="Học hàm giảng viên" />
            <form:input type="text" id="phongBan" path="phongBan" class="form-control giaoVu" hidden="hidden" placeholder="Phòng ban giáo vụ" />
        </div>
        
        <div class="form-outline mt-4">
            <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo tài khoản người dùng"/>
            <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
        </div>
    </form:form>
</div>

<!-- XỬ LÝ CHỌN NGÀY THÁNG NĂM -->
<script type="text/javascript">
    $(function () {
        $('#datepicker').datepicker();
    });
</script>

<!-- XỬ LÝ ẨN HIỆN PHẦN THÔNG TIN RIÊNG TÀI KHOẢN NGƯỜI DÙNG -->
<script type="text/javascript">
    function chonChucVu() {
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
            gvu[0].hidden = true;
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
            gvu[0].hidden = true;
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
            gvu[0].hidden = false;
        } else {
            sv[0].hidden = true;
            sv[1].hidden = true;
            sv[2].hidden = true;
            sv[3].hidden = true;
            sv[4].hidden = true;
            sv[5].hidden = true;
            gv[0].hidden = true;
            gv[1].hidden = true;
            gvu[0].hidden = true;
        }
    }
</script>