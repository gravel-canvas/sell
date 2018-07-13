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
                            <th>商品ID</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list productInfoPage.content as productInfo>
                <tr>
                    <td>${productInfo.productId}</td>
                    <td>${productInfo.productName}</td>
                    <td><img height="100", width="100" src="${productInfo.productIcon}"></td>
                    <td>${productInfo.productPrice}</td>
                    <td>${productInfo.productStock}</td>
                    <td>${productInfo.productDescription}</td>
                    <td>${productInfo.categoryType}</td>
                    <td>${productInfo.createTime}</td>
                    <td>${productInfo.updateTime}</td>
                    <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                    <td>
                        <#if productInfo.getProductStatusEnum().message == "上架">
                            <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                        <#else>
                            <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
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
                    <li><a href="/sell/seller/product/list?page=1&size=${size}">首页</a></li>
                </#if>
                <#if currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                    <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                </#if>
                <#list 1..productInfoPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
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

                <#if currentPage gte productInfoPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                    <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                </#if>
                <#if currentPage gte productInfoPage.getTotalPages()>
                    <li class="disabled"><a href="#">尾页</a></li>
                <#else>
                    <li><a href="/sell/seller/product/list?page=${productInfoPage.getTotalPages()}&size=${size}">尾页</a></li>
                </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>

</body>
</html>