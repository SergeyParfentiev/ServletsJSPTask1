<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<html>
<head>
    <link rel="icon" href="icon/favicon.ico"/>
    <title>Questionnaire</title>
    <style type="text/css">
        .leftstr, .rightstr {
            margin-left: 10%;
            line-height: 1.5;
            float: left;
            width: 30%;
        }

        .rightstr {
            margin-top: 10%;
            text-align: center;

        }
    </style>
</head>
<body bgcolor="#31ff79">
    <div style="text-align: center;"><h1>Statistics answers</h1></div>
    <p class="leftstr">

        <b>What part of the plant vanilla get vanilla pastry?</b><br>

        <c:forEach items="${vanillaStatistics}" var="vanilla">
            ${vanilla.key} ${vanilla.value} <br>
        </c:forEach>

        <b>In Ancient Iran it was called the Governor, managing a province?</b><br>

        <c:forEach items="${governorStatistics}" var="governor">
            ${governor.key} ${governor.value} <br>
        </c:forEach>

        <b>The limit of a Galaxy is limited to the exploration of space by man?</b><br>

        <c:forEach items="${galaxyStatistics}" var="galaxy">
            ${galaxy.key} ${galaxy.value} <br>
        </c:forEach>
    </p>
    <p class="rightstr">
        <b>List of Users</b><br><br>

        <select>
            <c:forEach items="${users}" var="user">
                <option>${user.toString()}</option>
            </c:forEach>
        </select>
    </p>
</body>
</html>
