var scarid;
$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/order/getAllMyOrder?departure='+encodeURI(encodeURI($("#txt_search_departure").val()))+'&destination='+encodeURI(encodeURI($("#txt_search_destination").val()))+'&orderNum='+encodeURI(encodeURI($("#txt_search_orderNum").val()))});
	});
	
});
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/order/getAllMyOrder', // 请求后台的URL（*）
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
		uniqueId : "orderId", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'orderNum',
			title : '订单号'
		},{
			field : 'thingName',
			title : '货物名称'
		},{
			field : 'thingType',
			title : '货物类型'
		},{
			field : 'thingWeight',
			title : '货物重量(吨)'
		},{
			field : 'carType',
			title : '车辆类型'
		},{
			field : 'departure',
			title : '出发地'
		}, {
			field : 'destination',
			title : '目的地'
		}, {
			field : 'releaseTime',
			title : '发货时间'
		}, {
			field : 'thingOwner',
			title : '货主'
		},{
			field : 'thingOwnerCompany',
			title : '货主公司名称'
		},{
			field : 'carOwner',
			title : '车主'
		},{
			field : 'carOwnerCompany',
			title : '车主公司名称'
		},{
			field : 'orderId',
			title : '操作',
			formatter:function(value, row, x){
				return '<button class="btn" onclick="cancel('+value+')">取消</button>';
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

function cancel(orderId){
	$.post("order/deleteOrder",{orderId:orderId},function(data){
		if(data>0){
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/order/getAllMyOrder?departure='+encodeURI(encodeURI($("#txt_search_departure").val()))+'&destination='+encodeURI(encodeURI($("#txt_search_destination").val()))+'&orderNum='+encodeURI(encodeURI($("#txt_search_orderNum").val()))});
			alert("取消订单成功");
		}else{
			alert("取消订单失败");
		}
		
	});
}