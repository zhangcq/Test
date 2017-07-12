var scarid;
$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllCar?departure='+encodeURI(encodeURI($("#txt_search_departure").val()))+'&destination='+encodeURI(encodeURI($("#txt_search_destination").val()))+'&cartype='+encodeURI(encodeURI($("#txt_search_cartype").val()))});
	});
	
});
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/car/getAllCar', // 请求后台的URL（*）
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
		uniqueId : "carid", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'departure',
			title : '出发地'
		}, {
			field : 'destination',
			title : '目的地'
		}, {
			field : 'cartype',
			title : '车辆类型'
		}, {
			field : 'weight',
			title : '载重量(吨)'
		},{
			field : 'carvalue',
			title : '收费标准(元/吨/公里)'
		},{
			field : 'companyName',
			title : '公司名称'
		},{
			field : 'releaseTime',
			title : '发布时间'
		},{
			field : 'releaser',
			title : '发布人'
		},{
			field : 'phone',
			title : '联系方式'
		},{
			field : 'carid',
			title : '操作',
			formatter:function(value, row, x){
				return '<button class="btn" onclick="agree('+value+')">接受</button>';
			}
		}]
	});
	
};
	 

function queryParams(params) {
	return {
		pageNumber : params.offset,
		pageSize : params.limit
	};
}

function agree(carid){
	scarid=carid;
	$.post("thing/getAllMyThingCount",{carid:carid},function(data){
		if(data>0){
			$("#thing").css("display","block");
			$("#back").css("display","block");
			initTable2();
		}else{
			alert("您没有可运输的货物");
		}
	});
}

function sure(thingid){
	$.post("car/addTradeRecord",{carid:scarid,thingid:thingid},function(data){
		if(data>0){
			alert("下单成功");
			$("#thing").css("display","none");
			$("#back").css("display","none");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/car/getAllCar'});
		}else{
			alert("下单失败");
		}
	});
}

function initTable2() {
	$('#tb_mything').bootstrapTable({
		url : '/graduate/thing/getAllMyThing', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		dataType : "json",
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : queryParams2,// 传递参数（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "thingid", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'departure',
			title : '发货地'
		}, {
			field : 'destination',
			title : '收货地'
		}, {
			field : 'thingName',
			title : '货物名称'
		}, {
			field : 'thingtype',
			title : '货物类型'
		}, {
			field : 'weight',
			title : '货物重量(吨)'
		},{
			field : 'companyName',
			title : '公司名称'
		},{
			field : 'releaseTime',
			title : '发货时间'
		},{
			field : 'thingid',
			title : '操作',
			formatter:function(value, row, x){
				return '<button class="btn" onclick="sure('+value+')">确定</button>';
			}
		}]
	});
	
};
	 

function queryParams2(params) {
	return {
		pageNumber : params.offset,
		pageSize : params.limit
	};
}

function cancel(){
	$("#thing").css("display","none");
	$("#back").css("display","none");
}