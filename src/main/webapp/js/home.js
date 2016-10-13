window.ws=null;
window.closed=false;
window.stompClient=null;
$(document).ready(function() {
	stompConnect1();
	//disconnect();
	send();
});

function send(){
	$('#send_btn').click(function(){
		var chatMsg = $('#chat_msg').val();
		var data  = {from: "u",to:"u2",text:chatMsg};
		stompClient.send('/app/chat',{},JSON.stringify(data));
	});
}


function stompConnect1(){
	$('#ws_connect_btn').click(function(){
		var client = Stomp.client('ws://localhost:8080/rainb/stomp');
		stompClient = client;
		client.connect({},connect_callback);
		function connect_callback(){
			client.subscribe('/user/topic/chat',subscribe_callback);
			//client.subscribe('/user/p2p',subscribe_callback);
		};
		
	});
}

function subscribe_callback(message){
	console.log("received..." + message.body);
	$('#chat_div').append('<p>' + message.body + '</p>')
};

function stompConnect(){
	$('#ws_connect_btn').click(function(){
		//var socket = new WebSocket("/ws/stomp");
		//var stompClient = Stomp.over(socket);
		
		var client = Stomp.client('ws://localhost:8080/stomp');
		//client.connect({},callback);
		client.subscribe({},callback);
		function callback(event){
			//console.log("received..." + event.data);
			
		};
	});
}

function connect(){
	$('#ws_connect_btn').click(function(){
		var websock = new WebSocket("ws://localhost:8080/chat");
		websock.onopen= function(event){
			ws = websock;
			console.log('websocket connection established');
			websock.send("sending...hi from client");
		};
		
		websock.onmessage= function(event){
			console.log("received..." + event.data);
		};
		
	});
}

function disconnect(){
	$('#send_btn').click(function(){
		if(!closed){
			//alert('çlosing connection');
			ws.close();
		}
		
		ws.onclose=function(event){
			closed=true;
			alert('çonnection closed!!!');
		};
	});
	
	
}