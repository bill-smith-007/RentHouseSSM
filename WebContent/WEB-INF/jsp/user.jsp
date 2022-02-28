<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/"%><%
	String path = request.getContextPath();
	String basePath =  request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>房间管理-BootCRM</title>
	<!-- 引入css样式文件 -->
	<!-- Bootstrap Core CSS -->
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
	<!-- MetisMenu CSS -->
	<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />
	<!-- DataTables CSS -->
	<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />
	<!-- Custom CSS -->
	<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />
	<!-- Custom Fonts -->
	<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
  <!-- 导航栏部分 -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation"
		 style="margin-bottom: 0">
	<div class="navbar-header">
		<a class="navbar-brand" href="<%=basePath%>customer/list.action">BOOT房间管理系统 v2.0</a>
	</div>
	<%@ include file="nav.jsp" %>
  </nav>
    <!-- 房间列表查询部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">房间管理</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="get" 
				      action="${pageContext.request.contextPath }/house/list.action">
					<div class="form-group">
						<label for="staffName">房间id</label> 
						<input type="text" class="form-control" id="staffName" 
						                   value="${R_id }" name="R_id" />
					</div>
					<div class="form-group">
						<label for="customerFrom">房间状态</label> 
						<select	class="form-control" id="R_state" name="R_state">
							<option value="" >--请选择--</option>
								<option value="0" ${R_state==0?"selected":""}>未出租</option>
								<option value="1" ${R_state==""?"":R_state==1?"selected":""}>出租</option>
						</select>
					</div>
					
					<button type="submit" class="btn btn-primary">查询</button>
					<a  style="display: ${USER_SESSION.u_root==0?"":"none"};"  href="#" class="btn btn-primary" data-toggle="modal" 
		           data-target="#newsStaffDialog" onclick="clearStaff()">新建</a>
				</form>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">房间信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>房间id</th>
								<th>房间名称</th>
								<th>房间类型</th>
								<th>房间状态</th>
								<th>房间介绍</th>
								<th>房间价格</th>
								<th>房间创建者id</th>
								<th>房间启用时间</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="row">
								<tr>
									<td>${row.r_id}</td>
									<td>${row.r_name}</td>
									<td>${row.r_class_name}</td>
									<td>${row.r_state_Str}</td>
									<td>${row.r_introduce}</td>
									<td>${row.r_price}</td>
								   	<td>${row.r_create_id}</td>
									<td>${row.r_ceate_timeStr}</td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" style="display: ${USER_SESSION.u_root==0?"":"none"};" data-toggle="modal" data-target="#staffEditDialog" onclick= "editStaff(${row.r_id})">修改</a>
										<a href="#" class="btn btn-primary btn-xs"  onclick= "newEdit(${row.r_id})">预订</a>
										
										<a href="#" class="btn btn-danger btn-xs" style="display: ${USER_SESSION.u_root==0?"":"none"};" onclick="deleteStaff(${row.r_id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<itheima:page url="${pageContext.request.contextPath }/house/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 房间列表查询部分  end-->
</div>
<!-- 创建房间模态框 -->
<div class="modal fade" id="newsStaffDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建房间信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="new_staff_form">
					<div class="form-group">
						<label for="new_staffName" class="col-sm-2 control-label">
						    房间号
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="new_class" placeholder="房间号" name="R_id" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">房间名称</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="new_introduce" placeholder="房间名称" name="R_name" />
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">房间类型</label>
						<div class="col-sm-10">
						<select class="form-control" id="test" name="R_class_id">
						<c:forEach items="${classes}" var="row">
							 <option value="${row.r_class_id}">${row.r_class_name}</option>
						</c:forEach>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">房间介绍</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="new_price" placeholder="房间介绍" name="R_introduce">
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">房间价格</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="new_price" placeholder="房间价格" name="R_price">
						</div>
					</div>
					
					
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="createHouse()">创建房间</button>
			</div>
		</div>
	</div>
</div>
<div aria-hidden="true" class="modal fade" id="roomNewDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建房间信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="new_room_book">
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">预订时长</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="new_Bprice" placeholder="房间价格" name="B_time">
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">预订日期</label>
						<div class="col-sm-10">
							 <input type="date" class="form-control" id="new_Bdata" name="B_data">
						</div>
					</div>
					<input type="hidden" id="new_book_id" name="R_id"/>
					<input type="hidden" id="new_book_price" name="R_price"/>
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="createNewBook()">创建房间</button>
			</div>
		</div>
	</div>
