<%-- 
    Document   : GiaoVu
    Created on : Aug 9, 2022, 8:06:17 PM
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

<h2 class="text-center mt-5"><strong>ĐỀ TÀI KHÓA LUẬN</strong></h2>
<c:url value="/DeTaiKhoaLuan" var="action"/>
<div class="container">
    <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
        <!-- PHẦN GIÁO VỤ THÊM MỚI ĐỀ TÀI KHÓA LUẬN -->
        <h4 class="mt-4">Thêm đề tài khóa luận</h4>
        <div class="form-group container">
            <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="detaimoi" >
                <div class="form-outline mt-4">
                    <form:input type="text" class="form-control" path="tenDT" placeholder="Tên đề tài"/>
                </div>
                <div class="form-outline mt-4">
                    <form:textarea class="form-control" path="noiDung" placeholder="Nội dung chi tiết đề tài khóa luận"></form:textarea>
                    </div>

                    <div class="col mt-4">
                        <div class="input-group date" id="datepicker">
                        <form:input type="text" class="form-control" id="hanNop" path="hanNop" placeholder="Thời hạn nộp khóa luận" />
                        <span class="input-group-append">
                            <span class="input-group-text bg-light d-block">
                                <i class="fa fa-calendar"></i>
                            </span>
                        </span>
                    </div>
                </div>
                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Thêm đề tài" />
                    <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy" />
                </div>
            </form:form>
            <!-- PHẦN GIÁO VỤ XEM DANH SÁCH ĐỀ TÀI KHÓA LUẬN -->
            <hr>
            <h4 class="mt-4">Danh sách đề tài khóa luận</h4>
            <div class="form-outline mt-4">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Năm</th>
                            <th>Tên đề tài</th>
                            <th>Nội dung</th>
                            <th>Thời hạn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${detai}" var="dt">
                            <tr>
                                <td>${dt.nam}</td>
                                <td>${dt.tenDT}</td>
                                <td>${dt.noiDung}</td>
                                <td>${dt.hanNop}</td>
                                <td><a href=" <c:url value="/DeTaiKhoaLuan/${dt.maDT}" />">Xóa</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

    <c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
        <!-- PHẦN GIẢNG VIÊN XEM ĐỀ TÀI KHÓA LUẬN -->
        <h4 class="mt-4">Danh sách đề tài khóa luận</h4>
        <div class="form-outline mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Năm</th>
                        <th>Tên đề tài</th>
                        <th>Nội dung</th>
                        <th>Thời hạn</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${detai}" var="dt">
                        <tr>
                            <td>${dt.nam}</td>
                            <td>${dt.tenDT}</td>
                            <td>${dt.noiDung}</td>
                            <td>${dt.hanNop}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
        <!-- PHẦN SINH VIÊN XEM ĐỀ TÀI KHÓA LUẬN -->
        <h4 class="mt-4">Danh sách đề tài khóa luận</h4>
        <div class="form-outline mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Năm</th>
                        <th>Tên đề tài</th>
                        <th>Nội dung</th>
                        <th>Thời hạn</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${detai}" var="dt">
                        <tr>
                            <td>${dt.nam}</td>
                            <td>${dt.tenDT}</td>
                            <td>${dt.noiDung}</td>
                            <td>${dt.hanNop}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="form-outline mt-4">
            <a href="<c:url value="/sinhvien/DangKyKL/${pageContext.request.userPrincipal.name}"/>">
                <input type="Button" class="btn btn-primary btn-block mb-4" value="Đăng ký đề tài làm khóa luận"/>
            </a>          
        </div>
    </c:if>
</div>

<script type="text/javascript">
    $(function () {
        $('#datepicker').datepicker();
    });
</script>
