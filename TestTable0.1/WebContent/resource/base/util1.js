(function() {
	$$.util = {
		location : function(url, parameter) {
			if(parameter && typeof parameter === 'object' && !(parameter instanceof Array)) {
				var para = [];
				var i = 0;
				for(var key in parameter) {
					var value = parameter[key];
					if(value) {
						para[i++] = key + '=' + value;
					}
				}
				url += "?" + para.join("&");
			}
			return url;
		}, 
		
		urlToObj : function(location) {
			if(typeof location === 'undefined' || typeof location.search === 'undefined') {
				return null;
			}
			var search = decodeURIComponent(location.search);
			var infoList = search.substring(1).split("?");
			var res = {};
			for(var i = 0; i < infoList.length; i++) {
				var info = infoList[i].split("=");
				res[info[0]] = info[1];
			}
			
			return res;
		},
		
		_checkArg : function(arg, express, errMsg) {
			if(typeof arg === 'string' || typeof arg !== 'string' && arg.indexOf(".") == -1 || express) {
				throw new Error(errMsg);
			}
			var names = arg.split(".");
			if(!$$[names[0]]) {
				throw new Error("工程[" + names[0] + "]不存在！");
			}
			if(!$[names[0]][names[1]]) {
				throw new Error("工程[" + names[0] + "]下的项目[" + names[1] + "]不存在！");
			}
			return names;
		},
		
		getIdSet : function(objName, doc) {
			var names = $$.util._checkArg(objectName, false, "getIdSet()用法：\ngetIdSet(<工程名.项目名>[, document])");
			var projectName = names[0];
			var objectName = names[1];
			
			doc = doc || document;
			var allEle = doc.all;
			
			var view = {};
			for(var ele in allEle) {
				if(allEle[ele].id) {
					view[allEle[ele].id] = $$[projectName][objectName].view[allEle[ele].id] || {element : allEle[ele]};//TODO 这个短路运算看不懂
				}
			}
			$$[projectName][objectName].view = view;
		},
		
		getId : function(objectName, idName) {
			var errMsg = "getId()用法：getId(<工程名.项目名>, 元素id)";
			var names = $$.util._checkArg(objectName, typeof idName !== 'string', errMsg);
			var projectName = names[0];
			var objectName = names[1];
			
			var ele = $$[projectName][objectName].view[idName];
			if(ele) {
				return ele.element;
			}
			return null;
		},
		
		getIdObj : function(objectName, idName) {
			var errMsg = "getIdObj()用法:getIdObj(<工程名.项目名.元素id>)";
			
			var names = $$.util._checkArg(objectName, typeof idName !== 'string', errMsg);
			var projectName = names[0];
			var objectName = names[1];
			var elementIdName = names[2];
			
			if(typeof elementIdName == 'undefined') {
				throw new Error(errMsg);
			}
			return $$[projectName][objectName].view[idName];
		},
		
		setElementAction : function(elementId, action) {
			var errMsg = "setElementAction()的用法：setElementAction(<工程名.项目名.元素id>, <元素基本操作名称>)";
			var names = $$.util._checkArg(elementId, typeof action !== 'object', errMsg);
			var projectName = names[0];
			var objectName = names[1];
			var elementIdName = names[2];
			
			if(typeof elementIdName == 'undefined') {
				throw new Error(errMsg);
			}
			
			for(var act in action) {
				var ele = $$[projectName][objectName].view[elementIdName];
				if(ele) {
					ele[act] = action[act];
				}
			}
		},
		
		getElementAction : function(elementId, actionName) {
			var errMsg = "getElmentAction()用法：getElmentAction(<工程名.项目名.元素id>, <元素基本操作对象>)";
			var names = $$.util._checkArg(elementId, typeof actionName !== 'string', errMsg);
			var projectName = names[0];
			var objectName = names[1];
			var elementIdName = names[2];
			
			if(typeof elementIdName == 'undefined') {
				throw new Error(errMsg);
			}
			
			return $$[projectName][objectName].view[elementIdName][actionName];
		},
		
		setAction : function(objName, action) {
			var errMsg = "setAction(<工程名称.项目名称.action名称>, action)";
			var names = $$.util._checkArg(objName, typeof action !== 'function', errMsg);
			var projectName = names[0];
			var objectName = names[1];
			var actionName = names[2];
			
			if(typeof actionName == 'undefined') {
				throw new Error(errMsg);
			}
			
			$$[projectName][objectName].controll[actionName] = action;
		},
		
		getAction : function(actionName) {
			var errMsg = "getAction()用法：getAction(<工程名.项目名.action名>)";
			var names = $$.util._checkArg(actionName, false, errMsg);
			var projectName = names[0];
			var objectName = names[1];
			var actionName = names[2];//会覆盖参数的actionName
			
			if(typeof actionName == 'undefined') {
				throw new Error(errMsg);
			}
			
			return $$[projectName][objectName].controll[actionName];
		}
	}
})();