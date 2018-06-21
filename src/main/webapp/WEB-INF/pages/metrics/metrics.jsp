<%@ include file="/WEB-INF/pages/basic/taglib.jsp"%>
<%@ include file="/WEB-INF/pages/basic/header.jsp"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring-WebSocket-Demo</title>
<script src="${ctxWebJars}/sockjs-client/sockjs.min.js" type="text/javascript"></script>
<script src="${ctxWebJars}/stomp-websocket/stomp.min.js" type="text/javascript"></script>
<script type="text/javascript">
    var stompClient = null;

    function setConnected(connected) {
        $("#connect").prop("disabled", connected);
        $("#disconnect").prop("disabled", !connected);
        connected ? $("#conversationDiv").show() : $("#conversationDiv").hide();
        $("#response").html("");
    }

    function connect() {
        var socket = new SockJS('/demo/stomp');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/real', function(greeting){
                showGreeting(greeting.body);
            });
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }
    }

    function sendNum() {
        var first = $("#first").val();
        var second = $("#second").val();
        stompClient.send("/app/hello", {}, JSON.stringify({ 'first': first, 'second': second }));
    }

    function showGreeting(message) {
        var response = $("#response");
        var p = $("<p>");
        p.css("word-wrap", "break-word");
        p.text(message);
        response.append(p);
    }
</script>
</head>
<body onload="disconnect()">
<noscript>
    <h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>Number One:</label>
        <input type="number" id="first" /><br/>
        <label>Number Two:</label>
        <input type="number" id="second" /><br/><br/>
        <button id="sendNum" onclick="sendNum();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>