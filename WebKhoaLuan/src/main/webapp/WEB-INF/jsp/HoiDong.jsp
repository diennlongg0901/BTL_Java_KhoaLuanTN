<%--
    Document   : HoiDong
    Created on : Aug 16, 2022, 10:33:27 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center mt-5">THÔNG TIN HỘI ĐỒNG</h2>
<c:url value="/HoiDong" var="action"/>
<div class="container">
    <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
        <h4 class="mt-4 text-info">Thêm mới hội đồng</h4>
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
        </div>
    </c:if>

    <h4 class="mt-4 text-info">Danh sách hội đồng giảng viên tham gia</h4>
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
                        <td>${hdgv.chitiethoidongPK.maGV} - ${hdgv.giangvien.nguoidung.ho} ${hd.giangvien.nguoidung.ten}</td>
                        <td>${hdgv.vaiTro}</td>
                        <td><a href=" <c:url value="/giangvien/KhoaLuanHD/${hdgv.chitiethoidongPK.maHD}" />">Danh sách khóa luận</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>