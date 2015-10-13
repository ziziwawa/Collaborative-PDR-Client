package com.example.ben.test0913;

import android.util.Log;

/**
 * Created by Ben on 9/14/15.
 */
public class Receiver implements Runnable {

    private String RawData;
    private String tmpString;
    //public String XYZandTime;
    public static Point p;



    public void run() {

        ClientThread clientThread = new ClientThread();


        while (true) {
            while (true) {
                RawData = clientThread.getXYZandTime();
                tmpString = RawData;
                if (RawData != null) {
                    break;
                }
            }


            //p = new Point(RawData); // 0921'15 Don't need Receiver
            //p.message = RawData;

            Log.d("ClassesTest", String.valueOf(RawData));

            if (RawData.equals(tmpString))
                break;
        }
    }
}
