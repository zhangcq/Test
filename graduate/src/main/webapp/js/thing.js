var sthingid;
$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/thing/getAllThing?departure='+encodeURI(encodeURI($("#txt_search_departure").val()))+'&destination='+encodeURI(encodeURI($("#txt_search_destination").val()))+'&releaseTimeBegin='+encodeURI(encodeURI($("#txt_search_releaseTimeBegin").val()))+'&releaseTimeEnd='+encodeURI(encodeURI($("#txt_search_releaseTimeEnd").val()))});
	});
	
	$('.je_Date').jeDate({
		format : 'YYYY-MM-DD'
	}).attr('readonly', 'readonly');
	$('.show-hide').on('click', function() {
		var $slider = $('.slider');
		var flag = $slider.css('display');
		$slider.slideToggle('slow');
		if (flag == 'none') {
			$('.show-hide').html('收起').removeClass('hide-show');
		} else {
			$('.show-hide').html('展开').addClass('hide-show');
		}
	});
	
});
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/thing/getAllThing', // 请求后台的URL（*）
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
			field : 'releaser',
			title : '发布人'
		},{
			field : 'phone',
			title : '联系方式'
		}]
	});
	
};
	 

function queryParams(params) {
	return {
		pageNumber : params.offset,
		pageSize : params.limit
	};
}
