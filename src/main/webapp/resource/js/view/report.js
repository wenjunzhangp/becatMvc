$(function(){
    //柱状状图表
    var barChar = echarts.init(document.getElementById('bardiv'),"dark");

    //柱状状图表
    var lineChar = echarts.init(document.getElementById('linediv'),"dark");

    //柱状状图表
    var pancakeChar = echarts.init(document.getElementById('pancakediv'),"dark");

    function loadBarChar() {
        barChar.clear();
        barChar.showLoading({text: '正在努力的读取数据中...'});
        $.getJSON('/report/bar.shtml', function (data) {
            barChar.setOption(data, true);
            barChar.hideLoading();
        });
    }
    loadBarChar();

    function loadLineChar() {
        lineChar.clear();
        lineChar.showLoading({text: '正在努力的读取数据中...'});
        $.getJSON('/report/line.shtml', function (data) {
            lineChar.setOption(data, true);
            lineChar.hideLoading();
        });
    }
    loadLineChar();

    function loadPancakeChar() {
        pancakeChar.clear();
        pancakeChar.showLoading({text: '正在努力的读取数据中...'});
        $.getJSON('/report/pancake.shtml', function (data) {
            pancakeChar.setOption(data, true);
            pancakeChar.hideLoading();
        });
    }
    loadPancakeChar();
});