package Lesson_6;
/*
Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения как на клиентской стороне,
так и на серверной. Т.е. если на клиентской стороне написать «Привет», нажать Enter, то сообщение должно передаться на сервер и там
отпечататься в консоли. Если сделать то же самое на серверной стороне, сообщение, соответственно, передаётся клиенту и печатается у
него в консоли. Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
Такую ситуацию необходимо корректно обработать. Разобраться с кодом с занятия — он является фундаментом проекта-чата.
ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиента.
*/


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer implements MessageSender {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7776)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (DataInputStream inp = new DataInputStream(socket.getInputStream());
                             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                            while (true) {
                                String msg = inp.readUTF();
                                System.out.println("Message: " + msg);
                                out.writeUTF(msg);
                                Scanner sm = new Scanner(System.in);
                                String servMsg = sm.nextLine();
                                out.writeUTF(servMsg);
                                out.flush();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

            }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }

    @Override
    public void submitMessage(String user, String message) {

    }
}



