<%-- 
    Document   : Diem
    Created on : Aug 16, 2022, 3:19:48 PM
    Author     : ADMIN
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<!-- PHẦN GIẢNG VIÊN CHẤM ĐIỂM KHÓA LUẬN -->
<c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
    <h2 class="text-center mt-5"><strong>CHẤM ĐIỂM KHÓA LUẬN</strong></h2>    
    <div class="container mt-5">
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="diem">
            <div class="form-outline mt-4">
                <form:input type="text" path="maGVHD" placeholder="Mã giảng viên" value="${pageContext.request.userPrincipal.name}"/>
            </div>
            <div class="form-outline mt-4">
                <form:textarea type="text" class="form-control" path="nhanXet" placeholder="Nhận xét bài khóa luận"/>
            </div>       
            <div class="form-outline mt-4">
                <form:input type="number" step="0.05" path="diem" placeholder="Nhập điểm cho khóa luận"/>
            </div>
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Xác nhận"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>
    </div>   
</c:if>

<!-- PHẦN SINH VIÊN XEM ĐIỂM KHÓA LUẬN -->
<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5"><strong>ĐIỂM KHÓA LUẬN</strong></h2>
    <div class="container mt-4">
        <h4 class="mt-4">Thông tin về khóa luận</h4>
        <div class="row">
            <div class="col-md-3">
                <h6 class="form-outline mt-4"><strong>Mã khóa luận: </strong>${khoaluansv.maKL} - ${khoaluansv.nam}</h6>
            </div>
            <div class="col-md-3">
                <h6 class="form-outline mt-4"><strong>Sinh viên: </strong>${khoaluansv.dangkykhoaluan.sinhvien.nguoidung.nguoidungPK.maND} - ${khoaluansv.dangkykhoaluan.sinhvien.nguoidung.ho} ${khoaluansv.dangkykhoaluan.sinhvien.nguoidung.ten}</h6>
            </div>
        </div>
        <div class="row">
            <div class="col-md-7">
                <h6 class="form-outline mt-4"><strong>Đề tài: </strong>${khoaluansv.dangkykhoaluan.detai.maDT}.${khoaluansv.dangkykhoaluan.detai.tenDT}</h6>
            </div>
            <div class="col-md-5">
                <h6 class="form-outline mt-4"><strong>Bài làm - Ngày nộp: </strong>${khoaluansv.file} - ${khoaluansv.ngayNop}</h6>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Giảng viên hướng dẫn: </strong>${khoaluansv.maGV} - ${giangvienhd.ho} ${giangvienhd.ten}</h6>
            </div>
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Giảng viên hướng dẫn 2: </strong>${khoaluansv.maGV2} - ${giangvienhd2.ho} ${giangvienhd2.ten}</h6>
            </div>
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Hội đồng: </strong>${khoaluansv.hoidong.maHD}.${khoaluansv.hoidong.tenHD}</h6>
            </div>
        </div>
        <hr class="mt-4">
        <h4 class="mt-4">Điểm số chi tiết của khóa luận</h4>
        <div class="row">
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Điểm giảng viên hướng dẫn: </strong><fmt:formatNumber value="${diemgvhd}" maxFractionDigits="2" type = "number" /></h6>
            </div>
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Điểm hội đồng: </strong><fmt:formatNumber value="${diemhd}" maxFractionDigits="2" type = "number" /></h6>
            </div>
        </div>
        <hr class="mt-4">
        <h4 class="mt-4">Kết quả bài khóa luận</h4>
        <div class="row">
            <div class="col-md-4">
                <h5 class="form-outline mt-4 text-success"><strong>Điểm khóa luận: </strong><fmt:formatNumber value="${diemkl}" maxFractionDigits="2" type = "number" /></h5>
            </div>
            <div class="col-md-4">
                <h5 class="form-outline mt-4 text-success"><strong>Kết quả: </strong>${ketqua}</h5>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <h6 class="form-outline mt-4"><strong>Nhận xét: </strong></h6>
                <c:forEach items="${nhanxet}" var="nx">
                    - ${nx.nhanXet}<p>
                    </c:forEach>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-outline mt-4">
                <a href="#!">Phúc khảo điểm khóa luận</a>
            </div>
            <div class="col-md-4 form-outline mt-4">
                <a href="/WebKhoaLuan/sinhvien/DiemKL/xls/${pageContext.request.userPrincipal.name}">Xuất file điểm chi tiết (EXCEL)</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-outline"></div>
            <div class="col-md-4 form-outline">
                <a href="/WebKhoaLuan/sinhvien/DiemKL/pdf/${pageContext.request.userPrincipal.name}">Xuất file điểm khóa luận (PDF)</a>
            </div>
        </div>
    </div>
</c:if>