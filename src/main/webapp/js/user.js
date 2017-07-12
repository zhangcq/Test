$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/user/getAllUser?username='+encodeURI(encodeURI($("#txt_search_uname").val()))+'&usertel='+$("#txt_search_utel").val()+'&usercompanyName='+encodeURI(encodeURI($("#txt_search_companyName").val()))});
	});
	
	$('#btn_add').bind("click",function(){
		$("#add").css("display","block");
		$("#back").css("display","block");
	});
	
	$('#btn_edit').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			$("#edit").css("display","block");
			$("#back").css("display","block");
			$("#edit-uname").val($(".selected").children('td').eq(1).html());
			$("#edit-utel").val($(".selected").children('td').eq(2).html());
			$("#edit-companyName").val($(".selected").children('td').eq(3).html());
			for(var i=1;i<=4;i++){
				if($("select").children('option').eq(i).html() == $(".selected").children('td').eq(4).html()){
					$("select").val($(".selected").children('td').eq(4).html());
				}
			}
		}else{
			alert("请选择一个对象");
		}
	});
	
	$('#btn_delete').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			var userid = $(".selected").attr("data-uniqueid");
			$.post("/graduate/user/deleteUser",{userid:userid},function(data){
				if(data>0){
					alert("删除成功");
					$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/user/getAllUser'});
				}else{
					alert("删除失败");
				}
			});
		}else{
			alert("请选择一个对象");
		}
	});
});
 
function cancel(){
	$("#add").css("display","none");
	$("#edit").css("display","none");
	$("#back").css("display","none");
	$("#add-uname").val("");
	$("#add-utel").val("");
	$("#add-companyName").val("");
	$("#edit-uname").val("");
	$("#edit-utel").val("");
	$("#edit-companyName").val("");
}

function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/user/getAllUser', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		dataType : "json",
		toolbar : '#toolbar', // 工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : queryParams,// 传递参数（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "userid", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'uname',
			title : '用户名称'
		}, {
			field : 'utel',
			title : '联系方式'
		}, {
			field : 'companyName',
			title : '企业名称'
		}, {
			field : 'utype',
			title : '用户级别'
		}, ]
	});
	
};
	 

function queryParams(params) {
	return {
		pageNumber : params.offset,
		pageSize : params.limit
	};
}

function add(){
	var uname=$("#add-uname").val();
	var utel=$("#add-utel").val();
	var companyName=$("#add-companyName").val();
	var utype=$("#add-level").val();
	
	$.post("/graduate/user/addUser",{uname:uname,utel:utel,companyName:companyName,utype:utype},function(data){
		if(data>0){
			alert("添加成功");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-uname").val("");
			$("#add-utel").val("");
			$("#add-companyName").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/user/getAllUser'});
		}else{
			alert("添加失败");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-uname").val("");
			$("#add-utel").val("");
			$("#add-companyName").val("");
		}
	});
}

function edit(){
	var userid = $(".selected").attr("data-uniqueid");
	var uname=$("#edit-uname").val();
	var utel=$("#edit-utel").val();
	var companyName=$("#edit-companyName").val();
	var utype=$("#edit-level").val();
	
	$.post("/graduate/user/editUser",{userid:userid,uname:uname,utel:utel,companyName:companyName,utype:utype},function(data){
		if(data>0){
			alert("修改成功");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-uname").val("");
			$("#edit-utel").val("");
			$("#edit-companyName").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/user/getAllUser'});
		}else{
			alert("修改失败");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-uname").val("");
			$("#edit-utel").val("");
			$("#edit-companyName").val("");
		}
	});
}

/*function test(){
	$.post("user/test",function(data){
		console.log(data);
		var str={userid:1,name:1};
		console.log(str);
	},"json");
}*/
