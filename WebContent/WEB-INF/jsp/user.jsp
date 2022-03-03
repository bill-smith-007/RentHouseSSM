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
				      action="${pageContext.request.contextPath }/user/list.action">
					<div class="form-group">
						<label for="staffName">房间id</label> 
						<input type="text" class="form-control" id="staffName" 
						                   value="${U_id }" name="U_id" />
					</div>
					
					<div class="form-group">
						<label for="staffName">用户名</label> 
						<input type="text" class="form-control" id="staffName" 
						                   value="${U_name }" name="U_name" />
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
								<th>用户id</th>
								<th>用户名称</th>
								<th>用户权限</th>
								<th>用户介绍</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="row">
								<tr>
									<td>${row.u_id}</td>
									<td>${row.u_name}</td>
									<td>${row.u_rootStr}</td>
									<td>${row.u_introduce}</td>
								
									<td>
										<a href="#" class="btn btn-primary btn-xs" style="display: ${USER_SESSION.u_root==0?"":"none"};" data-toggle="modal" data-target="#staffEditDialog" onclick= "editStaff(${row.u_id})">修改</a>
										<a href="#" class="btn btn-primary btn-xs"  onclick= "newEdit(${row.u_id})">预订</a>
										
										<a href="#" class="btn btn-danger btn-xs" style="display: ${USER_SESSION.u_root==0?"":"none"};" onclick="deleteStaff(${row.u_id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<itheima:page url="${pageContext.request.contextPath }/user/list.action" />
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
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">用户名称</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="U_name" placeholder="用户名称" name="U_name" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">用户密码</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="U_password" placeholder="用户密码" name="U_password" />
						</div>
					</div>
					<div class="form-group">
						<label style="float:left;padding:7px 15px 0 27px;">用户权限</label>
						<div class="col-sm-10"> 
							<label class="radio-inline">
								  <input type="radio" id="U_root0" name="U_root" value="0" checked> 超级管理
							</label>
							<label class="radio-inline">
								  <input type="radio" id="U_root1" name="U_root" value="1"> 一般用户
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">用户介绍</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="U_introduce" placeholder="用户介绍" name="U_introduce">
						</div>
					</div>
					
					
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="createUser()">创建房间</button>
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
					<input type="hidden" id="new_book_id" name="U_id"/>
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
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">用户名称</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_U_name" placeholder="用户名称" name="U_name" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">用户密码</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_U_password" placeholder="用户密码" name="U_password" />
						</div>
					</div>
					<div class="form-group">
						<label style="float:left;padding:7px 15px 0 27px;">用户权限</label>
						<div class="col-sm-10"> 
							<label class="radio-inline">
								  <input type="radio" id="edit_U_root0" name="U_root" value="0" > 超级管理
							</label>
							<label class="radio-inline">
								  <input type="radio" id="edit_U_root1" name="U_root" value="1" checked> 一般用户
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">用户介绍</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_U_introduce" placeholder="用户介绍" name="U_introduce">
						</div>
					</div>
					
					
					<input type="hidden" id="edit_U_id" name="U_id"/>
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
	function createUser() {
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
		
		
		
	$.post("<%=basePath%>user/create.action",
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
	        url:"<%=basePath%>user/getUserById.action",
	        data:{"id":id},
	        success:function(data) {
	        	
	            $("#edit_U_name").val(data.u_name);
	            $("#edit_U_password").val(data.u_password);
	            $("#edit_U_root"+data.u_root).prop("checked",true);
	            $("#edit_U_introduce").val(data.u_introduce);
	            $("#edit_U_id").val(data.u_id);
	            
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
		$.post("<%=basePath%>user/update.action",$("#edit_staff_form").serialize(),function(data){
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
	$.post("<%=basePath%>user/delete.action",{"id":id},
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
	            	 $("#new_book_id").val(data.u_id);
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