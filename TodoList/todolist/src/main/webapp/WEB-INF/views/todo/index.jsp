<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>To Do List - HoSeong -</title>
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/slick.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/templatemo-style.css">
<Link rel="stylesheet" href="/resources/css/diary.css">
<script src='fullcalendar/dist/index.global.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth'
		});
		calendar.render();
	});
</script>
<script src='/resources/js/index.global.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');

		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : '2023-01-10',
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectMirror : true,
			select : function(arg) {
				var title = prompt('추가할 내용을 적어주세요 :');
				if (title) {
					calendar.addEvent({
						title : title,
						start : arg.start,
						end : arg.end,
						allDay : arg.allDay
					})
				}
				calendar.unselect()
			},
			eventClick : function(arg) {
				if (confirm('지우시겠습니까?')) {
					arg.event.remove()
				}
			},
			editable : true,
			dayMaxEvents : true
		// allow "more" link when too many events
		});

		calendar.render();
	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
<!--
    
TemplateMo 560 Astro Motion

https://templatemo.com/tm-560-astro-motion

-->
</head>
<body>
	<video autoplay muted loop id="bg-video">
		<source src="/resources/video/gfp-astro-timelapse.mp4"
			type="video/mp4">
	</video>
	<div class="page-container">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<div class="cd-slider-nav">
						<nav class="navbar navbar-expand-lg" id="tm-nav">
							<a class="navbar-brand" href="#">Kwag Ho Seong</a>
							<button class="navbar-toggler" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#navbar-supported-content"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse"
								id="navbar-supported-content">
								<ul class="navbar-nav mb-2 mb-lg-0">
									<li class="nav-item selected"><a class="nav-link"
										aria-current="page" href="#0" data-no="1">Welcome</a>
										<div class="circle"></div></li>
									<li class="nav-item"><a class="nav-link" href="#1"
										data-no="2">일정표</a>
										<div class="circle"></div></li>
									<li class="nav-item"><a class="nav-link" href="#2"
										data-no="3">일기장</a>
										<div class="circle"></div></li>

								</ul>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid tm-content-container">
			<ul class="cd-hero-slider mb-0 py-5">
				<li class="px-3" data-page-no="1">
					<div class="page-width-1 page-left">
						<div
							class="d-flex position-relative tm-border-top tm-border-bottom intro-container">
							<div class="intro-left tm-bg-dark">
								<h2 class="mb-4">환영합니다 ! 오늘은 어떠한 일정이 있는지 확인해볼까요 ?</h2>
								<p class="mb-4">일 정 표 : 오늘의 일정은 무엇이 있는지 확인해봅시다.</p>
								<p class="mb-0">일 기 장 : 나의 일상을 글과 사진으로 기록함으로써 과거의 기록을 확인할 수
									있고 미래 계획을 세울 수 있습니다.</p>
							</div>
							<div class="intro-right">
								<img src="/resources/img/뽀로로.png" alt="Image"
									class="img-fluid intro-img-1"> <img
									src="/resources/img/home-img-2.jpg" alt="Image"
									class="img-fluid intro-img-2">
							</div>
							<div class="circle intro-circle-1"></div>
							<div class="circle intro-circle-2"></div>
							<div class="circle intro-circle-3"></div>
							<div class="circle intro-circle-4"></div>
						</div>
						<div class="text-center">
							<a href="#0" data-page-no="2"
								class="btn btn-primary tm-intro-btn tm-page-link"> 일정표 보러가기
							</a>
						</div>
					</div>
				</li>
				<li data-page-no="2">
					<div
						class="position-relative page-width-1 page-right tm-border-top tm-border-bottom">
						<div class="circle intro-circle-1"></div>
						<div class="circle intro-circle-2"></div>
						<div class="tm-bg-dark content-pad">
							<h2 class="mb-4">일 정 표</h2>

							<div id='calendar'></div>

						</div>
						<div class="circle intro-circle-3"></div>
						<div class="circle intro-circle-4"></div>
					</div>
				</li>
				<li data-page-no="3" class="px-3">
					<div
						class="position-relative page-width-1 page-right tm-border-top tm-border-bottom">
						<div class="circle intro-circle-1"></div>
						<div class="circle intro-circle-2"></div>
						<div class="tm-bg-dark content-pad">

							<div id="wrap">
								<h1>일기장</h1>
								<table class="list">
									<tr>
										<td colspan="6" style="border: white; text-align: right">
											<a href="">일 기 쓰 기</a>
										</td>
									</tr>
									<tr>
										<th>번 호</th>
										<th>진행 여부</th>
										<th>제 목</th>
										<th>등록 일자</th>
										<th>수정 일자</th>
									</tr>
									<c:forEach var="todo" items="${todo}">
										<tr>
											<td><c:out value="${todo.no }" /></td>
											<td><c:choose>
													<c:when test="${todo.clear.equals(0) }">
										도전중
									</c:when>
													<c:when test="${todo.clear.equals(1)}">
										성공
									</c:when>
													<c:otherwise>
										실패
									</c:otherwise>
												</c:choose></td>
											<td><a class="move" href="${todo.no }"><c:out
														value="${todo.title }" /></a></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd"
													value="${todo.regDate }" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd"
													value="${todo.updateDate }" /></td>
										</tr>
									</c:forEach>

								</table>
								<!-- <div class="row">
								<div class="col-lg-12">
									<form id="searchForm" action="/todo/list" method="get">
									
									</form>
								</div>
							</div> -->

							</div>
							<div class="text-center">
								<a href="#0" data-page-no="4"
									class="btn btn-primary tm-intro-btn tm-page-link"> 쓰러가기 </a>
							</div>
						</div>
						<div class="circle intro-circle-3"></div>
						<div class="circle intro-circle-4"></div>
					</div>
				</li>
				<li class="px-3" data-page-no="4">
					<div
						class="position-relative page-width-1 page-right tm-border-top tm-border-bottom">
						<div class="circle intro-circle-1"></div>
						<div class="circle intro-circle-2"></div>
						<div class="tm-bg-dark content-pad">

							<div id="wrap">
								<h1>일기장</h1>
								<table class="list">
									<tr>
										<th>페이지 넘버</th>
										<td>1</td>
										<th>제   목</th>
										<td colspan="8">임시 제목</td>
									</tr>
									<tr>
										<th>진행 여부</th>
										<td> 진행중 <%-- <c:choose>
													<c:when test="${todo.clear.equals('0')}">
										도전중
									</c:when>
													<c:when test="${todo.clear.equals('1')}">
										성공
									</c:when>
													<c:otherwise>
										실패
									</c:otherwise>
										</c:choose> --%></td>										
										<th>시작 일자</th>
										<td colspan="2"><%-- ${todo.startDate} --%>2023-01-13</td>
										<th>종료 일자</th>
										<td colspan="2"><%-- ${todo.endDate } --%>2023-01-13</td>
									</tr>	
									<tr>
										<th>등록 일자</th>
										<td colspan="2">2023-01-13<%--<fmt:formatDate pattern="yyyy-MM-dd"
													 value="${todo.regDate }"  />--%></td>
										<th>수정 일자</th>
										<td colspan="4">2023-01-13<%-- <fmt:formatDate pattern="yyyy-MM-dd"
											value="${todo.updateDate }" /> --%></td>
									</tr>
									<tr>
										<th rowspan="8">내 용</th>
										<td rowspan="8" colspan="25">운동을했다<%-- ${todo.content } --%></td>
									</tr>
									<tr>
										<th rowspan="8">추 가 내 용</th>
										<td rowspan="8" colspan="25">운동을했다<%-- ${todo.mycontent } --%></td>
									</tr>

								</table>
							</div>
							<div class="text-center">
								<a href="#0" data-page-no="5"
									class="btn btn-primary tm-intro-btn tm-page-link"> 수정하기 </a>
								<a href="#0" data-page-no="6"
									class="btn btn-primary tm-intro-btn tm-page-link"> 삭제하기 </a>
								<a href="#0" data-page-no="3"
									class="btn btn-primary tm-intro-btn tm-page-link"> 목록돌아가기 </a>
							</div>
						</div>
						<div class="circle intro-circle-3"></div>
						<div class="circle intro-circle-4"></div>
					</div>
				</li>
				<li class="px-3" data-page-no="5">
					<div
						class="position-relative page-width-1 page-right tm-border-top tm-border-bottom">
						<div class="circle intro-circle-1"></div>
						<div class="circle intro-circle-2"></div>
						<div class="tm-bg-dark content-pad">

							<div id="wrap">
								<h1>수정하기</h1>
								<table class="list">
								
									

								</table>
							</div>
							<div class="text-center">
								<a href="#0" data-page-no="5"
									class="btn btn-primary tm-intro-btn tm-page-link"> 수정 등록 </a>
							</div>
							<div class="text-center">
								<a href="#0" data-page-no="6"
									class="btn btn-primary tm-intro-btn tm-page-link"> 다시 쓰기 </a>
							</div>
							<div class="text-center">
								<a href="#0" data-page-no="3"
									class="btn btn-primary tm-intro-btn tm-page-link"> 목록돌아가기 </a>
							</div>
						</div>
						<div class="circle intro-circle-3"></div>
						<div class="circle intro-circle-4"></div>
					</div>
				</li>


			</ul>
		</div>
		<div class="container-fluid">
			<footer class="row mx-auto tm-footer">
				<div class="col-md-6 px-0">Copyright 2021 Astro Motion Company
					Limited. All rights reserved.</div>
				<div class="col-md-6 px-0 tm-footer-right">
					Designed by <a rel="sponsored" href="https://templatemo.com"
						target="_blank" class="tm-link-white">TemplateMo</a>
				</div>
			</footer>
		</div>
	</div>
	<!-- Preloader, https://ihatetomatoes.net/create-custom-preloading-screen/ -->
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var result = '<c:out value="${result}"/>';

							checkModal(result);
							history.replaceState({}, null, null); // 주소창의 데이터를 한번 삭제해서 다시 안뜨게끔함
							function checkModal(result) {
								if (result === '' || history.state) {
									return;
								}
								if (parseInt(result) > 0) {
									$(".modal.body").html(
											"게시글 " + parseInt(result)
													+ "번 글이 등록되었습니다.");
								}
								$("#myModal").modal("show");
							}
							$("#regBtn").on("click", function() {
								self.location = "/todo/register";
							});
							var actionForm = $("#actionForm");
							$(".paginate_button a").on(
									"click",
									function(e) {
										e.preventDefault();
										console.log('click');
										actionForm
												.find("input[name='pageNum']")
												.val($(this).attr("href"));
										actionForm.submit();
									})

							$(".move")
									.on(
											"click",
											function(e) {
												e.preventDefault();
												actionForm
														.append("<input type='hidden' name='no' value='"
																+ $(this).attr(
																		"href")
																+ "'>");
												actionForm.attr("action",
														"/todo/get");
												actionForm.submit();
											})
							var searchForm = $("#searchForm");

							$("#searchForm button")
									.on(
											"click",
											function(e) {
												if (!searchForm.find(
														"option:selected")
														.val()) {
													alert("무엇을 검색할지 선택해주세요.");
													return false;
												}
												if (!searchForm
														.find(
																"input[name='keyword']")
														.val()) {
													alert("키워드를 입력해주세요.");
													return false;
												}
												searchForm
														.find(
																"input[name='pageNum']")
														.val("1");
												e.preventDefault();
												searchForm.submit();
											});
						})
	</script>
	<script src="/resources/js/jquery-3.5.1.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/slick.js"></script>
	<script src="/resources/js/templatemo-script.js"></script>
</body>
</html>