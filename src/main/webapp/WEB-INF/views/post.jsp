<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>me2day comments thread</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le styles -->
<link href="/resources/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	background: #39414A;
}

ul {
	list-style: none;
}

.pubDate {
	color: green;
	font-size: 9px;
}

.outline {
	background: #181C21;
	border: 1px solid black;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	margin: 0px;
	padding: 20px;
}

.inline {
	background: #fff;
	border: 1px solid #e0e0e0;
	padding: 20px;
	margin: 0px;
}

</style>

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- <script id="DragSearchJs" type="text/javascript" src="http://s1.daumcdn.net/img.search/front/js/searchDragSelection.js?nil_ch=tistory" charset="euc-kr"></script>-->
</head>

<body>

	<div class="topbar">
		<div class="topbar-inner">
			<div class="container-fluid">
				<a class="brand" href="#">me2day 댓글 글타래</a>
				<ul class="nav">
					<li><span class="label notice">postId 입력</span> <input id="postId"
						type="text" value="pyqh71a-weub" /></li>
				</ul>
				<p class="pull-right">
					<a href="#" id="nickname">username</a><span class="label notice"> 의 미투데이</span>
				</p>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="sidebar">
			<div class="well"></div>
		</div>
		<div class="content">
			<!-- Main hero unit for a primary marketing message or call to action -->
			<div class="hero-unit">
				<h1 id="body"></h1>
				<p></p>
				<!-- 
				<p>
					<a class="btn primary large">Learn more &raquo;</a>
				</p>
				 -->
			</div>
			<!-- Example row of columns -->
			<div class="row">
				<ul id="comments">
				<!-- 
					<li>
						<div class="outline" onclick="toggle(this)">
							<span class="label">Bryan</span> <br /> <span class="body">일등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>
						<ul id="subcomment" class="hidden">
							<li>
								<div class="inline">
									<span class="label">Daren</span> <br /> <span class="_body"><a
										href="#">Bryan</a> 늦었다</span> <font class="pubDate">오전 3시 44분</font>
									<span class="mention"></span>
								</div>
							</li>
							<li>
								<div class="inline">
									<span class="label">Bryan</span> <br /> <span class="_body"><a
										href="#">Daren</a> ㅋㅋ</span> <font class="pubDate">오전 3시 44분</font> <span
										class="mention"></span>
								</div>
							</li>
						</ul>
					</li>
					<li>
						<div class="outline">
							<span class="label">Charles</span> <br /> <span class="_body">이등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>
					</li>
					<li>
						<div class="outline">
							<span class="label">Daren</span> <br /> <span class="_body">일등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>

					</li>
				 -->
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function toggle(elem) {
			$(elem).next().toggle();
		}
		
		$('#postId').keypress(function(e) {
	      if(e.which == 13) {
				request();
			}
		});
		
		function request() {
			var postId = $('#postId').val();
			if (postId == '') {
				return;
			}
			
			$.getJSON('/postId/' + postId, function(data) {
				var items = [];

				$.each(data, function(key, val) {
					if (key == 'nickname') {
						$('#nickname').html(val);
					}
					if (key == 'body') {
						$('#body').html(val);
					}
					if (key == 'commentMap') {
						for (var i=0; i<Object.keys(val).length; i++) {
							
							var author = val[Object.keys(val)[i]][0].author;
							var nickname = val[Object.keys(val)[i]][0].nickname;
							var body = val[Object.keys(val)[i]][0].body;
							
							var tmp = '<li>';
							tmp += '<div class="outline" onclick="toggle(this)">';
							
							tmp += '<span class="label">'+nickname+'</span><br/>';
							tmp += '<span class="body">'+body+'</span><font class="pubDate"></font><span class="mention"></span>';
							tmp += '</div>';
							
							if (val[Object.keys(val)[i]].length > 1) {
								var id = Object.keys(val)[i].toString();
								tmp += '<ul class="hidden" id="'+id+'">';
								$('#comments').append();
								for(var j=1; j<val[Object.keys(val)[i]].length; j++) {
									var author = val[Object.keys(val)[i]][j].author;
									var nickname = val[Object.keys(val)[i]][j].nickname;
									var body = val[Object.keys(val)[i]][j].body;
									
									tmp += '<li><div class="inline"><span class="label">'
									+nickname+'</span><br/><span class="body">'+body+'</span><font class="pubDate"></font><span class="mention"></span></div></li>';
								}
								tmp += '</ul>';
								$('#comments').append(tmp);
							}
							
								
								
								
								/*
								<li>
									<ul id="subcomment">
										<li>
											<div class="well">
												<span class="label">Daren</span> <br /> <span class="_body"><a
													href="#">Bryan</a> 늦었다</span> <font class="pubDate">오전 3시 44분</font>
												<span class="mention"></span>
											</div>
										</li>
										<li>
											<div class="well">
												<span class="label">Bryan</span> <br /> <span class="_body"><a
													href="#">Daren</a> ㅋㅋ</span> <font class="pubDate">오전 3시 44분</font> <span
													class="mention"></span>
											</div>
										</li>
									</ul>
								</li>
								*/
						}
						
						$('.hidden').hide();
							
					}
					items.push('<li id="' + key + '">' + val + '</li>');
				});

				/*
				$('<ul/>', {
					'class' : 'my-new-list',
					html : items.join('')
				}).appendTo('body');
				*/
			});

		}
		
		$(document).ready(function() {
			request();
		});
		
		$('.inline').dblclick(function() {
			var userSelection = null;
			if (window.getSelection) {
				userSelection = window.getSelection();
			}
			else if (document.selection) { // should come last; Opera!
				userSelection = document.selection.createRange();
			}
			
			alert(userSelection);
		});
		
	</script>
</body>
</html>
