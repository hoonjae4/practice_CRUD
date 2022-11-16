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
                <table style="table-layout: fixed;" class="table-bordered">
                    <tr>
                        <td style="width: 120px;">이름</td>
                        <td style="width: 1000px;">${user.name}</td>

                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td>${user.address}</td>
                    </tr>
                    <tr>
                        <td>교육여부</td>
                        <td>O</td>
                    </tr>
                    <tr style="text-align: start;"><td colspan="2">
                        <form method="post" action="/userDetail/authenticate">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit"style="font-size:12px;">수락하기</button>
                        </form>
                        <button type="button" onclick="location.href='/userList'" style="font-size:12px;">돌아가기</button>
                    </td></tr>
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