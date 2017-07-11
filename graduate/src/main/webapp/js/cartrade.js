var sorderId;
$(function () {
	initTable();
});
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/order/getAllOrder', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		dataType : "json",
		/*toolbar : '#toolbar', // 工具按钮用哪个容器
*/		striped : true, // 是否显示行间隔色
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
//				return '<button class="btn" onclick="findCar('+row['carOwnerCompany']+','+row['carType']+','+value+')">进行调度</button>';
				var companyName="'"+row['carOwnerCompany']+"'";
				var carType="'"+row['carType']+"'";
				var orderId = "'"+value+"'";
				return '<button class="btn" onclick="findCar('+companyName+','+carType+','+orderId+')">进行调度</button>';
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

function findCar(companyName,carType,orderId){
	sorderId=orderId;
	$.post("order/findCar",{companyName:companyName,carType:carType},function(data){
		if(data!=""){
			$("#car").css("display","block");
			$("#back").css("display","block");
			$("#txt_carNum").html(data);
		}else{
			alert("您没有登记车辆");
		}
	});
}

function sure(){
	var carNum=$("#txt_carNum").val();
	$.post("car/tradeCar",{orderId:sorderId,carNum:carNum},function(data){
		if(data>0){
			alert("调度成功");
			$("#dispatch").css("display","block");
			$("#car").css("display","none");
		}else{
			alert("调度失败");
		}
	});
}

function cancel(){
	$("#car").css("display","none");
	$("#back").css("display","none");
	$("#dispatch").css("display","none");
	$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/order/getAllOrder'});
}

function print(){
	sorderId=10004;
	window.location.href="/graduate/car/dispatch/"+sorderId;
}
