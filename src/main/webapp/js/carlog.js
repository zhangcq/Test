$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllLogCar?carNum='+encodeURI(encodeURI($("#txt_search_carNum").val()))+'&companyName='+encodeURI(encodeURI($("#txt_search_companyName").val()))+'&carType='+encodeURI(encodeURI($("#txt_search_carType").val()))});
	});
	
	$('#btn_add').bind("click",function(){
		$("#add").css("display","block");
		$("#back").css("display","block");
	});
	
	$('#btn_edit').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			$("#edit").css("display","block");
			$("#back").css("display","block");
			$("#edit-carNum").val($(".selected").children('td').eq(1).html());
			$("#edit-companyName").val($(".selected").children('td').eq(3).html());
			for(var i=1;i<=2;i++){
				if($("select").children('option').eq(i).html() == $(".selected").children('td').eq(2).html()){
					$("select").val($(".selected").children('td').eq(2).html());
				}
			}
		}else{
			alert("请选择一个对象");
		}
	});
	
	$('#btn_delete').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			var carId = $(".selected").attr("data-uniqueid");
			$.post("/graduate/car/deleteLogCar",{carId:carId},function(data){
				if(data>0){
					alert("删除成功");
					$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllLogCar'});
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
	$("#add-departure").val("");
	$("#add-destination").val("");
	$("#add-cartype").val("");
	$("#add-weight").val("");
	$("#add-carvalue").val("");
	$("#edit-departure").val("");
	$("#edit-destination").val("");
	$("#edit-cartype").val("");
	$("#edit-weight").val("");
	$("#edit-carvalue").val("");
}
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/car/getAllLogCar', // 请求后台的URL（*）
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
		uniqueId : "carId", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'carNum',
			title : '车牌号'
		}, {
			field : 'carType',
			title : '车辆类型'
		}, {
			field : 'companyName',
			title : '所属公司'
		}, {
			field : 'createTime',
			title : '登记时间'
		}, {
			field : 'creater',
			title : '登记人'
		}]
	});
	
};
	 

function queryParams(params) {
	return {
		pageNumber : params.offset,
		pageSize : params.limit
	};
}

function add(){
	var carNum=$("#add-carNum").val();
	var carType=$("#add-carType").val();
	var companyName=$("#add-companyName").val();
	
	$.post("/graduate/car/addLogCar",{carNum:carNum,carType:carType,companyName:companyName},function(data){
		if(data>0){
			alert("添加成功");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-carNum").val("");
			$("#add-companyName").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllLogCar'});
		}else{
			alert("添加失败");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-carNum").val("");
			$("#add-companyName").val("");
		}
	});
}

function edit(){
	var carId = $(".selected").attr("data-uniqueid");
	var carNum=$("#edit-carNum").val();
	var carType=$("#edit-carType").val();
	var companyName=$("#edit-companyName").val();
	
	$.post("/graduate/car/editLogCar",{carId:carId,carNum:carNum,carType:carType,companyName:companyName},function(data){
		if(data>0){
			alert("修改成功");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-carNum").val("");
			$("#edit-companyName").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllLogCar'});
		}else{
			alert("修改失败");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$("#edit-carNum").val("");
			$("#edit-companyName").val("");
		}
	});
}