<%@ page import="model.Dialog" %>
<%@ page import="model.Message" %>
<%@ page import="logic.MessageLogic" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="model.UserInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.User" %>
<%@ page import="logic.UserLogic" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html lang="ru" class="lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html lang="ru" class="lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html lang="ru" class="lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8" />
	<title>Title</title>
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
	<script src="libs/bootstrap/bootstrap.js" ></script>
	<script src="libs/bootstrap/fileInput.js" ></script>
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
	<%
		User user=(User)session.getAttribute("user");
		UserInfo userInfo=user.getUserInfo();
		UserLogic ul=UserLogic.getInstance();
	%>
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
	<%
		User foreignUser=(User)request.getAttribute("user");
		UserInfo foreignInfo=foreignUser.getUserInfo();
	%>
	<section class="messages">
		<div class="message-history">
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<h5>Dialog with <%=foreignInfo.getName()%> <%=foreignInfo.getSurname()%></h5>
						<div class="well-wrapper">
							<%Dialog d= (Dialog)request.getAttribute("dialog");
								MessageLogic messageLogic=MessageLogic.getInstance();
								Collection<Message> messageList=d.getMessages();
								messageLogic.sortByDate(messageList);
								for(Message m:messageList){%>
							<div class="well">
								<div class="message-trumbnail">
									<img src="/imageServlet?id=<%=m.getFrom().getId()%>" alt="" class="message-photo">
									<%  UserInfo ui=m.getFrom().getUserInfo();
										SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
										String date=dt.format(m.getDate());
									%>
									<p class="message-label"><span class="label label-default"><%=ui.getName()%>  <%=ui.getSurname()%> <%=date%></span></p>
								</div>
								<div class="message-context">
									<p class="message-text"><%=m.getText()%></p>
								</div>	
							</div>
							<%}%>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="input-message">
			<form action="/newMessageServlet" method="POST">
				<textarea rows="5" cols="120" name="text" id="" ></textarea>
				<input type="hidden" name="id" value="<%=d.getId()%>">
				<input type="hidden" name="uid" value="<%=foreignUser.getId()%>">
				<input type="submit" class="btn btn_log send_message" value="send">
			</form>
		</div>
	</section>
</body>
</html>