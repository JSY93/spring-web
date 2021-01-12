<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<div id='content'>
<h3>[ ${vo.name} ] 고객정보수정</h3>
<table class='w-pct40'>
<tr><th class='w-px120'>성별</th>
	<td><label><input type='radio' ${vo.gender eq '남' ? 'checked':''} name='gender' value='남' />남</label>
		<label><input type='radio' ${vo.gender eq '여' ? 'checked':''} name='gender' value='여' />여</label>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email' value='${vo.email}'/></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone' value='${vo.phone}'/> </td>
</tr>

</table>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>