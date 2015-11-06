package com.stearnes.tutorials.javaspark.controllers;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
    	webSocket("/echo", EchoWebSocket.class);
        get("/hello", (req, res) -> "Hello World");
    }
}