package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Client collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Parola: ");
        String messagio = inTastiera.readLine();
        out.writeBytes(messagio + '\n');

        String serverMessage = in.readLine();
        System.out.println("Server message: " + serverMessage);
    }
}