</div>
<!-- 修改房间模态框 -->
<div class="modal fade" id="staffEditDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改房间信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="edit_staff_form">
				
				<div class="form-group">
						<label for="new_staffName" class="col-sm-2 control-label">
						   房间名称
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_name" placeholder="房间类型" name="R_class" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffClass" class="col-sm-2 control-label">
						    房间类型
						</label>
						<div class="col-sm-10">
						<select class="form-control"  name="R_class_id">
						<c:forEach items="${classes}" var="row">
							 <option id="edit_class${row.r_class_id}" value="${row.r_class_id}">${row.r_class_name}</option>
						</c:forEach>
						</select>
							
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">房间介绍</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_introduce" placeholder="房间介绍" name="R_introduce" />
						</div>
					</div>
					<div class="form-group">
						<label style="float:left;padding:7px 15px 0 27px;">房间状态</label>
						<div class="col-sm-10"> 
							<label class="radio-inline">
								  <input type="radio" id="edit_state0" name="R_state" value="0" checked> 可用
							</label>
							<label class="radio-inline">
								  <input type="radio" id="edit_state1" name="R_state" value="1"> 不可用
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">房间价格</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="edit_price" placeholder="房间价格" name="R_price">
						</div>
					</div>
					
					
					<input type="hidden" id="edit_room_id" name="R_id"/>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateStaff()">保存修改</button>
			</div>
		</div>
	</div>
</div>
<!-- 引入js文件 -->
<!-- jQuery -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath%>js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%=basePath%>js/sb-admin-2.js"></script>
<!-- 编写js代码 -->
<script type="text/javascript">
//清空新建房间窗口中的数据
	function clearStaff() {
	    $("#new_class").val("");
	    $("#new_introduce").val("");
	    $("#new_price").val("");
	    $("#new_data").val("");
	    $("#new_state0").prop("checked",true);
	}
	// 创建房间
	function createHouse() {
		if($("#new_class").val()==""){
			alert("类别必须输入!");
			$("#new_class").focus();
			return;
		}
		if($("#new_introduce").val()==""){
			alert("介绍必须输入!");
			$("#new_introduce").focus();
			return;
		}
		if($("#new_price").val()==""){
			alert("价格!");
			$("#new_price").focus();
			return;
		}
		if($("#new_data").val()==""){
			alert("日期必须输入!");
			$("#new_data").focus();
			return;
		}
		
		
		
	$.post("<%=basePath%>house/create.action",
					$("#new_staff_form").serialize(),function(data){
	        if(data =="OK"){
	            alert("房间创建成功！");
	            window.location.reload();
	        }else{
	            alert("房间创建失败！");
	            window.location.reload();
	        }
	    });
	}
	// 通过id获取修改的房间信息
	function editStaff(id) {
	    $.ajax({
	        type:"get",
	        url:"<%=basePath%>house/getRoomById.action",
	        data:{"id":id},
	        success:function(data) {
	            $("#edit_name").val(data.r_name);
	            $("#edit_room_id").val(data.r_id);
	            $("#edit_class"+data.r_class_id).prop("selected",true);
	            $("#edit_introduce").val(data.r_introduce)
	            $("#edit_price").val(data.r_price)
	            $("#edit_state"+data.r_state).prop("checked",true);
	        }
	    });
	}
    // 执行修改房间操作
	function updateStaff() {
		if($("#edit_name").val()==""){
			alert("房间名必须输入!");
			$("#edit_name").focus();
			return;
		}
		if($("#edit_class").val()==""){
			alert("类型必须选择!");
			$("#edit_class").focus();
			return;
		}
		if($("#edit_introduce").val()==""){
			alert("介绍必须输入!");
			$("#edit_introduce").focus();
			return;
		}
		if($("#edit_price").val()==""){
			alert("价格必须输入!");
			$("#edit_price").focus();
			return;
		}
		$.post("<%=basePath%>house/update.action",$("#edit_staff_form").serialize(),function(data){
			if(data =="OK"){
				alert("房间信息更新成功！");
				window.location.reload();
			}else{
				alert("房间信息更新失败！");
				window.location.reload();
			}
		});
	}
	// 删除房间
	function deleteStaff(id) {
	    if(confirm('确实要删除该房间吗?')) {
	$.post("<%=basePath%>house/delete.action",{"id":id},
	function(data){
	            if(data =="OK"){
	                alert("房间删除成功！");
	                window.location.reload();
	            }else{
	                alert("房间删除失败！");
	                window.location.reload();
	            }
	        });
	    }
	}
	function newEdit(id) {
	    $.ajax({
	        type:"get",
	        url:"<%=basePath%>room/getRoomById.action",
	        data:{"id":id},
	        success:function(data) {
	            if(data.r_state==0)
	            	{	
	            	 $("#new_book_id").val(data.r_id);
	            	 $("#new_book_price").val(data.r_price);
	            	 
	            		$('#roomNewDialog').modal('show')
	            	}
	            else{
	            		alert("房间暂时不可用")
	            }
	        }
	    });
	}
	function createNewBook(){
		$.post("<%=basePath%>room/newBook.action",$("#new_room_book").serialize(),function(data){
			if(data =="OK"){
				alert("订单,账单信息更新成功！");
				window.location.reload();
			}else{
				alert("订单,账单信息更新失败！");
				window.location.reload();
			}
		});
	}
	
</script>
</body>
</html>