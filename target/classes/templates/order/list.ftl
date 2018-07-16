<html>

<#-- title -->
<#include "../common/header.ftl">

<body>

<div id="wrapper" class="toggled">

    <#-- 边栏sidebar -->
    <#include "../common/nav.ftl">

    <#-- 主体content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>订单ID</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.orderAmount}</td>
                    <td>${orderDTO.getOrderStatusEnum().message}</td>
                    <td>${orderDTO.getPayStatusEnum().message}</td>
                    <td>${orderDTO.createTime}</td>
                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                    <td>
                        <#if orderDTO.getOrderStatusEnum().message == "新订单">
                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}">取消</a>
                        </#if>
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

            <#-- 分页 -->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                <#if currentPage lte 1>
                    <li class="disabled"><a href="#">首页</a></li>
                <#else>
                    <li><a href="/sell/seller/order/list?page=1&size=${size}">首页</a></li>
                </#if>
                <#if currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                    <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                </#if>
                <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                    </#if>
                </#list>

                    <#-- &lt;#&ndash; 以下为带省略号分页 &ndash;&gt;
                     &lt;#&ndash;第一页&ndash;&gt;
                     <#if (orderDTOPage.getTotalPages() > 0)>
                         <#if currentPage == 1>
                             <li class="disabled"><a href="/sell/seller/order/list?page=1&size=${size}" >1</a></li>
                         </#if>
                     </#if>

                     &lt;#&ndash;如果不只有一页&ndash;&gt;
                     <#if (orderDTOPage.getTotalPages() > 1)>
                         &lt;#&ndash;如果当前页往前查3页不是第2页&ndash;&gt;
                         <#if ((currentPage - 3) > 2)>
                             <li><span class="text">…</span></li>
                         </#if>

                         &lt;#&ndash;当前页的前3页和后3页&ndash;&gt;
                         <#list (currentPage - 3)..(currentPage + 3) as index>
                         &lt;#&ndash;如果位于第一页和最后一页之间&ndash;&gt;
                             <#if (index > 1) && (index < orderDTOPage.getTotalPages())>
                                 <#if currentPage == index>
                                     <li class="disabled"><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                 </#if>
                             </#if>
                         </#list>

                         &lt;#&ndash;如果当前页往后查3页不是倒数第2页&ndash;&gt;
                         <#if (currentPage + 3) < (orderDTOPage.getTotalPages() - 1)>
                             <li><span class="text">…</span></li>
                         </#if>

                         &lt;#&ndash;最后页&ndash;&gt;
                         <#if currentPage == orderDTOPage.getTotalPages()>
                             <li class="disabled"><a href="/sell/seller/order/list?page=${orderDTOPage.getTotalPages()}&size=${size}" >${orderDTOPage.getTotalPages()}</a></li>
                         </#if>
                     </#if>-->

                <#if currentPage gte orderDTOPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                    <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                </#if>
                <#if currentPage gte orderDTOPage.getTotalPages()>
                    <li class="disabled"><a href="#">尾页</a></li>
                <#else>
                    <li><a href="/sell/seller/order/list?page=${orderDTOPage.getTotalPages()}&size=${size}">尾页</a></li>
                </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>

<#-- 弹窗 -->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                您有新的订单
            </div>
            <div class="modal-footer">
                <button onclick="javascript: document.getElementById('notice').pause();" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>
    </div>
</div>

<#-- 播放音乐 -->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
</audio>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    var websocket = null;

    if ('WebSocket' in window) {
        websocket = new WebSocket('ws://192.168.2.204:8080/sell/websocket');
    } else {
        alert("该浏览器不支持websocket")
    }

    websocket.onopen = function (ev) {
        console.log("建立连接")
    }

    websocket.onclose = function (ev) {
        console.log("连接关闭")
    }

    websocket.onmessage = function (ev) {
        console.log("收到消息:" + ev.data)

        $('#myModal').modal('show');

        document.getElementById('notice').play();
        // 可以做业务逻辑处理，如弹窗提醒，音乐
    }

    websocket.onerror = function (ev) {
        console.log("发生错误")
        alert("websocket通信发生错误")
    }

    websocket.onbeforeunload = function (ev) {
        websocket.close();
    }

</script>

</body>
</html>