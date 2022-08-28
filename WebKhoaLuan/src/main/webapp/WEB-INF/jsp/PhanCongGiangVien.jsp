<%-- 
    Document   : GiangVien
    Created on : Aug 9, 2022, 8:11:42 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<div class="container">
    <h2 class="text-center mt-5">XÉT DUYỆT & PHÂN CÔNG GIẢNG VIÊN HƯỚNG DẪN CHO KHÓA LUẬN</h2>
    <div class="form-group container">
        <h4 class="mt-5">THÔNG TIN CHI TIẾT VỀ KHÓA LUẬN</h4>
        <hr>
        <h4 class="mt-4">PHÂN CÔNG GIẢNG VIÊN HƯỚNG DẪN</h4>
        <form:form method="post" action="${action}" modelAttribute="khoaluan">
            <div class="form-outline mt-4">
                <label class="form-label">Chọn mã giảng viên hướng dẫn</label>
                <form:select id="vaiTro" path="maGV">
                    <c:forEach items="${giangvien}" var="gv">
                        <form:option value="${gv.giangvienPK.maGV}" path="maGV" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Xác nhận"/>
                <a href="/giaovu/dsDangKyKhoaLuan">
                    <input type="button" class="btn btn-primary btn-block mb-4" value="Trở về"/>
                </a>
            </div>
        </form:form>
    </div>
</div>