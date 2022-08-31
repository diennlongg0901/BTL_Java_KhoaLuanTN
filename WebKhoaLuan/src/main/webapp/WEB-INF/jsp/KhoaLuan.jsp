<%-- 
    Document   : SinhVien
    Created on : Aug 8, 2022, 9:01:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/sinhvien/KhoaLuan/${pageContext.request.userPrincipal.name}" var="action" />
<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5">NỘP KHÓA LUẬN TỐT NGHIỆP</h2>
    <div class="container mt-5">
        <div class="form-group container">
            <form:form method="post" action="${action}"  modelAttribute="khoaluan" >
                <form:textarea class="form-control" path="ghiChu" placeholder="Nội dung chi tiết đề tài khóa luận"></form:textarea>  
                    <div class="form-outline mt-4">
                        <label class="form-label">Nộp bài khóa luận</label>
                        <form:input type="file" id="file" path="file" class="form-control"  />
                    </div>
                    <div class="form-outline mt-4">
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Nộp khóa luận"/>
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Hủy"/>
                    </div>           
            </form:form>   
        </div>
    </div>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
    <h2 class="text-center mt-5">DANH SÁCH KHÓA LUẬN TỐT NGHIỆP CỦA GIẢNG VIÊN HƯỚNG DẪN</h2>
    <table class="table mt-4">
        <thead>
            <tr>
                <th scope="col">Sinh viên</th>
                <th scope="col">Email</th>
                <th scope="col">SĐT</th>
                <th scope="col">Giảng viên HD 2</th>
                <th scope="col">Đề tài</th>
                <th scope="col">Bài nộp</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${dskhoaluanGV}" var="kl">
                <tr>
                    <td>${kl.dangkykhoaluan.dangkykhoaluanPK.maSV} - ${kl.dangkykhoaluan.sinhvien.nguoidung.ho} ${kl.dangkykhoaluan.sinhvien.nguoidung.ten}</td>
                    <td>${kl.dangkykhoaluan.sinhvien.nguoidung.email}</td>
                    <td>${kl.dangkykhoaluan.sinhvien.nguoidung.sdt}</td>
                    <td>${kl.maGV2} - </td>
                    <td>${kl.dangkykhoaluan.detai.maDT}.${kl.dangkykhoaluan.detai.tenDT}</td>
                    <td>${kl.file}</td>
                    <td><a href=" <c:url value="/giangvien/ChamDiem/${kl.maKL}" />">Chấm điểm</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
