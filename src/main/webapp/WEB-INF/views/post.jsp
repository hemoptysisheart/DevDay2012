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
}

ul {
	list-style: none;
}

.pubDate {
	color: green;
	font-size: 9px;
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
</head>

<body>

	<div class="topbar">
		<div class="topbar-inner">
			<div class="container-fluid">
				<a class="brand" href="#">me2day 댓글 글타래</a>
				<ul class="nav">
					<!-- 
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
             -->
				</ul>
				<p class="pull-right">
					Logged in as <a href="#">username</a>
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
				<h1>Hello, world!</h1>
				<p>Vestibulum id ligula porta felis euismod semper. Integer
					posuere erat a ante venenatis dapibus posuere velit aliquet. Duis
					mollis, est non commodo luctus, nisi erat porttitor ligula, eget
					lacinia odio sem nec elit.</p>
				<p>
					<a class="btn primary large">Learn more &raquo;</a>
				</p>
			</div>
			<!-- Example row of columns -->
			<div class="row">
				<ul>
					<li>
					<li>
						<div class="well" id="clickme">
							<span class="label">Bryan</span> <br /> <span class="body">일등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>
					</li>
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
					<li>
						<div class="well">
							<span class="label">Charles</span> <br /> <span class="_body">이등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>
					</li>
					<li>
						<div class="well">
							<span class="label">Daren</span> <br /> <span class="_body">일등</span>
							<font class="pubDate">오전 3시 44분</font> <span class="mention"></span>
						</div>

					</li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#subcomment').hide();
			$('#clickme').click(function() {
				$('#subcomment').toggle();
			});
		});
	</script>
</body>
</html>
