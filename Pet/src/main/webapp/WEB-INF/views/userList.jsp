<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="wrapper">
    <table width="100%">
        <tr>
            <td style="width: 20%;" valign="top" >
                <c:choose>
                    <c:when test="${empty principal}">
                        <form method="post" action="/login">
                            <table>
                                <tr style="width: 100%">
                                    <td>아이디</td>
                                    <td><input name="username" placeholder="아이디"></td>
                                </tr>
                                <tr style="width: 100%">
                                    <td>비밀번호</td>
                                    <td><input name="password" placeholder="비밀번호"></td>
                                </tr>
                                <tr style="text-align: end">
                                    <td colspan="2"><button type="submit">로그인</button></td>
                                </tr>
                            </table>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <table>
                            <tr>
                                <td style="text-align: start;">
                                    <img src="/image/Person.png" style="width: 30px; height: 30px;"> <span>관리자 </span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">관리자 계정만 가능합니다.</td>
                            </tr>
                        </table>
                    </c:otherwise>
                </c:choose>
            </td>
            <td style="text-align:center;">
                <table style="table-layout: fixed;" class="table">
                    <tr>
                        <td style="width: 10px;"></td>
                        <td style="width: 80px;">신청자 성명</td>
                        <td style="width: 80px;">아이디</td>
                        <td style="width: 80px;">이용약관<br>동의여부</td>
                        <td style="width: 80px;">필수교육<br>시청여부</td>
                        <td style="width: 80px;">가입여부</td>
                        <td style="width: 80px;">인증여부</td>
                        <td style="width: 80px;"></td>
                    </tr>
                    <c:forEach var="user" items="${user}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.username}</td>
                            <td>O</td>
                            <td>O</td>
                            <td>O</td>
                            <td>${user.isAgreed}</td>
                            <td><button type="submit" onclick="location.href='/userDetail/${user.id}'">상세보기</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</div>
<style type="text/css">
    a:link { color: red; text-decoration: none;}
    a:visited { color: black; text-decoration: none;}
    a:hover { color: blue; text-decoration: underline;}
</style>
<%@ include file="layout/footer.jsp"%>