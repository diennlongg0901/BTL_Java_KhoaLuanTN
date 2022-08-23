<%--
    Document   : ThongTinNguoiDung
    Created on : Aug 16, 2022, 10:02:55 AM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN GIÁO VỤ</h2>

    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="std" path="sdt" class="form-control" placeholder="Số điện thoại" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Email" />
                </div>
            </div>
            <div class ="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="diaChi" path="diaChi" class="form-control" placeholder="Địa chỉ hiện tại" />
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

            <h4 class="mt-4">Thay đổi mật khẩu</h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="std" path="sdt" class="form-control" placeholder="Mật khẩu mới" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Nhập lại mật khẩu" />
                </div>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật thông tin"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </div>
    </form:form>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN GIẢNG VIÊN</h2>
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
        <h4 class="mt-4">Thông tin cá nhân</h4>
        <div class="form-group container">
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="std" path="sdt" class="form-control" placeholder="Số điện thoại" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Email" />
                </div>
            </div>
            <div class ="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="diaChi" path="diaChi" class="form-control" placeholder="Địa chỉ hiện tại" />
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
            <h4>Thay đổi mật khẩu</h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="std" path="sdt" class="form-control" placeholder="Mật khẩu mới" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Nhập lại mật khẩu" />
                </div>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật thông tin"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </div>
    </form:form>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN SINH VIÊN</h2>
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" > 
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="std" path="sdt" class="form-control" placeholder="Số điện thoại" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="email" path="email" class="form-control" placeholder="Email" />
                </div>
            </div>
            <div class ="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="diaChi" path="diaChi" class="form-control" placeholder="Địa chỉ hiện tại" />
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
            <h4 class="mt-4">Thay đổi mật khẩu</h4>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="password" path="password" class="form-control" placeholder="Mật khẩu mới" />
                </div>

                <div class="form-outline mt-4 col">
                    <form:input type="text" id="con-password" path="confirmPassword" class="form-control" placeholder="Nhập lại mật khẩu" />
                </div>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật thông tin"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </div>
    </form:form>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_QT')}">
    <h2 class="text-center mt-5">CẬP NHẬT THÔNG TIN TÀI KHOẢN</h2>
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
        <div class="form-group container">
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
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Cập nhật tài khoản người dùng"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>

        <form:form method="post" action="${action}" modelAttribute="sinhvien" >
            <div class="form-outline mt-4">
                <label class="form-label sinhVien" for="khoa" >Khoa</label>
                <form:select class="sinhVien" id="khoa" path="nganh.khoa.maKhoa">
                    <c:forEach items="${khoa}" var="k">
                        <form:option value="${k.maKhoa}" >${k.tenKhoa}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label sinhVien" for="nganh" >Ngành</label>
                <form:select class="sinhVien" id="nganh" path="nganh">
                    <c:forEach items="${nganh}" var="n">
                        <form:option value="${n.nganhPK.maNganh}" >${n.tenNganh}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-outline mt-4 col">
                <form:input type="text" id="nienKhoa" path="nienKhoa" class="form-control" placeholder="Niên khóa" />
            </div>

            <div class="d-flex col mt-4">
                <label class="form-label col-xl-2" for="tinhTrangSV">Tình trạng sinh viên:</label>
                <div class="form-check form-check-inline">
                    <form:radiobutton class="form-check-input" path="tinhTrang" value="1" checked="checked" />
                    <label class="form-check-label" for="chuaTotNghiep">Chưa tốt nghiệp</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton class="form-check-input" path="tinhTrang" value="0" />
                    <label class="form-check-label" for="totNghiep">Đã tốt nghiệp</label>
                </div>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4 sinhVien" value="Cập nhật thông tin riêng"/>
                <input type="reset" class="btn btn-primary btn-block mb-4 sinhVien" value="Hủy"/>
            </div>
        </form:form>    
    </div>
</c:if>

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