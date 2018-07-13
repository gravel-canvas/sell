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
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名字</label>
                            <input type="text" class="form-control" name="categoryName" value="${(productCategory.categoryName)!''}" />
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input type="number" class="form-control" name="categoryType" value="${(productCategory.categoryType)!''}" />
                        </div>

                        <input type="hidden" name="categoryId" value="${(productCategory.categoryId)!''}" />
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>