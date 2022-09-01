/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function scoreChart(id, scoreLabels=[], scoreInfo=[]) {
    let colors = []
    for(let i = 0; i<scoreInfo.length; i++)
        color.push(generateColor())
    const data = {
        labels: scoreLabels,
        datasets: [{
                label: "Thống kê điểm khóa luận",
                data: scoreInfo,
                backgroundColor: colors,
                hoverOffset:4            }]
    };

    const config = {
        type: 'line',
        data: data,
    };
    
    let ctx = document.getElementByID(id).getContext("2d")
    new Chart(ctx, config);
}

