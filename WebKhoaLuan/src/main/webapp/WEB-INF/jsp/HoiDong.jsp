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
        <h4 class="mt-5">Thêm mới hội đồng</h4>
        <div class="form-group container">
            <form:form method="post" action="${action}" modelAttribute="hoidong" >
                <div class="row">
                    <div class="form-outline mt-4 col-md-9">
                        <form:input type="text" class="form-control" path="tenHD" placeholder="Tên hội đồng" />
                    </div>

                    <div class="form-outline mt-4 col-md-3">
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo mới hội đồng" />
                    </div>
                </div>
            </form:form>

            <form:form method="post" action="${action}" modelAttribute="chitiethoidong" >
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
        <hr class="mt-5">
    </c:if>

    <h4>Thông tin danh sách hội đồng</h4>
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
        <table class="table">
            <thead>
                <tr>
                    <th>Mã số hội đồng</th>
                    <th>Tên hội đồng</th>
                    <th>Mã giảng viên</th>
                    <th>Họ tên giảng viên</th>
                    <th>Vai trò</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dschitiethoidong}" var="hd">
                    <tr>
                        <td>${hd.chitiethoidongPK.maHD}</td>
                        <td>${hd.hoidong.tenHD}</td>
                        <td>${hd.chitiethoidongPK.maGV}</td>
                        <td>${hd.giangvien.nguoidung.ho} ${hd.giangvien.nguoidung.ten}</td>
                        <td>${hd.vaiTro}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>