<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel='stylesheet' type='text/css' 
		href='css/common.css?v=<%=new java.util.Date().getTime() %>'>
<header style='border-bottom:1px solid #ccc; padding:15px 0; text-align:left'>
	<div class='category' style='margin-left:100px'>
	<ul>
		<li><a href='<c:url value="/" />'><img src='imgs/hanul.logo.png'/></a></li>
		<li><a class="${category eq 'cu' ? 'active' : ''}" href='list.cu'>고객관리</a></li>
		<li><a class="${category eq 'no' ? 'active' : ''}" href='list.no'>공지사항</a></li>
		<li><a class="${category eq 'bo' ? 'active' : ''}" href='list.bo'>방명록</a></li>
		<li><a class="${category eq 'da' ? 'active' : ''}" href='list.da'>공공데이터</a></li>
	</ul>
	</div>
</header>
<style>
header ul, header ul li { 
	margin:0; padding:0; display:inline }
.category { font-size:18px }
.category li:not(:first-child) { padding-left:30px }
.category li a:hover,
.category li a.active { font-weight:bold; color:#0000cd; }
</style>

<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>






