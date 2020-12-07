<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��Ǹ��</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/base/base.css?after">
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href=css/style.css>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.5.0.js"></script> -->
<body>
	 <div id="app" style='font-size:0.5em; '>
            <table class="fqa_tbl" id='lists' style='width:1000px; align=center;text-align:center; '>
	            <tr style='text-align:left;font-size:2em'>
		            <td><p style='margin:0 auto; font-size:2em;text-align:left;'>Notice</p></td>
	<!-- 	            <td><input type=text id="search" v-model=""></td> -->
	<!-- 	            <td><input type=button @click=doSearch value="�˻�"></td> -->
	            </tr>
	            <tr>
	                <tr class=table_tr>
	                <th class='fqa_tbl_title1' align=center style='width:50px'>��ȣ</th>
	                <th style='width:100px'>�ۼ���</th>
	                <th style='width:1000px'>����</th>
	                </tr>
	<%--             <c:forEach items="${list}" var="item" varStatus="status" begin="0" end="10" step="1" > --%>
	            <tr v-for="(value,index) in list">
	                <td>{{index+1}}</td>
	                <td>{{value.writer}}</td>
	                <td><a href="/detail/${value.idx}">{{value.title}}</a></td>
	            </tr>
	<%--             </c:forEach> --%>
<!-- 	            <tr> -->
<!-- 	                <td style='text-align:right;'></td> -->
<!-- 	              <td style='align:right;font-size:2em'> -->
<%-- 	                  <c:if test="${startyes eq 1}"> --%>
<%-- 	                  <a  style='color:black;' href="notice_list?pageNum=${back}">[����]</a> --%>
<%-- 	                  </c:if> --%>
<!-- 	                  <ul class=pageNum> -->
<%-- 	                  <c:forEach items='${num}' var='n'> --%>
<%-- 	                <li><a href='notice_list?pageNum=${n}' id="${n}">${n}</a></li> --%>
<%-- 	                </c:forEach> --%>
<!-- 	                </ul> -->
<%-- 	                <c:if test="${endno eq 1}"> --%>
<%-- 	                <a  style='color:black;' href="notice_list?pageNum=${nexts}">[����]</a> --%>
<%-- 	               </c:if> --%>
<!-- 	               </td> -->
	                <td style='float:right; width:71px'>
	                <button @click="write">�۾���</button>
	<!--                <a class=a href="write.do">�۾���</a> -->
	                </td>
	            </tr>
            </table>
        </div>

<%@ include file="/WEB-INF/views/list.jspf" %>

</body>
</html>