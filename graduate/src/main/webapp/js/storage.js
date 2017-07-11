$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/storage/getAllStorage?storageNum='+encodeURI(encodeURI($("#txt_search_storageNum").val()))+'&location='+$("#txt_search_location").val()+'&type='+encodeURI(encodeURI($("#txt_search_type").val()))});
	});
	
	$('#btn_add').bind("click",function(){
		$("#add").css("display","block");
		$("#back").css("display","block");
	});
	
	$('#btn_edit').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			$("#edit").css("display","block");
			$("#back").css("display","block");
			$("#edit-storageNum").val($(".selected").children('td').eq(1).html());
			$("#edit-location").val($(".selected").children('td').eq(2).html());
			$("#edit-area").val($(".selected").children('td').eq(3).html());
			for(var i=1;i<=2;i++){
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
			var storageId = $(".selected").attr("data-uniqueid");
			$.post("/graduate/storage/deleteStorage",{storageId:storageId},function(data){
				if(data>0){
					alert("删除成功");
					$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/storage/getAllStorage'});
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
	$("#add-storageNum").val("");
	$("#add-location").val("");
	$("#add-area").val("");
	$("#edit-storageNum").val("");
	$("#edit-location").val("");
	$("#edit-area").val("");
}

function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/storage/getAllStorage', // 请求后台的URL（*）
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
		uniqueId : "storageId", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'storageNum',
			title : '仓库编号'
		}, {
			field : 'location',
			title : '所在仓库'
		}, {
			field : 'area',
			title : '面积'
		}, {
			field : 'type',
			title : '仓库类型'
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
	var storageNum=$("#add-storageNum").val();
	var location=$("#add-location").val();
	var area=$("#add-area").val();
	var type=$("#add-type").val();
	
	$.post("/graduate/storage/addStorage",{storageNum:storageNum,location:location,area:area,type:type},function(data){
		if(data>0){
			alert("添加成功");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-storageNum").val("");
			$("#add-location").val("");
			$("#add-area").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/storage/getAllStorage'});
		}else{
			alert("添加失败");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-storageNum").val("");
			$("#add-location").val("");
			$("#add-area").val("");
		}
	});
}

function edit(){
	var storageId = $(".selected").attr("data-uniqueid");
	var storageNum=$("#edit-storageNum").val();
	var location=$("#edit-location").val();
	var area=$("#edit-area").val();
	var type=$("#edit-type").val();
	
	$.post("/graduate/storage/editStorage",{storageId:storageId,storageNum:storageNum,location:location,area:area,type:type},function(data){
		if(data>0){
			alert("修改成功");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-storageNum").val("");
			$("#edit-location").val("");
			$("#edit-area").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/storage/getAllStorage'});
		}else{
			alert("修改失败");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-storageNum").val("");
			$("#edit-location").val("");
			$("#edit-area").val("");
		}
	});
}
