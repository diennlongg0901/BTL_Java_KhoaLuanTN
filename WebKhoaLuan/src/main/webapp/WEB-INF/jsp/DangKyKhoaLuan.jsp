<%-- 
    Document   : DangKyBoSung
    Created on : Aug 12, 2022, 4:05:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<!-- PHẦN GIÁO VỤ XEM DANH SÁCH SINH VIÊN ĐĂNG KÝ KHÓA LUẬN -->
<c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
    <h2 class="text-center mt-5"><strong>DANH SÁCH ĐĂNG KÝ ĐỀ TÀI KHÓA LUẬN</strong></h2>
    <div class="form-group container">
        <div class="form-outline mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Mã sinh viên</th>
                        <th>Họ tên sinh viên</th>
                        <th>Tên đề tài</th>
                        <th>Mã sinh viên 2</th>
                        <th>Thời hạn nộp</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dsdangkykhoaluan}" var="dkkl">
                        <tr>
                            <td>${dkkl.dangkykhoaluanPK.maSV}</td>
                            <td>${dkkl.sinhvien.nguoidung.ho} ${dkkl.sinhvien.nguoidung.ten}</td>
                            <td>${dkkl.detai.tenDT}</td>
                            <td>${dkkl.maSV2}</td>
                            <td>${dkkl.detai.hanNop}</td>
                            <td><a href=" <c:url value="/giaovu/PhanCongGV/${dkkl.dangkykhoaluanPK.maDK}"/>">Xét duyệt</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>

<!-- PHẦN SINH VIÊN ĐĂNG KÝ ĐỀ TÀI LÀM KHÓA LUẬN -->
<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5">ĐĂNG KÝ ĐỀ TÀI KHÓA LUẬN</h2>
    <form:form method="post" modelAttribute="dangkykhoaluan" action="${action}">
        <div class="form-group container">
            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="maSV" path="dangkykhoaluanPK.maSV" class="form-control" value="${nguoidung.nguoidungPK.maND}" placeholder="Nhập mã sinh viên"/>
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="maSV2" path="maSV2" class="form-control"  placeholder="Nhập mã sinh viên 2 (nếu có)" />
                </div>
            </div>
            <div class="row">
                <div class="form-outline mt-4 col">
                    <label class="form-label" for="khoa" >Chọn đề tài </label>
                    <form:select id="detai" path="maDT" >
                        <form:option value="0" >Đề tài</form:option>
                        <c:forEach items="${detai}" var="d">
                            <form:option value="${d.maDT}" >${d.maDT} - ${d.tenDT}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Đăng ký khóa luận"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </div>
    </form:form>
</c:if>
