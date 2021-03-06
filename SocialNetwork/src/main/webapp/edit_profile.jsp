<%@ page import="model.User" %>
<%@ page import="model.UserInfo" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html lang="ru" class="lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html lang="ru" class="lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html lang="ru" class="lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8" />
	<title>Заголовок</title>
	<meta name="description" content="" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="shortcut icon" href="favicon.png" />
	<link rel="stylesheet" href="libs/bootstrap/bootstrap-grid-3.3.1.min.css" />
	<link rel="stylesheet" href="libs/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="libs/fancybox/jquery.fancybox.css" />
	<link rel="stylesheet" href="libs/owl-carousel/owl.carousel.css" />
	<link rel="stylesheet" href="libs/countdown/jquery.countdown.css" />
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/media.css" />
	<link rel="stylesheet" href="libs/magnific_popup/magnific-popup.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<style>
	body{
		background-color: white;
	}
</style>
<body>
<!--[if lt IE 9]>
<script src="libs/html5shiv/es5-shim.min.js"></script>
<script src="libs/html5shiv/html5shiv.min.js"></script>
<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="libs/respond/respond.min.js"></script>
<![endif]-->
<script src="libs/jquery/jquery-1.11.1.min.js"></script>
<script src="libs/jquery-mousewheel/jquery.mousewheel.min.js"></script>
<script src="libs/fancybox/jquery.fancybox.pack.js"></script>
<script src="libs/waypoints/waypoints-1.6.2.min.js"></script>
<script src="libs/scrollto/jquery.scrollTo.min.js"></script>
<script src="libs/owl-carousel/owl.carousel.min.js"></script>
<script src="libs/countdown/jquery.plugin.js"></script>
<script src="libs/countdown/jquery.countdown.min.js"></script>
<script src="libs/countdown/jquery.countdown-ru.js"></script>
<script src="libs/landing-nav/navigation.js"></script>
<script src="libs/magnific_popup/jquery.magnific-popup.js"></script>
<script src="libs/bootstrap/bootstrap.js"></script>
<script src="js/common.js"></script>
<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
<!-- Google Analytics counter --><!-- /Google Analytics counter -->
<header>
	<div class="top_line">
		<div class="logo">
			<div class="col-md-12">
				<div class="top_logo">
					<h1>Social Network</h1>
					<span>for professionals</span>
				</div>
			</div>
		</div>
	</div>
</header>
<%User user=(User)session.getAttribute("user");
	UserInfo userInfo=user.getUserInfo();%>
<div class="sidebar">
	<ul class="list-group">
		<li class="list-group-item"><span class="glyphicon glyphicon-user"></span><a href="/userServlet" class="profile_link">My profile</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-pushpin"></span><a href="edit_profile.jsp" class="profile_link">Edit profile</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-pencil"></span><a href="/dialogServlet?id=<%=user.getId()%>" class="profile_link">Messages</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-eye-open"></span><a href="profiles_list.jsp" class="profile_link">People</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-ok"></span><a href="" class="profile_link">Tasks</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-folder-open"></span><a href="" class="profile_link">Projects</a></li>
		<li class="list-group-item"><span class="glyphicon glyphicon-arrow-left"></span><a href="/signOut" class="profile_link">Sign out</a></li>
	</ul>
</div>
<section >
	<div >
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<h3 class="edit_text">Edit info about you</h3>
					<form method="POST" enctype="multipart/form-data" action="info" class="reg_form">
						<div class="text_holder">
							<span class="edit_row">Enter your name</span >
							<input class="edit_row" type="text" name="name" value="<%=userInfo.getName()%>">
						</div>
						<div class="text_holder">
							<span class="edit_row">Enter your surname</span >
							<input class="edit_row" type="text" name="surname" value="<%=userInfo.getSurname()%>">
						</div>
						<div class="text_holder">
							<span class="edit_row">Enter your birthday</span>
							<input class="edit_row" type="date" name="birthday" value="<%=userInfo.getBirthday()%>">
						</div>
						<div class="text_holder">
							<span class="edit_row">Enter your position</span >
							<input  class="edit_row" type="text" name="position" value="<%=userInfo.getPosition()%>" >
						</div>
						<div class="text_holder">
							<span class="edit_row">Choose your photo</span >
							<input  class="edit_row" type="file" name="photo" accept="image/*">
						</div>
						<div class="edit_button_wrapper"><input type="submit" class="btn btn_log" value="Edit"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
</html>