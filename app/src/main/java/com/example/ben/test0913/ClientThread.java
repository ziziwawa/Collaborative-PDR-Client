package com.example.ben.test0913;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ben on 7/31/15.
 */
public class ClientThread implements Runnable {

    private Socket socket;
    private static final int SERVERPORT = 9999;
    private static final String SERVER_IP = "192.168.0.164"; //¹q¸£IP

    Handler updateConversationHandler;
    Thread serverThread = null;
    public TextView show;
    //public int x;
    //public String RawData;
    private String XYZandTime;
    private String tmp = "";
    //private String RawData;
    //private String tmpString;
    public static Point p = new Point();
    private int count = 0;



    @Override
    public void run() {
        try {
                /*----------------------------------*/
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
            socket = new Socket(serverAddr, SERVERPORT);
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);

            BufferedInputStream in_str;
            DataInputStream in;

            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in_str=new BufferedInputStream(socket.getInputStream());
            in = new DataInputStream(in_str);

            String rev="";

            InputStream iin=socket.getInputStream();
                 /*----------------------------------*/
            //      int x;


            /*
            for(int i=0;i<10;i++){

                XYZandTime =in.readLine();
                Log.d("ThreadTest", String.valueOf(XYZandTime));
                output.println("hello");
            }
            */
            //new Point( XYZandTime);


            while(true) {
                XYZandTime = in.readLine();
                if (XYZandTime == null)
                    break;
                Log.d("ThreadTest", String.valueOf(XYZandTime));
                output.println("hello " + count);
                count++;


                try {
                    Thread.sleep(0);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }


                tmp = XYZandTime;


                p.breakString(XYZandTime);
                p.assignValueToArray();
                p.prepareToDraw();

            }


            /* // 0920'15
            int count = 0;
            while(true) {
                XYZandTime = in.readLine();
                if (tmp == XYZandTime)
                    break;
                Log.d("ThreadTest", String.valueOf(XYZandTime));
                output.println("hello " + count);
                count++;

                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                tmp = XYZandTime;
            }


            while (true) {
                while (true) {
                    RawData = clientThread.getXYZandTime();
                    tmpString = RawData;
                    if (RawData != null) {
                        break;
                    }
                }


                p = new Point(RawData);
                //p.message = RawData;

                Log.d("ClassesTest", String.valueOf(RawData));

                if (RawData.equals(tmpString))
                    break;
            }
            */








        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getXYZandTime() {

        return XYZandTime;
    }

    public static Point getP() {

        return p;
    }



}
