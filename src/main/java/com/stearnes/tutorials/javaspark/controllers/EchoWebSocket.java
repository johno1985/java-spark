package com.stearnes.tutorials.javaspark.controllers;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class EchoWebSocket {
	private Session session;

    @OnWebSocketConnect
    public void connected(Session session) {
        this.session = session;
    }

    @OnWebSocketClose
    public void closed(int statusCode, String reason) {
        this.session = null;
    }

    @OnWebSocketMessage
    public void message(String message) throws IOException {
        System.out.println("Got: " + message);   // Print message
        session.getRemote().sendString(message); // and send it back
    }
}
