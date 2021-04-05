<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 상품 보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- jquery CDN 연동 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function init() {
		$("input[name=select]").prop("checked", false);
	}
	
	function next(){
		var form=document.createElement('form');
        form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "post");
		form.setAttribute("action", "selection");
		
		var obj = $("[name=select]");
        var chkArray = new Array(); // 배열 선언
 
        $('input:checkbox[name=select]:checked').each(function() { 
            chkArray.push(this.value);
        	console.log(this.value);
        });
        
        if(chkArray.length==0) {
        	alert("1개 이상의 상품을 선택하세요!"); 
			event.preventDefault(); // 멈춰줌
        }
        else{
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "select");
            hiddenField.setAttribute("value", chkArray);
            form.appendChild(hiddenField);
        	document.body.appendChild(form);
        	console.log(form);
        	form.submit();
        }
	}
</script>
</head>
<body>
	<div class="container text-center">
		<h2 class="text-center">내게 맞는 요금제 찾기</h2>
		<br>
		<div class="checkbox_group">
			<input type="checkbox" name="select" id="select" class="normal" value="tv">
			 <label	for="check_1">TV&nbsp;</label> 
			<input type="checkbox" name="select" id="select" class="normal" value="internet"> 
			<label for="check_2">인터넷&nbsp;</label>
			 <input	type="checkbox" name="select" id="select" class="normal" value="mobile"> 
			 <label	for="check_3">모바일&nbsp;</label>
		</div>
		<button type="button" class="btn btn-default" onclick="init()">다시 선택하기</button>
		<button type="submit" class="btn btn-default" onclick="next()">다음</button>
	</div>
	<br>
</body>

</html>