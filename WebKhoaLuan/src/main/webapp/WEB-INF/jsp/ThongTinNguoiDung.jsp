<%--
    Document   : ThongTinNguoiDung
    Created on : Aug 16, 2022, 10:02:55 AM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN GIÁO VỤ</h2>
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row mt-5">
                <div class="col-md-3">
                    <img src="${thongtinnguoidung.anh}" alt="alt" class="img-fluid rounded-circle" style="width: 150px;height: 150px;"/>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Họ tên: ${thongtinnguoidung.ho} ${thongtinnguoidung.ten}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Giới tính: ${thongtinnguoidung.gioiTinh}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Ngày sinh: ${thongtinnguoidung.ngaySinh}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Địa chỉ: ${thongtinnguoidung.diaChi}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Email: ${thongtinnguoidung.email}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Số điện thoại: ${thongtinnguoidung.sdt}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr class="mt-5">
        <div class="form-group container">
            <h4 class="mt-4">Cập nhật Thông tin cá nhân</h4>
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
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row mt-5">
                <div class="col-md-3">
                    <img src="${thongtinnguoidung.anh}" alt="alt" class="img-fluid rounded-circle" style="width: 150px;height: 150px;"/>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Họ tên: ${thongtinnguoidung.ho} ${thongtinnguoidung.ten}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Giới tính: ${thongtinnguoidung.gioiTinh}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Ngày sinh: ${thongtinnguoidung.ngaySinh}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Địa chỉ: ${thongtinnguoidung.diaChi}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Email: ${thongtinnguoidung.email}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Số điện thoại: ${thongtinnguoidung.sdt}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr class="mt-5">
        <h4 class="mt-4">Cập nhật Thông tin cá nhân</h4>
        <div class="form-group container">
            <c:if test="${currentUser != null}" >
                <img src="${currentUser.anh}" class="rounded-3" style="width: 150px;"
                     alt="Avatar" />
            </c:if>
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
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung"  >      
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row mt-5">
                <div class="col-md-3">
                    <img src="${thongtinnguoidung.anh}" alt="alt" class="img-fluid rounded-circle" style="width: 150px;height: 150px;"/>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Họ tên: ${thongtinnguoidung.ho} ${thongtinnguoidung.ten}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Giới tính: ${thongtinnguoidung.gioiTinh}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Ngày sinh: ${thongtinnguoidung.ngaySinh}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Địa chỉ: ${thongtinnguoidung.diaChi}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Email: ${thongtinnguoidung.email}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Số điện thoại: ${thongtinnguoidung.sdt}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr class="mt-5">
        <div class="form-group container">
            <h4 class="mt-5">Cập nhật Thông tin cá nhân</h4>
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
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN QUẢN TRỊ</h2>
    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" > 
        <div class="form-group container">
            <h4 class="mt-4">Thông tin cá nhân</h4>
            <div class="row mt-5">
                <div class="col-md-3">
                    <img src="${thongtinnguoidung.anh}" alt="alt" class="img-fluid rounded-circle" style="width: 150px;height: 150px;"/>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Họ tên: ${thongtinnguoidung.ho} ${thongtinnguoidung.ten}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Giới tính: ${thongtinnguoidung.gioiTinh}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Ngày sinh: ${thongtinnguoidung.ngaySinh}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Địa chỉ: ${thongtinnguoidung.diaChi}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h4 class="form-outline mt-4">Email: ${thongtinnguoidung.email}</h4>
                        </div>
                        <div class="col">
                            <h4 class="form-outline mt-4">Số điện thoại: ${thongtinnguoidung.sdt}</h4>
                        </div>
                    </div>
                </div>
                        <hr class="mt-5">
                <h4 class="mt-4">Cập nhật thông tin cá nhân</h4>
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
        </div>
        </form:form>
    </c:if>

    <script type="text/javascript">
        $(function () {
            $('#datepicker').datepicker();
        });
    </script>