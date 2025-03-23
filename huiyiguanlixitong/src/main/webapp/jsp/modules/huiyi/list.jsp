<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

</style>
<body>



<%-- 查看会议文件列表--%>
<div class="modal fade" id="huiyiWenJianListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <%-- 模态框标题--%>
            <div class="modal-header">
                <h5 class="modal-title" id="modal-list-title">文件列表</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%-- 模态框内容 --%>
            <div class="modal-body">
                <%-- 查出当前订单的订单详情 --%>
                <table id="huiyiWenJianList" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>文件名</th>
                        <th>文件</th>
                        <th>上传时间</th>
                    </tr>
                    </thead>
                    <tbody id="huiyiWenJianListTbody">
                    </tbody>
                </table>
            </div>
            <%-- 模态框按钮 --%>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">
                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">会议管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">会议管理</li>
                        <li class="breadcrumb-item active">会议管理列表</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">会议管理列表</h3>
                        <div class="table-responsive mb-3">
                            <div class="col-sm-12">
                                                                                                 
                                        <label>
                                            会议名
                                            <input type="text" id="huiyiNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="会议名" aria-controls="tableId">
                                        </label>
                                                                                                                                                                 
                                        <label>
                                            会议开始时间
                                            <input type="datetime-local" id="kaishiTimeStartSearch" style="width: 190px;" class="form-control " placeholder="开始" aria-controls="tableId">
                                        </label>
                                            -
                                        <label>
                                            <input type="datetime-local" id="kaishiTimeEndSearch" style="width: 190px;"  class="form-control" placeholder="结束" aria-controls="tableId">
                                        </label>
                                 
                                        <label>
                                            会议结束时间
                                            <input type="datetime-local" id="jieshuTimeStartSearch" style="width: 190px;" class="form-control " placeholder="开始" aria-controls="tableId">
                                        </label>
                                            -
                                        <label>
                                            <input type="datetime-local" id="jieshuTimeEndSearch" style="width: 190px;"  class="form-control" placeholder="结束" aria-controls="tableId">
                                        </label>
                                
                                                                                                                                                                                                 
                                            <label>
                                                姓名
                                                <input type="text" id="nameSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="姓名" aria-controls="tableId">
                                            </label>
                                                 
                                            <label>
                                                手机号
                                                <input type="text" id="phoneSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="手机号" aria-controls="tableId">
                                            </label>
                                                 
                                            <label>
                                                身份证号
                                                <input type="text" id="idNumberSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="身份证号" aria-controls="tableId">
                                            </label>

                                <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                <button onclick="add()" type="button" class="btn btn-success 新增">添加</button>
                                <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                            </div>
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>

                                    <th >会议室</th>
                                    <th >会议名</th>
                                    <th >发起人姓名</th>
                                    <th >发起人手机号</th>
                                    <th >发起人身份证号</th>
                                    <th >会议缘由</th>
                                    <th >会议状态</th>
                                    <th >会议内容</th>
                                    <th >会议开始时间</th>
                                    <th >会议结束时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="thisTbody">
                                </tbody>
                            </table>
                            <div class="col-md-6 col-sm-3">
                                <div class="dataTables_length" id="tableId_length">

                                    <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                            onchange="changePageSize()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                    条 每页

                                </div>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                        <a class="page-link" href="#" tabindex="-1">上一页</a>
                                    </li>

                                    <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                        <a class="page-link" href="#">下一页</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->

    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "huiyi";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var id = null;
    var checkAll = false;

     var sexTypesOptions = [];
     var roleTypesOptions = [];


    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }



    // 查询
    function search() {
        searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                                                                 
                        //姓名
        var nameSearchInput = $('#nameSearch');
        if( nameSearchInput != null){
            if (nameSearchInput.val() != null && nameSearchInput.val() != '') {
                searchForm.name = $('#nameSearch').val();
            }
        }
                     
                        //手机号
        var phoneSearchInput = $('#phoneSearch');
        if( phoneSearchInput != null){
            if (phoneSearchInput.val() != null && phoneSearchInput.val() != '') {
                searchForm.phone = $('#phoneSearch').val();
            }
        }
                     
                        //身份证号
        var idNumberSearchInput = $('#idNumberSearch');
        if( idNumberSearchInput != null){
            if (idNumberSearchInput.val() != null && idNumberSearchInput.val() != '') {
                searchForm.idNumber = $('#idNumberSearch').val();
            }
        }
                                         
        var sexTypesSelectSearchInput = document.getElementById("sexTypesSelectSearch");
        if(sexTypesSelectSearchInput != null){
            var sexTypesIndex = sexTypesSelectSearchInput.selectedIndex;
            if( sexTypesIndex  != 0){
                searchForm.sexTypes = document.getElementById("sexTypesSelectSearch").options[sexTypesIndex].value;
            }
        }
                                                                                                     
        var roleTypesSelectSearchInput = document.getElementById("roleTypesSelectSearch");
        if(roleTypesSelectSearchInput != null){
            var roleTypesIndex = roleTypesSelectSearchInput.selectedIndex;
            if( roleTypesIndex  != 0){
                searchForm.roleTypes = document.getElementById("roleTypesSelectSearch").options[roleTypesIndex].value;
            }
        }
    <!-- 本表的查询条件 -->

             
        //会议名
        var huiyiNameSearchInput = $('#huiyiNameSearch');
        if( huiyiNameSearchInput != null){
            if (huiyiNameSearchInput.val() != null && huiyiNameSearchInput.val() != '') {
                searchForm.huiyiName = $('#huiyiNameSearch').val();
            }
        }
                     
        var kaishiTimeStartSearch = $('#kaishiTimeStartSearch');
        if( kaishiTimeStartSearch != null){
            if (kaishiTimeStartSearch.val() != null && kaishiTimeStartSearch.val() != '') {
                searchForm.kaishiTimeStart = $('#kaishiTimeStartSearch').val();
            }
        }
        var kaishiTimeEndSearch = $('#kaishiTimeEndSearch');
        if( kaishiTimeEndSearch != null){
            if (kaishiTimeEndSearch.val() != null && kaishiTimeEndSearch.val() != '') {
                searchForm.kaishiTimeEnd = $('#kaishiTimeEndSearch').val();
            }
        }
     
        var jieshuTimeStartSearch = $('#jieshuTimeStartSearch');
        if( jieshuTimeStartSearch != null){
            if (jieshuTimeStartSearch.val() != null && jieshuTimeStartSearch.val() != '') {
                searchForm.jieshuTimeStart = $('#jieshuTimeStartSearch').val();
            }
        }
        var jieshuTimeEndSearch = $('#jieshuTimeEndSearch');
        if( jieshuTimeEndSearch != null){
            if (jieshuTimeEndSearch.val() != null && jieshuTimeEndSearch.val() != '') {
                searchForm.jieshuTimeEnd = $('#jieshuTimeEndSearch').val();
            }
        }
            getDataList();
    }

    // 获取数据列表
    function getDataList() {
        http("huiyi/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            huiyiName: searchForm.huiyiName,
            kaishiTimeStart: searchForm.kaishiTimeStart,
            kaishiTimeEnd: searchForm.kaishiTimeEnd,
            jieshuTimeStart: searchForm.jieshuTimeStart,
            jieshuTimeEnd: searchForm.jieshuTimeEnd,
            //级联表的
                        name: searchForm.name,
                        phone: searchForm.phone,
                        idNumber: searchForm.idNumber,
                        sexTypes: searchForm.sexTypes,
                        roleTypes: searchForm.roleTypes,


        }, (res) => {
            if(res.code == 0) {
                clear();
                $("#thisTbody").html("");
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('#thisTbody').append(trow);
                }
                pagination(); //渲染翻页组件
                getRoleButtons();// 权限按钮控制
            }
        });
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)




        //会议室
        var huiyishiTypesCell = document.createElement('td');
        huiyishiTypesCell.innerHTML = item.huiyishiValue;
        row.appendChild(huiyishiTypesCell);


        //会议名
        var huiyiNameCell = document.createElement('td');
        huiyiNameCell.innerHTML = item.huiyiName;
        row.appendChild(huiyiNameCell);



        //姓名
        var nameCell = document.createElement('td');
        nameCell.innerHTML = item.name;
        row.appendChild(nameCell);


        //手机号
        var phoneCell = document.createElement('td');
        phoneCell.innerHTML = item.phone;
        row.appendChild(phoneCell);


        //身份证号
        var idNumberCell = document.createElement('td');
        idNumberCell.innerHTML = item.idNumber;
        row.appendChild(idNumberCell);

            //会议缘由
        var huiyiyuanyouContentCell = document.createElement('td');
        //如果图文详情包含图片
        if (item.huiyiyuanyouContent && item.huiyiyuanyouContent.indexOf('img') != -1) {
            //暂时只考虑图片+文字 和 文字+图片的情况
            var beginIndex = item.huiyiyuanyouContent.indexOf('<img');
            var endIndex = item.huiyiyuanyouContent.indexOf('>');
                huiyiyuanyouContentCell.innerHTML = item.huiyiyuanyouContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
        } else {
            if (item.huiyiyuanyouContent != null && item.huiyiyuanyouContent != "" && item.huiyiyuanyouContent.length >= 11) {
                    huiyiyuanyouContentCell.innerHTML = item.huiyiyuanyouContent.substring(0, 10) + "...";
            } else {
                    huiyiyuanyouContentCell.innerHTML = item.huiyiyuanyouContent;
            }
        }
        row.appendChild(huiyiyuanyouContentCell);


        //会议状态
        var huiyiTypesCell = document.createElement('td');
        huiyiTypesCell.innerHTML = item.huiyiValue;
        row.appendChild(huiyiTypesCell);


            //会议内容
        var huiyiContentCell = document.createElement('td');
        //如果图文详情包含图片
        if (item.huiyiContent && item.huiyiContent.indexOf('img') != -1) {
            //暂时只考虑图片+文字 和 文字+图片的情况
            var beginIndex = item.huiyiContent.indexOf('<img');
            var endIndex = item.huiyiContent.indexOf('>');
                huiyiContentCell.innerHTML = item.huiyiContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
        } else {
            if (item.huiyiContent != null && item.huiyiContent != "" && item.huiyiContent.length >= 11) {
                    huiyiContentCell.innerHTML = item.huiyiContent.substring(0, 10) + "...";
            } else {
                    huiyiContentCell.innerHTML = item.huiyiContent;
            }
        }
        row.appendChild(huiyiContentCell);


        //会议开始时间
        var kaishiTimeCell = document.createElement('td');
        kaishiTimeCell.innerHTML = item.kaishiTime;
        row.appendChild(kaishiTimeCell);


        //会议结束时间
        var jieshuTimeCell = document.createElement('td');
        jieshuTimeCell.innerHTML = item.jieshuTime;
        row.appendChild(jieshuTimeCell);



        //每行按钮
        var btnGroup = document.createElement('td');

        //详情按钮
        var detailBtn = document.createElement('button');
        var detailAttr = "detail(" + item.id + ')';
        detailBtn.setAttribute("type", "button");
        detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
        detailBtn.setAttribute("onclick", detailAttr);
        detailBtn.innerHTML = "查看"
        btnGroup.appendChild(detailBtn)
        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'edit(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "修改"
        btnGroup.appendChild(editBtn)
        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'seeWenJianList(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "会议文件查看"
        btnGroup.appendChild(editBtn)
        //删除按钮
        var deleteBtn = document.createElement('button');
        var deleteAttr = 'remove(' + item.id + ')';
        deleteBtn.setAttribute("type", "button");
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
        deleteBtn.setAttribute("onclick", deleteAttr);
        deleteBtn.innerHTML = "删除"
        btnGroup.appendChild(deleteBtn)

        row.appendChild(btnGroup)
        return row;
    }


    // 翻页
    function pageNumChange(val) {
        if (val == 'pre') {
            pageIndex--;
        } else if (val == 'next') {
            pageIndex++;
        } else {
            pageIndex = val;
        }
        getDataList();
    }

    // 下载
    function download(url) {
        window.open(url);
    }

    // 渲染翻页组件
    function pagination() {
        var beginIndex = pageIndex;
        var endIndex = pageIndex;
        var point = 4;
        //计算页码
        for (var i = 0; i < 3; i++) {
            if (endIndex == totalPage) {
                break;
            }
            endIndex++;
            point--;
        }
        for (var i = 0; i < 3; i++) {
            if (beginIndex == 1) {
                break;
            }
            beginIndex--;
            point--;
        }
        if (point > 0) {
            while (point > 0) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            while (point > 0) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--
            }
        }
        // 是否显示 前一页 按钮
        if (pageIndex > 1) {
            $('#tableId_previous').show();
        } else {
            $('#tableId_previous').hide();
        }
        // 渲染页码按钮
        for (var i = beginIndex; i <= endIndex; i++) {
            var pageNum = document.createElement('li');
            pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
            if (pageIndex == i) {
                pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
            } else {
                pageNum.setAttribute('class', 'paginate_button page-item useOnce');
            }
            var pageHref = document.createElement('a');
            pageHref.setAttribute('class', 'page-link');
            pageHref.setAttribute('href', '#');
            pageHref.setAttribute('aria-controls', 'tableId');
            pageHref.setAttribute('data-dt-idx', i);
            pageHref.setAttribute('tabindex', 0);
            pageHref.innerHTML = i;
            pageNum.appendChild(pageHref);
            $('#tableId_next').before(pageNum);
        }
        // 是否显示 下一页 按钮
        if (pageIndex < totalPage) {
            $('#tableId_next').show();
            $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
        } else {
            $('#tableId_next').hide();
        }
        var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
        $('#tableId_info').html(pageNumInfo);
    }

    // 跳转到指定页
    function toThatPage() {
        //var index = document.getElementById('pageIndexInput').value;
        if (index < 0 || index > totalPage) {
            alert('请输入正确的页码');
        } else {
            pageNumChange(index);
        }
    }

    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function deleteMore() {
        ids = []
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                ids.push(boxs[i].value)
            }
        }
        if (ids.length == 0) {
            alert('请勾选要删除的记录');
        } else {
            remove(ids);
        }
    }

    // 删除
    function remove(id) {
        var mymessage = confirm("真的要删除吗？");
        if (mymessage == true) {
            var paramArray = [];
            if (id == ids) {
                paramArray = id;
            } else {
                paramArray.push(id);
            }
            httpJson("huiyi/delete", "POST", paramArray, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('删除成功');
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>

    //修改
    function edit(id) {
        window.sessionStorage.setItem('updateId', id)
        window.location.href = "add-or-update.jsp"
    }

    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    //添加
    function add() {
        window.sessionStorage.setItem("addhuiyi", "addhuiyi");
        window.location.href = "add-or-update.jsp"
    }

    //报表
    function graph() {
        window.location.href = "graph.jsp"
    }

    // 查看详情
    function detail(id) {
        window.sessionStorage.setItem("updateId", id);
        window.location.href = "info.jsp";
    }

    //填充级联表搜索下拉框
                                                                                 
                     
                     
                                         
        function sexTypesSelectSearch() {
            var sexTypesSelectSearch = document.getElementById('sexTypesSelectSearch');
            if(sexTypesSelectSearch != null) {
                sexTypesSelectSearch.add(new Option('-请选择-',''));
                if (sexTypesOptions != null && sexTypesOptions.length > 0){
                    for (var i = 0; i < sexTypesOptions.length; i++) {
                            sexTypesSelectSearch.add(new Option(sexTypesOptions[i].indexName, sexTypesOptions[i].codeIndex));
                    }
                }
            }
        }
                                                                                                     
        function roleTypesSelectSearch() {
            var roleTypesSelectSearch = document.getElementById('roleTypesSelectSearch');
            if(roleTypesSelectSearch != null) {
                roleTypesSelectSearch.add(new Option('-请选择-',''));
                if (roleTypesOptions != null && roleTypesOptions.length > 0){
                    for (var i = 0; i < roleTypesOptions.length; i++) {
                            roleTypesSelectSearch.add(new Option(roleTypesOptions[i].indexName, roleTypesOptions[i].codeIndex));
                    }
                }
            }
        }

    //填充本表搜索下拉框
             
                     
     
    
    //查询级联表搜索条件所有列表
        function sexTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types", "GET", {}, (res) => {
                if(res.code == 0){
                    sexTypesOptions = res.data.list;
                }
            });
        }
        function roleTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=role_types", "GET", {}, (res) => {
                if(res.code == 0){
                    roleTypesOptions = res.data.list;
                }
            });
        }

    //查询当前表搜索条件所有列表




    // function seeWenJianList(id) {
    //     window.sessionStorage.setItem('updateId', id)
    //     window.location.href = "add-or-update.jsp"
    // }
    // 查看文件列表
    function seeWenJianList(aid) {
        id=aid;
        $('#huiyiWenJianListModal').modal('show');
    }

    $('#huiyiWenJianListModal').on('show.bs.modal', function () {
        //查询购买订单列表详情
        http("huiyiwenjian/page", "GET", {
            page: 1,
            limit: 100,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            huiyiId: id,
        }, (res) => {
            if(res.code == 0){
                var list = res.data.list;
                for (var i = 0; i < list.length; i++) { //遍历一下表格数据  
                    var trow = huiyiWenJianListDataRow(list[i]); //定义一个方法,返回tr数据 
                    $('#huiyiWenJianListTbody').append(trow);
                }
            }else{
                alert("查不到该会议的文件");
            }
        });
    })

    $('#huiyiWenJianListModal').on('hide.bs.modal', function () {
        id=null;
        $("#huiyiWenJianListTbody").html("");
    });

    // 添加当前购买订单中的物资到列表中
    function huiyiWenJianListDataRow(item) {
        //创建行 
        var row = document.createElement('tr');

        //文件名
        var huiyiwenjianNameCell = document.createElement('td');
        huiyiwenjianNameCell.innerHTML = item.huiyiwenjianName;
        row.appendChild(huiyiwenjianNameCell);

        //会议文件
        var huiyiwenjianFileCell = document.createElement('td');
        if(item.huiyiwenjianFile ==null || item.huiyiwenjianFile == '' || item.huiyiwenjianFile == 'null'){
            huiyiwenjianFileCell.innerHTML = '没有下载文件';
        }else {
            var huiyiwenjianFileFile = document.createElement('button');
            huiyiwenjianFileFile.innerHTML = '下载';
            var huiyiwenjianFileFileAttr = "download('" + item.huiyiwenjianFile + "')"
            huiyiwenjianFileFile.setAttribute('onclick',huiyiwenjianFileFileAttr);
            huiyiwenjianFileCell.appendChild(huiyiwenjianFileFile);
        }
        row.appendChild(huiyiwenjianFileCell);

        //上传时间
        var insertTimeCell = document.createElement('td');
        insertTimeCell.innerHTML = item.insertTime;
        row.appendChild(insertTimeCell);

        return row;
    }



    $(document).ready(function () {
        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询级联表的搜索下拉框
        sexTypesSelect();
        roleTypesSelect();

        //查询当前表的搜索下拉框
        getDataList();

        //级联表的下拉框赋值
                                                                                                 
                         
                         
                                                 
    sexTypesSelectSearch();
                                                                                                                         
    roleTypesSelectSearch();

        //当前表的下拉框赋值
                                     
                                                             
             
            
    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>