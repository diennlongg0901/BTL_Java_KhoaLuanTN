<%--
    Document   : HoiDong
    Created on : Aug 16, 2022, 10:33:27 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<h2 class="text-center mt-5"><strong>THÔNG TIN HỘI ĐỒNG</strong></h2>
<c:url value="/giaovu/HoiDong" var="action"/>
<div class="container">
    <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
        <!-- PHẦN GIÁO VỤ THÊM MỚI HỘI ĐỒNG -->
        <h4 class="mt-4">Thêm mới hội đồng</h4>
        <div class="form-group container">
            <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="hoidong" >
                <div class="row">
                    <div class="form-outline mt-4 col-md-9">
                        <form:input type="text" class="form-control" path="tenHD" placeholder="Tên hội đồng" />
                    </div>
                    <div class="form-outline mt-4 col-md-3">
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo mới hội đồng" />
                    </div>
                </div>
            </form:form>

            <!-- PHẦN GIÁO VỤ THÊM THÀNH VIÊN VÀO HỘI ĐỒNG MỚI TẠO-->
            <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="chitiethoidong" >
                <div class="row">
                    <div class="form-outline mt-4 col-md-5">
                        <label class="form-label">Thành viên hội đồng</label>
                        <form:select id="vaiTro" path="chitiethoidongPK.maGV">
                            <c:forEach items="${giangvien}" var="gv">
                                <form:option value="${gv.giangvienPK.maGV}" path="maGV" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-outline mt-4 col-md-4">
                        <label class="form-label">Vai trò trong hội đồng</label>
                        <form:select id="vaiTro" path="vaiTro" >
                            <form:option value="Chủ tịch" >Chủ tịch</form:option>
                            <form:option value="Thư ký" >Thư ký</form:option>
                            <form:option value="Phản biện" >Phản biện</form:option>
                            <form:option value="Thành viên 1" >Thành viên 1</form:option>
                            <form:option value="Thành viên 2" >Thành viên 2</form:option>
                        </form:select>
                    </div>
                    <div class="form-outline mt-4 col-md-3">
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Thêm thành viên hội đồng" />
                    </div>
                </div>
            </form:form>

            <!-- PHẦN GIÁO VỤ XEM DANH SÁCH HỘI ĐỒNG -->
            <hr class="mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Hội đồng</th>
                        <th>Giảng viên</th>
                        <th>Vai trò</th>
                        <th>Khóa hội đồng</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dschitiethoidong}" var="cthd">
                        <tr>
                            <td>${cthd.chitiethoidongPK.maHD}.${cthd.hoidong.tenHD}</td>
                            <td>${cthd.chitiethoidongPK.maGV} - ${cthd.giangvien.nguoidung.ho} ${cthd.giangvien.nguoidung.ten}</td>
                            <td>${cthd.vaiTro}</td>
                            <td><a href=" <c:url value="/giaovu/Hoidong/${cthd.chitiethoidongPK.maHD}" />">Khóa hội đồng</a></td>                                
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
        <!-- PHẦN GIẢNG VIÊN TÌM HỘI ĐỒNG CÓ THAM GIA -->
        <h4 class="mt-4">Danh sách hội đồng giảng viên tham gia</h4>
        <div class="form-outline mt-4">
            <form action="" >
                <div class="row">
                    <div class="form-outline col-md-9">
                        <input type="text" class="form-control" name="tenHD" placeholder="Nhập mã hội đồng"/>
                    </div>
                    <div class="form-outline col-md-3">
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Tìm hội đồng"/>
                    </div>
                </div>
            </form>

            <!-- PHẦN GIẢNG VIÊN XEM HỘI ĐỒNG CÓ THAM GIA -->
            <hr class="mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Hội đồng</th>
                        <th>Giảng viên</th>
                        <th>Vai trò</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${hoidonggv}" var="hdgv">
                        <tr>
                            <td>${hdgv.chitiethoidongPK.maHD}.${hdgv.hoidong.tenHD}</td>
                            <td>${hdgv.chitiethoidongPK.maGV} - ${hdgv.giangvien.nguoidung.ho} ${hdgv.giangvien.nguoidung.ten}</td>
                            <td>${hdgv.vaiTro}</td>
                            <td><a href=" <c:url value="/giangvien/KhoaLuanHD/${hdgv.chitiethoidongPK.maHD}" />">Danh sách khóa luận</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </c:if>
</div>
