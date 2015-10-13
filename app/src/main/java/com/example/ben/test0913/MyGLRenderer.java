package com.example.ben.test0913;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.provider.SyncStateContract.Helpers.update;

/**
 * Created by Ben on 6/28/15.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer{
    //Context context;
    //Triangle triangle;
    private Context context;   // Application context needed to read image (NEW)
    private TextureCube cube;
    private Point point;
    FrameLimiter limiter;
    public int count = 1;



    /*
    private static float angleTriangle = 0.0f;
    //private float angleQuad = 0.0f;
    private static float angleCube = 0;
    private static float speedTriangle = 2.0f;
    private static float speedCube = -1.5f;
    */

    float angleX = 0;
    float angleY = 0;
    float speedX = 0;
    float speedY = 0;
    float z = -6.0f;

    //int debug=0;


    public MyGLRenderer(Context context) {
        //this.context = context;
        //triangle = new Triangle();
        this.context = context;   // Get the application context (NEW)
        cube = new TextureCube();
        point = new Point();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

        // Setup Texture, each time the surface is created (NEW)
        cube.loadTexture(gl, context);    // Load image into Texture (NEW)
        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;
        float aspect = (float)width / height;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }



    /*
    public void get_raw(String){


    }
    */

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);


        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, z);
        gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f);
        cube.draw(gl);

        //for(int i = 0; i < 10000; i++) {


        //Point t = ClientThread.getP();
        point = ClientThread.getP();


        point.draw(gl, 3); // Haven't resolve the "0" problem (there are zeros in "vertices" array and it print (0, 0, 0) in the very first
        count++;

        /* 0920'15
        if (count != 4) {
            //new Point().draw(gl, count++);



            point.draw(gl, 3);



        } else {
            //new Point().draw(gl, 1);
            point.draw(gl, 3);

        }
        */




        //MyGLActivity().p.draw(gl, 1);


        //Point p = new Point();
        //MyGLActivity m = new MyGLActivity();


        /*

        p.message = m.RawData;

        for(int i= 0; i < 10; i++) {

            Log.d("RendererTest", String.valueOf(p.message));

        }



        p.draw(gl, 1);
        */

        for(int i=0;i<10;i++){

            //Log.d("RendererTest", String.valueOf(XYZandTime));


        }

        //gl.glLoadIdentity();
        //point.draw(gl);

        //pt.add(new Point());
        //pt.get(count++).draw(gl);
        //System.out.println(debug++);
        //}



        //this.render();

        limiter = new FrameLimiter(5);
        //Log.d(toString(), String.valueOf(limiter.getFPS()) + "FPS");
        limiter.limit();    //has to be the last statment



        /*
        angleTriangle += speedTriangle;
        angleCube += speedCube;
        */

        angleX += speedX;
        angleY += speedY;
    }


}
