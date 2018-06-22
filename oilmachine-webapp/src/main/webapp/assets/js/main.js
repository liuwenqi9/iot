function buttomDialog(msg){
	 layer.open({
		  	title: ['操作提示', 'font-size:18px;']
		   ,type: 1
		   ,area: ['300px', '150px']
		   ,offset: 'rb' //具体配置参考：offset参数项
		   ,content: '<div style="padding: 30px 80px;">'+msg+'</div>'
		   ,time:2000
		   ,anim:2
		 });
}
function confirmDialog(title,event){
	var confirm = layer.confirm(title, {
		  btn: ['确定','关闭'] //按钮
		}, function(){
			var index = layer.load(1, {
				  shade: [0.1,'#fff'] //0.1透明度的白色背景
				});
			layer.close(confirm);
			if(event){
				event();
			}
			layer.close(index);
		});
}

