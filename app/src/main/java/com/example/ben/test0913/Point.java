package com.example.ben.test0913;

import android.util.Log;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.microedition.khronos.opengles.GL10;


/////////////////////////////////////////////////////////////////////////////////////////////////


/**
 * Created by Ben on 6/7/15.
 */





public class Point {

    private FloatBuffer vertexBuffer;
    private ByteBuffer indexBuffer;
    Random rand = new Random();
    ClientThread clientThread = new ClientThread();
    String RawData;
    //public String RawData = clientThread.XYZandTime;
    //public String message = clientThread.XYZandTime;


    // Variables for RawData
    Scanner myScanner;
    String message = "(-1.0, -1.0, -1.0, 900)";
    String tmp;
    //MyNormalizedPoint myNormalizedPoint = new MyNormalizedPoint();
    //DataInputStream DIS = new ByteArrayInputStream(RawData.getInputStream());
    //String RawData = clientThread.getXYZandTime();
    float x = -1.0f, y  = -1.0f, z = -1.0f;
    long time;
    int index = 0;


    /*
    private float[] vertices = {

            0f, 0f, 0f,
            0.1f,  0.1f,  0.1f,
            0.2f,  0.2f,  0.2f,
            0.3f,  0.3f,  0.3f,
            0.4f,  0.4f,  0.4f,
            0.5f,  0.5f,  0.5f,
            0.6f,  0.6f,  0.6f,
            0.7f,  0.7f,  0.7f,
            0.8f,  0.8f,  0.8f,
            0.9f,  0.9f,  0.9f,
            1f, 1f, 1f
    };


    private byte[] indices = { 0,1,2,3,4,5,6,7,8,9 };
    */
    private float[] vertices = new float[9];
    private byte[] indices = {0,1,2};
    float t = 0.75f;





    //private float[] vertices = {rand.nextFloat() * 2 - 1, rand.nextFloat() * 2 - 1, rand.nextFloat() * 2 - 1};

    //private byte[] indices = {0};
    //private List<Byte> indices = new ArrayList<Byte>();

    public Point(){

    }

    public void breakString (String message) {
        this.message = message;

        //try{
        //while(true){ //0921'15
        // receive message
        //message = DIS.readLine();
        Log.d("message", message);

        if( message != null ){
            myScanner = new Scanner(message);

            // set x to new point
            tmp = myScanner.next();
            //myNormalizedPoint.setX( Double.parseDouble( tmp.substring( 1, tmp.length() - 1 ) ) );
            x = Float.parseFloat( tmp.substring( 1, tmp.length() - 1));

            // set y to new point
            tmp = myScanner.next();
            y = Float.parseFloat(tmp.substring(0, tmp.length() - 1)) ;

            // set z to new point
            tmp = myScanner.next();
            z = Float.parseFloat(tmp.substring(0, tmp.length() - 1)) ;

            // set time to new point
            tmp = myScanner.next();
            time = Long.parseLong( tmp.substring( 0, tmp.length() - 1 ) ) ;

            // add the new point to points arraylist
            //MainActivity.addNormalizedPoint( myNormalizedPoint );
        }
        //}
        //}
    }

    public void assignValueToArray () {
        vertices[index] = z;
        vertices[index+1] = x;
        vertices[index+2] = y;

        index = index + 3; // How long did it be stored?
        //Log.d("vertices", vertices);
        Log.d("vertices", "x1: " + Float.toString(vertices[0]));
        Log.d("vertices", "y1: " + Float.toString(vertices[1]));
        Log.d("vertices", "z1: " + Float.toString(vertices[2]));
        Log.d("vertices", "x2: " + Float.toString(vertices[3]));
        Log.d("vertices", "y2: " + Float.toString(vertices[4]));
        Log.d("vertices", "z2: " + Float.toString(vertices[5]));
        Log.d("vertices", "x3: " + Float.toString(vertices[6]));
        Log.d("vertices", "y3: " + Float.toString(vertices[7]));
        Log.d("vertices", "z3: " + Float.toString(vertices[8]));

    }

    public void prepareToDraw () {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    /* // 0921'15
    public Point(String message) {

        //RawData = clientThread.getXYZandTime();

        for(int i=0;i<10;i++){
            //RawData =in.readLine();
            //Log.d("MyAppTest2", String.valueOf(RawData));
            //Log.d("MyAppTest2", String.valueOf(RawData));

            //output.println("hello");
        }

       // while(true) {
       //     RawData = clientThread.getXYZandTime();
       //     if (RawData!=null)
       //         Log.d("The second test", String.valueOf(RawData));


        //}



        //for(int i=0;i<10;i++){
        //    //XYZandTime =in.readLine();
        //    Log.d("MyAppTest", String.valueOf(message));
        //    //output.println("hello");
        //}


        //public void get_xyz( String RawData){

        this.message = message;

        //try{
        //while(true){ //0921'15
            // receive message
            //message = DIS.readLine();
            Log.d("message", message);

            if( message != null ){
                myScanner = new Scanner(message);

                // set x to new point
                tmp = myScanner.next();
                //myNormalizedPoint.setX( Double.parseDouble( tmp.substring( 1, tmp.length() - 1 ) ) );
                x = Float.parseFloat( tmp.substring( 1, tmp.length() - 1));

                // set y to new point
                tmp = myScanner.next();
                y = Float.parseFloat(tmp.substring(0, tmp.length() - 1)) ;

                // set z to new point
                tmp = myScanner.next();
                z = Float.parseFloat(tmp.substring(0, tmp.length() - 1)) ;

                // set time to new point
                tmp = myScanner.next();
                time = Long.parseLong( tmp.substring( 0, tmp.length() - 1 ) ) ;

                // add the new point to points arraylist
                //MainActivity.addNormalizedPoint( myNormalizedPoint );
            }
        //}
        //}



        //catch(IOException e){

        //}



        vertices[index] = x;
        vertices[index+1] = y;
        vertices[index+2] = z;

        index = index + 3; // How long did it be stored?





        //for (int i = 0; i < 12; i = i + 3) {
        //    if (i == 0)
        //        vertices[0] = 0;
        //    else
        //        vertices[i] = 0;
        //}
        //for (int i = 1; i < 12; i = i + 3) {
        //    if (i == 1)
        //        vertices[1] = 0;
        //    else {
        //        vertices[i] = t;
        //        t = t + 0.75f;
        //    }
        //}
        //for (int i = 2; i < 12; i = i + 3) {
        //    if (i == 2)
        //        vertices[2] = 0;
        //    else
        //        vertices[i] = 0;
        //}


        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }
    */

    public void draw(GL10 gl, int count) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glPointSize(20);
        //for (;count < 4;count++) {
        gl.glDrawElements(GL10.GL_POINTS, count, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        //}
        gl.glDrawElements(GL10.GL_LINEAR, count, GL10.GL_UNSIGNED_BYTE, indexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}