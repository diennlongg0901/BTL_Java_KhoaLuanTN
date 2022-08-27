<%-- 
    Document   : DangKyBoSung
    Created on : Aug 12, 2022, 4:05:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h2 class="text-center mt-5">ĐĂNG KÝ ĐỀ TÀI KHÓA LUẬN</h2>

<form:form method="post" modelAttribute="dangkykhoaluan" action="${action}">
    <div class="form-group container-fluid">
        <div class="row">
            <div class="form-outline mt-4 col">
                <form:input type="text" id="maSV" path="dangkykhoaluanPK.sinhvienmaSV" class="form-control" value="${nguoidung.nguoidungPK.maND}" />
            </div>
            <div class="form-outline mt-4 col">
                <form:input type="text" id="maND" path="dangkykhoaluanPK.maND" class="form-control"  value="${nguoidung.nguoidungPK.maND}" />
            </div>

        </div>
        <div class="row">
            <div class="form-outline mt-4 col">
                <label class="form-label" for="khoa" >Đề tài</label>
                <form:select id="detai" path="maDetai" >
                    <c:forEach items="${detai}" var="d">
                        <form:option value="${d.maDT}" >${d.maDT} - ${d.tenDT}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            
        </div>
        <div class="row">
            <div class="form-outline mt-4 col">
                <label class="form-label" for="khoa" >Khoa</label>
                <select id="khoa" >
                    <c:forEach items="${khoa}" var="k">
                        <option value="${k.maKhoa}" >${k.maKhoa} - ${k.tenKhoa}</option>
                    </c:forEach>
                </select>
            </div>
            
        </div>
        <div class="row">
            <div class="form-outline mt-4 col">
                <label class="form-label" for="nganh" >Ngành</label>
                <select id="nganh" >
                    <c:forEach items="${nganh}" var="n">
                        <option value="${n.nganhPK.maNganh}">${n.nganhPK.maNganh} - ${n.tenNganh}</option>
                    </c:forEach>
                </select>
            </div>
            
        </div>

        <div class="form-outline mt-4">
            <input type="submit" class="btn btn-primary btn-block mb-4" value="Đăng ký khóa luận"/>
            <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
        </div>
    </div>
</form:form>