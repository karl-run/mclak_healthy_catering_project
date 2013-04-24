/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    var orderString = document.getElementById("orderstring");
    var myData = new Array([1996, 22], [1997, 36], [1998, 37], [1999, 45], [2000, 50], [2001, 55], [2002, 61], [2003, 61], [2004, 62], [2005, 66], [2006, 73]);
    var myChart = new JSChart('graph', 'line');
    alert(orderString.innerHTML);
    myChart.setDataArray(myData);
    myChart.setTitle('Order prices');
    myChart.setTitleColor('#FFFFFF');
    myChart.setTitleFontSize(11);
    myChart.setAxisNameX('Orders');
    myChart.setAxisNameY('Price');
    myChart.setAxisColor('#C4C4C4');
    myChart.setAxisValuesColor('#343434');
    myChart.setAxisPaddingLeft(100);
    myChart.setAxisPaddingRight(120);
    myChart.setAxisPaddingTop(50);
    myChart.setAxisPaddingBottom(40);
    myChart.setAxisValuesNumberX(6);
    myChart.setGraphExtend(true);
    myChart.setGridColor('#c2c2c2');
    myChart.setLineWidth(6);
    myChart.setLineColor('#9F0505');
    myChart.setSize(616, 321);
    myChart.setBackgroundImage('chart_bg.jpg');
    myChart.draw();