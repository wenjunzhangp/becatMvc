(function ($) {
    $.fn.paginator = function (options) {
        //this指向当前的选择器
        var config = {
            url: "",
            pageParent: "",
            totalBars: -1,
            limit: -1,
            offset: 1,
            callback: null
        }
        //合并参数
        var opts = $.extend(config, options);

        opts.totalBars = Math.ceil(parseInt(opts.totalBars.replace(",","")) / parseInt(opts.limit));
        //计算按钮的总个数

        //获取offset参数
        var queryString = function (url) {
            var offset = (url.split("?")[1]).split("=")[1];
            return parseInt(offset);
        }

        //ajax核心方法，用于分页的数据操作
        var ajaxCore = function (offset, fn) {
            $.ajax({
                "url": opts.url,
                "data": {
                    "page": offset,
                    "limit": opts.limit
                },
                "dataType": "JSON",
                "method": "POST",
                "success": fn
            });
        }

        //重新装配分页按钮
        var pageCore = function (offset) {
            if (opts.offset == offset) {
                return;
            } //如果是当前页面，那么就什么事都不用干了！
            else {
                ajaxCore(offset, opts.callback);
                $(opts.pageParent).empty();
                //否则，清空所有的节点，重新向DOM插入新的分页按钮
                var output = "";
                var nextBar = offset == opts.totalBars ? "<li class=\"am-disabled\"><a yxhref=\"javascript:;\">»</a></li>" : "<li><a yxhref=\"" + opts.url + (offset + 1) + "\">»</a></li>";
                var preBar = offset == 1 ? "<li class=\"am-disabled\"><a yxhref=\"javascript:;\">«</a></li>" : "<li><a yxhref=\"" + opts.url + (offset - 1) + "\">«</a></li>";
                //组装向上一个节点和下一页节点
                if (opts.totalBars > 7) {
                    if (offset < 5) {
                        output += preBar;
                        for (var i = 1; i <= 5; i++) {
                            if (i == offset) {
                                output += "<li class=\"am-active\"><a yxhref=\"" + opts.url + offset + "\">" + offset + "</a></li>";
                            } else {
                                output += "<li><a yxhref=\"" + opts.url + i + "\">" + i + "</a></li>";
                            }
                        }
                        output += "<li><span>...</span></li>";
                        output += "<li><a yxhref=\"" + opts.url + (opts.totalBars) + "\">" + (opts.totalBars) + "</a></li>" + nextBar;
                    } else if (offset >= 5 && offset <= opts.totalBars - 4) {
                        //当页面大于7个的时候，那么在第五个和倒数第五个时，执行
                        output += preBar;
                        output += "<li><a yxhref=\"" + opts.url + 1 + "\">" + 1 + "</a></li>";
                        //第一个
                        output += "<li><span>...</span></li>"; //省略号

                        output += "<li><a yxhref=\"" + opts.url + (offset - 1) + "\">" + (offset - 1) + "</a></li>";

                        output += "<li class=\"am-active\"><a  yxhref=\"" + opts.url + offset + "\">" + offset + "</a></li>";

                        output += "<li><a yxhref=\"" + opts.url + (offset + 1) + "\">" + (offset + 1) + "</a></li>";

                        output += "<li><span>...</span></li>"; //省略号;

                        output += "<li><a yxhref=\"" + opts.url + (opts.totalBars) + "\">" + (opts.totalBars) + "</a></li>"; //尾页

                        output += nextBar;

                    } else if (offset > opts.totalBars - 4 && offset <= opts.totalBars) {
                        //当页面位于倒数第四个时候
                        output += preBar;
                        output += "<li><a yxhref=\"" + opts.url + 1 + "\">" + 1 + "</a></li>" + "<li><span>...</span></li>";

                        for (var j = 4; j >= 0; j--) {
                            if (opts.totalBars - j == offset) {
                                output += "<li class=\"am-active\"><a yxhref=\"" + opts.url + (opts.totalBars - j) + "\">" + (opts.totalBars - j) + "</a></li>";
                            } else {
                                output += "<li><a yxhref=\"" + opts.url + (opts.totalBars - j) + "\">" + (opts.totalBars - j) + "</a></li>";
                            }
                        }
                        output += nextBar;
                    } else {
                        return;
                    }
                } else {
                    output += preBar;
                    for (var i = 1; i <= opts.totalBars; i++) {
                        if (i == offset) {
                            output += "<li class=\"am-active\"><a yxhref=\"" + opts.url + offset + "\">" + offset+ "</a></li>";
                        } else {
                            output += "<li><a yxhref=\"" + opts.url + i + "\">" + i+ "</a></li>";
                        }
                    }
                    output += nextBar;
                }
                $(opts.pageParent).append(output);
                opts.offset = offset; //将偏移量赋值给config里面的offset
            }
        }

        //清理函数，防止多绑定事件和重新计算分页
        var clear = function () {
            $(opts.pageParent).empty().undelegate();
        }


        //初始化装配分页按钮
        var init = function (fn) {
            if (typeof (fn) != "function") {
            } else {
                opts.callback = fn;
            }
            clear();
            ajaxCore(1, opts.callback);//执行初始化ajax方法
            var preBar = "<li class=\"am-disabled\"><a yxhref=\"javascript:;\">«</a></li>";
            //上一页,（禁用的效果）
            //如果只有一页，那么禁用下一页
            var nextBar = opts.totalBars > 1 ? "<li><a yxhref=\"" + opts.url + 2 + "\">»</a></li>" : "<li class=\"am-disabled\"><a yxhref=\"javascript:;\">»</a></li>";
            //最后一页
            var output = "<li class=\"am-active\"><a yxhref=\"" + opts.url + 1 + "\">1</a></li>";

            if (opts.totalBars <= 7) {
                for (var i = 1; i < opts.totalBars; i++) {
                    output += "<li><a yxhref=\"" + opts.url + (i + 1) + "\">" + (i + 1) + "</a></li>";
                }
            } else {
                for (var j = 1; j < 5; j++) {
                    output += "<li><a yxhref=\"" + opts.url + (j + 1) + "\">" + (j + 1) + "</a></li>";
                }
                output += "<li><span>...</span></li>";
                output += "<li><a yxhref=\"" + opts.url + (opts.totalBars) + "\">" + (opts.totalBars) + "</a></li>";
            }
            $(opts.pageParent).delegate("a","click", function () {
                var offset = queryString($(this).attr("yxhref"));
                pageCore(offset);
            });
            $(opts.pageParent).append(preBar + output + nextBar);
        };
        init(opts.callback);//初始化分页引擎
    }
}(window.jQuery))