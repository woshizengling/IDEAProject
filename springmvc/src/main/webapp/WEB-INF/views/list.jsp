<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
    <script src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

    <div style="margin-top: 20px">
        <table id="toysDataGrid"></table>
    </div>
    <div id="editTool">
        玩具名：<input class="easyui-textbox" id="name">&nbsp;&nbsp;
        生产时间：<input class="easyui-datebox" id="beginDate" >--<input class="easyui-datebox" id="endDate">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="toy_obj.search()">查询</a>
    </div>
    <script>
       $(function(){

           toy_obj = {
               search : function() {
                   $("#toysDataGrid").datagrid('load',{
                       name : $("#name").val(),
                       beginDate : $("#beginDate").datebox('getValue'),
                       endDate : $("#endDate").datebox('getValue')
                   })
               }
           }

            $("#toysDataGrid").datagrid({
            url : 'toys',
            title : '玩具列表',
            fitColumns : true,
            striped : true,
            columns : [[{
                field : 'no',
                title : '序号',
                width : 50,
                checkbox : true
            },{
                field : 'id',
                title : '编号',
                width : 80,
                align : 'center',
                sortable : true
            },{
                field : 'name',
                title : '名字',
                width : 80,
                align : 'center',
                sortable : true
            },{
                field : 'price',
                title : '价格',
                width : 80,
                align : 'center',
                sortable : true
            },{
                field : 'createDate',
                title : '生产日期',
                width : 150,
                align : 'center',
                sortable : true
            }]],
            toolbar : "#editTool",
            pagination : true,
            pageSize : 5,
            pageList : [2, 5, 10, 20, 50 ],
            sortName : 'id',
            sortOrder : 'asc',
                remoteSort : false
        });
        });
    </script>
</body>
</html>

