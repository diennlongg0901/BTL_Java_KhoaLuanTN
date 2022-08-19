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
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo mới" />
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
                        <%--<c:forEach items="${giangvien}" var="gv">--%>
                            <form:option value="Chủ tịch" >Chủ tịch</form:option>
                            <form:option value="Thư ký" >Thư ký</form:option>
                            <form:option value="Phản biện" >Phản biện</form:option>
                            <form:option value="Thành viên 1" >Thành viên 1</form:option>
                            <form:option value="Thành viên 2" >Thành viên 2</form:option>
                        <%--</c:forEach>--%>
                    </form:select>
                </div>
                
<!--                <div class="form-outline mt-4">
                    <label class="form-label">Mã phản biện</label>
                    <select id="vaiTro">
                        <%--<c:forEach items="${giangvien}" var="gv">--%>
                            <option value="${gv.giangvienPK.maGV}" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</option>
                        <%--</c:forEach>--%>
                    </select>
                </div>
                
                <div class="form-outline mt-4">
                    <label>Mã thành viên 1</label>
                    <select id="vaiTro">
                        <%--<c:forEach items="${giangvien}" var="gv">--%>
                            <option value="${gv.giangvienPK.maGV}" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</option>
                        <%--</c:forEach>--%>
                    </select>
                </div>
                
                <div class="form-outline mt-4">
                    <label>Mã thành viên 2</label>
                    <select id="vaiTro">
                        <%--<c:forEach items="${giangvien}" var="gv">--%>
                            <option value="${gv.giangvienPK.maGV}" >${gv.giangvienPK.maGV} - ${gv.nguoidung.ho} ${gv.nguoidung.ten}</option>
                        <%--</c:forEach>--%>
                    </select>
                </div>-->
                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo mới" />
                </div>
            </form:form>
        </div>
    </c:if>
    <h3>Thông tin danh sách hội đồng</h3>
    <div class="form-outline mt-4">
        <label>Chủ tịch</label>
        <label>Thư ký</label>
        <label>Phản biện</label>
        <label>Thành viên</label>
    </div>
</div>