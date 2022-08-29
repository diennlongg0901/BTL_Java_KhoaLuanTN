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
        <h6 class="form-outline mt-4"><strong>Đề tài: </strong>${dangkykhoaluan.detai.maDT} - ${dangkykhoaluan.detai.tenDT}</h6>
        <div class="row">
            <div class="col">
                <h6 class="form-outline mt-4"><strong>Sinh viên: </strong>${dangkykhoaluan.dangkykhoaluanPK.maSV} - ${dangkykhoaluan.sinhvien.nguoidung.ho} ${dangkykhoaluan.sinhvien.nguoidung.ten}</h6>
            </div>
            <div class="col">
                <h6 class="form-outline mt-4"><strong>Sinh viên 2: ${dangkykhoaluan.maSV2} - ${sinhvien.ho} ${sinhvien.ten}</strong></h6>
            </div>
        </div>
        <h6 class="form-outline mt-4"><strong>Thời hạn: </strong>${dangkykhoaluan.detai.hanNop}</h6>
        <hr>
        <h4 class="mt-4">PHÂN CÔNG GIẢNG VIÊN HƯỚNG DẪN</h4>
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="khoaluan">
            <div class="form-outline mt-4" >
                <label class="form-label">Chọn mã giảng viên hướng dẫn:</label>
                <form:select id="vaiTro" path="maGV">
                    <form:option value="GV000" >Giảng viên</form:option>
                    <c:forEach items="${giangvien}" var="gv">
                        <form:option path="maGV" value="${gv.giangvienPK.maGV}" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</form:option>
                    </c:forEach>
                </form:select>
                        
                <label class="form-label">Chọn mã giảng viên hướng dẫn 2:</label>
                <form:select id="vaiTro" path="maGV2">
                    <form:option value="GV000" >Giảng viên</form:option>
                    <c:forEach items="${giangvien}" var="gv">
                        <form:option value="${gv.giangvienPK.maGV}" path="maGV2" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</form:option>
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