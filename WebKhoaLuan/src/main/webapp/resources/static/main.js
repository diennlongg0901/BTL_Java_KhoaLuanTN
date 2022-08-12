/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function xoaTaikhoan(maND){
    fetch(`WebKhoaLuan/quantri/QLTaiKhoan/${nguoidungPK.maND}`,{
        method:"delete",
        }).then(function(res){
            return res.json()
        })
}
