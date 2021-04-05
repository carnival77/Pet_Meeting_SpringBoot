<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 상품 보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- jquery CDN 연동 -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
<script type="text/javascript">	

	$(document).ready(function() {
		$("#tv_deselect").click(function() {
			if ($("#tv_deselect").prop("checked")) {
				$("input[name=tv_ser]").prop("checked", false);
			} 
		});
		$("input[name=tv_ser]").click(function() {
			$("#tv_deselect").prop("checked", false);
		});
	});
	
	

	// 데이터 슬라이드바
	$(function() {
		$("#data_slider").slider({
			value : 0,
			min : 0,
			max : 25,
			step : 5,
			slide : function(event, ui) {
					$("#data_amount").val(ui.value);
			}
		});
		$("#data_amount").val($("#data_slider").slider("value"));
	});

	//통화량 슬라이드바
	$(function() {
		$("#voice_slider").slider({
			value : 0,
			min : 0,
			max : 500,
			step : 100,
			slide : function(event, ui) {
				$("#voice_amount").val(ui.value);
			}
		});
		$("#voice_amount").val($("#voice_slider").slider("value"));
	});
	
	function go_back(){
		location.href="selection";
	}
</script>

</head>
<body>
	<div class="container text-center">
		<h2 class="text-center">내게 맞는 요금제 찾기</h2>
		<form action="submit" method="post">
			<br>
			<h3>연 령</h3>
			<div class="radio">
				<label class="radio-inline"> <input type="radio" name="age"
					value="20" checked> 20대 이하
				</label> <label class="radio-inline"> <input type="radio" name="age"
					value="30"> 30대
				</label> <label class="radio-inline"> <input type="radio" name="age"
					value="40"> 40대
				</label> <label class="radio-inline"> <input type="radio" name="age"
					value="50"> 50대
				</label> <label class="radio-inline"> <input type="radio" name="age"
					value="60"> 60대 이상
				</label>
			</div>
			<br />
			<h3>가족 구성원(수)</h3>
			<div class="radio">
				<label class="radio-inline"> <input type="radio"
					name="family" value="1" checked> 1명
				</label> <label class="radio-inline"> <input type="radio"
					name="family" value="2"> 2명
				</label> <label class="radio-inline"> <input type="radio"
					name="family" value="3"> 3명
				</label> <label class="radio-inline"> <input type="radio"
					name="family" value="4"> 4명
				</label> <label class="radio-inline"> <input type="radio"
					name="family" value="5"> 5명 이상
				</label>
			</div>
			<br />

			<c:forEach var="data" items="${product}">
			<c:if test="${data eq 'tv'}">
			<div class="TV" style="padding: 30px;">
				<h3>TV</h3>
				<div class="radio">
					<font size="4.5em">약정 : </font> <label class="radio-inline"
						style="margin-left: 25px;"> <input type="radio" name="tv_due"
						value="3" checked="checked"> 3년
					</label> <label class="radio-inline" style="margin-left: 25px;"> <input
						type="radio" name="tv_due" value="5"> 5년
					</label>
				</div>
				<div class="checkbox">
					<font size="4.5em">부가서비스 : </font> <label class="checkbox-inline"
						style="margin-left: 25px;"> <input type="checkbox"
						name="tv_deselect" id="tv_deselect" checked>해당 없음
					</label> <label class="checkbox-inline" style="margin-left: 25px;">
						<input type="checkbox" name="tv_ser" value="vod">VOD 서비스를 자주
						이용한다.
					</label> <label class="checkbox-inline" style="margin-left: 25px;">
						<input type="checkbox" name="tv_ser" value="spotv">스포츠 경기를
						즐겨본다.
					</label> <label class="checkbox-inline" style="margin-left: 25px;">
						<input type="checkbox" name="tv_ser" value="키즈">어린이 전용 채널을
						자주 이용한다.
					</label> <label class="checkbox-inline" style="margin-left: 25px;">
						<input type="checkbox" name="tv_ser" value="wavve">WAVVE or 왓챠
						이용 중이다.
					</label>
				</div>
				<br />
			</div>
			</c:if>

			<c:if test="${data eq 'internet'}">
			<div class="Internet" style="padding: 30px;">
				<h3>인터넷</h3>
				<div class="radio">
					<font size="4.5em">속도 : </font> <label class="radio-inline"
						style="margin-left: 25px;"> <input type="radio" name="itn_speed"
						value="100" checked> SKY 100M
					</label> <label class="radio-inline"> <input type="radio"
						name="itn_speed" value="200"> SKY GIGA 200M
					</label><label class="radio-inline"> <input type="radio" name="itn_speed"
						value="500"> SKY GIGA 500M
					</label><label class="radio-inline"> <input type="radio" name="itn_speed"
						value="1000"> SKY GIGA 1G
					</label>
				</div>
				<br />
			</div>
			</c:if>
			
			<c:if test="${data eq 'mobile'}">
			<div class="Mobile" style="padding: 30px;">
				<h3>모바일</h3>
				<div class="inputdata" style="float: left; margin-left: 200px;">
					<p>
						<label for="data_amount">데이터 :</label> <input type="text"
							id="data_amount" name="mob_data" readonly
							style="border: 0; color: #f6931f; font-weight: bold;"> G(기가)
					</p>
					<div id="data_slider"></div>
				</div>

				<div class="inputvoice" style="float: right; margin-right: 200px;">
					<p>
						<label for="voice_amount">음성 :</label> <input type="text"
							id="voice_amount" name="mob_voice" readonly
							style="border: 0; color: #f6931f; font-weight: bold;"> 분
					</p>

					<div id="voice_slider"></div>
				</div>
				<br />
			</div>
			</c:if>
			</c:forEach>
			
			<div class="button-group" style="padding: 100px;">
				<button type="button" class="btn btn-default"
					onclick="go_back()">이전</button>
				<button type="submit" class="btn btn-default">요금제 조회하기</button>
			</div>
		</form>
	</div>
</body>

</html>