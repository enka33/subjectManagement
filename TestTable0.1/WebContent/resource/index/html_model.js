(function() {
	$$.$setHtml({
		navBar : 
			'<nav class="navbar navbar-default" role="navigation">' +
		    '<div class="container-fluid">' + 
		    '<div class="navbar-header">' + 
		        '<a class="navbar-brand" href="#">²ËÄñ½Ì³Ì</a>' + 
		    '</div>' + 
		    '<div>' + 
		        '<ul class="nav navbar-nav">' + 
		            '!!{termList:<li class="%{active:active}%"><a href="#">%{termName:iOS}%</a></li>}!!' + 
		        '</ul>' + 
		    '</div>' + 
		    '</div>' + 
		'</nav>'
	});
})();