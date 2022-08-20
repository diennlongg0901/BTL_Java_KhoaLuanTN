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
        <h3>Tạo hội đồng</h3>
        <div class="form-group container">
            <form:form method="post" action="${action}" modelAttribute="hoidong" >
                <div class="form-outline mt-4">
                    <label class="form-label">Tên hội đồng</label>
                    <form:input type="text" class="form-control" path="tenHD"/>
                </div>

                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo mới hội đồng" />
                </div>
            </form:form>

            <form:form method="post" action="${action}" modelAttribute="chitiethoidong" >
                <div class="form-outline mt-4">
                    <label class="form-label">Thành viên hội đồng</label>
                    <form:select id="vaiTro" path="chitiethoidongPK.giangvienmaGV">
                        <c:forEach items="${giangvien}" var="gv">
                            <form:option value="${gv.giangvienPK.maGV}" path="giangvienmaGV" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="form-outline mt-4">
                    <label class="form-label">Mã thư ký</label>
                    <form:select id="vaiTro" path="vaiTro" >
                        <form:option value="Chu tich" >Chủ tịch</form:option>
                        <form:option value="Thu ky" >Thư ký</form:option>
                        <form:option value="Phan bien" >Phản biện</form:option>
                        <form:option value="Thanh vien 1" >Thành viên 1</form:option>
                        <form:option value="Thanh vien 2" >Thành viên 2</form:option>                      
                    </form:select>
                </div>
                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Thêm thành viên hội đồng" />
                </div>
            </form:form>
        </div>
    </c:if>
    <h3>Thông tin danh sách hội đồng</h3>
    <div class="form-outline mt-4">
        <form action="" >
            <div class="form-outline mt-4">
                <label class="form-label">Nhập mã hội đồng</label>
                <input type="number" class="form-control" name="id"/>
                <input type="submit" class="btn btn-primary btn-block mb-4 mt-4" value="Tìm hội đồng"/>
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
                            <td>${hd.chitiethoidongPK.hoidongmaHD}</td>
                            <td>${hd.hoidong.tenHD}</td>
                            <td>${hd.chitiethoidongPK.giangvienmaGV}</td>
                            <td>${hd.giangvien.nguoidung.ho} ${hd.giangvien.nguoidung.ten}</td>
                            <td>${hd.vaiTro}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
    </div>
</div>