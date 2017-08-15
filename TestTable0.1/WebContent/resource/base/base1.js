(function() {
	if(typeof $$ === 'undefined') {
		mecProject = {
			html : {},
			error : {},
			includeMec : function(projectName) {//检测工程是否存在，不存在就新建工程，开闭，为了给mecProject添加工程，防止命名空间冲突
				if(typeof projectName === 'undefined' || typeof projectName !== 'string') {
					return;
				}
				
				if($$[projectName]) {
					throw new Error("工程名[" + projectName + "]已经存在！");
				}
				
				$$[projectName] = {};
			},
			mkObj : function(projectName, objectName) {
				if(arguments.length < 1 || arguments.length > 2 
						|| arguments.length == 1 && projectName.indexOf == -1) {
					var errMsg = "mkObj用法:\n";
					errMsg += "mkObj(<工程名称>, <项目名称>),或mkObj(<工程名称.项目名称>);";//提供两种建立工程的方法
					throw new Error(errMsg);
				}
				
				if(objectName === 'undefined') {//使用mkObj(<工程名称.对象名称>)来建立工程
					var names = projectName.split(".");
					projectName = names[0];
					objectName = name[1];
				}
				
				if(!$$[projectName]) {//检测工程是否存在，不存在就新建
					this.includeMec(projectName);
				}
				
				var project = $$[projectName];//给mecProject添加一个工程
				if(project[objectName]) {
					return;
				}
				
				project[objectName] = {
					controll : {},
					service : {},
					view : {},
					model : {}
				};
			}
		}
		$$ = mecProject;
	}
})()