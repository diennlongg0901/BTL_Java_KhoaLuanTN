/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`;
};

function scoreChart(id, scoreLabels = [], scoreInfo = []) {
        let colors = [];
        for (let i = 0; i < scoreInfo.length; i++)
            colors.push(generateColor());
    const data = {
        labels: scoreLabels,
        datasets: [{
                label: "Thống kê điểm khóa luận",
                data: scoreInfo,
                borderColor: 'rgb(75, 192, 192)',
                backgroundColor: colors,
                hoverOffset: 4}]
    };
    const config = {
        type: 'bar',
        data: data,
        beginAtZero: true,
        options: {
            scales: {
                yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
            }
        },
    };
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
};

function svChart(id, svLabels = [], svInfo = []) {
        let colors = [];
        for (let i = 0; i < svInfo.length; i++)
            colors.push(generateColor());
    const data = {
        labels: svLabels,
        datasets: [{
                label: "Thống kê điểm sinh viên",
                data: svInfo,
//                borderColor: 'rgb(75, 192, 192)',
                backgroundColor: colors,
                hoverOffset: 4}]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}
