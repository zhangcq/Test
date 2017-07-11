var scardid;
$(function () {
	initTable();
	
	$("#btn_query").bind("click",function(){
		$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/card/getAllCard?cardNum='+encodeURI(encodeURI($("#txt_search_cardNum").val()))+'&uname='+encodeURI(encodeURI($("#txt_search_uname").val()))+'&cardType='+encodeURI(encodeURI($("#txt_search_cardType").val()))});
	});
	
	$('#btn_add').bind("click",function(){
		$("#add").css("display","block");
		$("#back").css("display","block");
	});
	
	$('#btn_edit').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			$("#edit").css("display","block");
			$("#back").css("display","block");
			for(var i=1;i<=2;i++){
				if($("select").children('option').eq(i).html() == $(".selected").children('td').eq(5).children("span").html()){
					$("select").val($(".selected").children('td').eq(5).children("span").html());
				}
			}
		}else{
			alert("请选择一个对象");
		}
	});
	
	$('#btn_delete').bind("click",function(){
		if(typeof($(".selected").attr("data-uniqueid"))!='undefined'){
			var cardId = $(".selected").attr("data-uniqueid");
			$.post("/graduate/card/deleteCard",{cardId:cardId},function(data){
				if(data>0){
					alert("删除成功");
					$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/card/getAllCard'});
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
	$("#recharge").css("display","none");
	$("#add-uname").val("");
	$("#add-companyName").val("");
	$("#edit-cardType").val("");
	$("#recharge-money").val("");
}
 
function initTable() {
	$('#tb_departments').bootstrapTable({
		url : '/graduate/card/getAllCard', // 请求后台的URL（*）
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
		uniqueId : "cardId", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'cardNum',
			title : '卡号'
		}, {
			field : 'uname',
			title : '持卡人姓名'
		}, {
			field : 'companyName',
			title : '持卡人所在公司'
		}, {
			field : 'balance',
			title : '卡内余额',
		},{
			field : 'cardType',
			title : '卡类型',
			formatter:function(value, row, x){
				if(value == 1){
					return '<span >长期卡</span>';	
				}else{
					return '<span >临时卡</span>';	
				}
			}
		},{
			field : 'cardId',
			title : '操作',
			formatter:function(value, row, x){
				return '<button class="btn" onclick="recharge('+value+')">充值</button>';
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
function add(){
	var uname=$("#add-uname").val();
	var companyName=$("#add-companyName").val();
	var cardType=$("#add-cardType").val();
	if(cardType =="临时卡"){
		cardType=0;
	}else{
		cardType=1;
	}
	$.post("/graduate/card/addCard",{uname:uname,companyName:companyName,cardType:cardType},function(data){
		if(data>0){
			alert("添加成功");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-uname").val("");
			$("#add-companyName").val("");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/card/getAllCard'});
		}else{
			alert("添加失败");
			$("#add").css("display","none");
			$("#back").css("display","none");
			$("#add-uname").val("");
			$("#add-companyName").val("");
		}
	});
}
function edit(){
	var cardId = $(".selected").attr("data-uniqueid");
	var cardType=$("#edit-cardType").val();
	if(cardType =="临时卡"){
		cardType=0;
	}else{
		cardType=1;
	}
	$.post("/graduate/card/editCard",{cardId:cardId,cardType:cardType},function(data){
		if(data>0){
			alert("修改成功");
			$("#edit").css("display","none");
			$("#back").css("display","none");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/card/getAllCard'});
		}else{
			alert("修改失败");
			$("#edit").css("display","none");
			$("#back").css("display","none");
		}
	});
}

function recharge(cardId){
	scardid=cardId;
	$("#recharge").css("display","block");
	$("#back").css("display","block");
}

function rechargeOk(){
	var money=$("#recharge-money").val();
	$.post("card/recharge",{cardId:scardid,money:money},function(data){
		if(data>0){
			alert("充值成功");
			$("#recharge").css("display","none");
			$("#back").css("display","none");
			$('#tb_departments').bootstrapTable('refresh',{url:'/graduate/card/getAllCard'});
		}else{
			alert("充值失败");
		}
	});
}