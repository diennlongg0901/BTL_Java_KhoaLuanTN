<%-- 
    Document   : update
    Created on : Aug 18, 2022, 2:13:05 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<h2 class="text-center mt-5"><strong>CẬP NHẬT THÔNG TIN TÀI KHOẢN</strong></h2>
<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
    <div class="form-group container">
        <!-- NHẬP THÔNG TIN CHUNG CHO TÀI KHOẢN NGƯỜI DÙNG -->
        <h4 class="mt-4">Phần thông tin chung</h4>
        <div class="row">
            <div class="form-outline mt-4 col">
                <form:input type="text" id="ho" path="ho" class="form-control" placeholder="Họ" />
            </div>
            <div class="form-outline mt-4 col">
                <form:input type="text" id="ten" path="ten" class="form-control" placeholder="Tên" />
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
        <div class="d-flex col mt-4">
            <label class="form-label col-xl-2" for="tinhTrang">Tình trạng tài khoản:</label>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" path="hoatDong" value="1" checked="checked" />
                <label class="form-check-label" for="hoatDong">Hoạt động</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" path="hoatDong" value="0" />
                <label class="form-check-label" for="khongHoatDong">Không hoạt động</label>
            </div>
        </div>

        <!-- NHẬP THÔNG TIN RIÊNG CỦA TỪNG TÀI KHOẢN NGƯỜI DÙNG -->
        <h4 class="mt-4">Phần thông tin riêng</h4>
        <h6 class="mt-4"><img src="${pageContext.servletContext.contextPath}/picture/person.svg" alt="TruongDaiHocAA" class="icon-seal-small"/> Sinh viên</h6>
        <div class="form-outline mt-4">
            <label class="form-label sinhVien" for="khoa" >Khoa </label>
            <form:select class="sinhVien" id="khoa" path="khoa">
                <c:forEach items="${khoa}" var="k">
                    <form:option value="${k.maKhoa}" >${k.maKhoa} - ${k.tenKhoa}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-outline mt-4">
            <label class="form-label sinhVien" for="nganh" >Ngành </label>
            <form:select class="sinhVien" id="nganh" path="nganh">
                <c:forEach items="${nganh}" var="n">
                    <form:option value="${n.nganhPK.maNganh}" >${n.nganhPK.maNganh} - ${n.tenNganh}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-outline mt-4 col">
            <form:input type="text" id="nienKhoa" path="nienKhoa" class="form-control" placeholder="Niên khóa" />
        </div>
        <div class="d-flex col mt-4">
            <label class="form-label col-xl-2" for="tinhTrangSV">Tình trạng sinh viên:</label>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" path="tinhTrang" value="0" />
                <label class="form-check-label" for="totNghiep">Đã tốt nghiệp</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" path="tinhTrang" value="1" checked="checked" />
                <label class="form-check-label" for="chuaTotNghiep">Chưa tốt nghiệp</label>
            </div>
        </div>
        <h6 class="mt-4"><img src="${pageContext.servletContext.contextPath}/picture/person.svg" alt="TruongDaiHocAA" class="icon-seal-small"/> Giảng viên</h6>
        <div class="form-outline mt-4">
            <form:input type="text" id="hocVi" path="hocVi" class="form-control giangVien" placeholder="Học vị giảng viên"/>
        </div>
        <div class="form-outline mt-4">
            <form:input type="text" id="hocHam" path="hocHam" class="form-control giangVien" placeholder="Học hàm giảng viên"/>
        </div>
        <h6 class="mt-4"><img src="${pageContext.servletContext.contextPath}/picture/person.svg" alt="TruongDaiHocAA" class="icon-seal-small"/> Giáo vụ</h6>
        <div class="form-outline">
            <form:input type="text" id="phongBan" path="phongBan" class="form-control giaoVu" placeholder="Phòng ban giáo vụ" />
        </div>

        <div class="form-outline mt-4">
            <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật"/>
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
