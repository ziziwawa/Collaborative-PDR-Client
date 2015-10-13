package com.example.ben.test0913;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;


public class MyGLActivity extends Activity {

    private GLSurfaceView glView;

    //public String RawData;
    //public String tmpString;
    //public static Point p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //glView = new MyGLSurfaceView(this);
        //glView.setRenderer(new MyGLRenderer(this));

        glView = new MyGLSurfaceView(this);
        setContentView(glView);

        ClientThread clientThread = new ClientThread();

        new Thread(clientThread).start();
        // Here is the problem.


        /* // 0920'15
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




        /*
        for(int i=0;i<10;i++){

            Log.d("ClassesTest", String.valueOf(RawData));

        }
        */





        /*
        for(int i=0;i<10;i++){

            Log.d("MessageTest", String.valueOf(p.message));

        }
        */


        //public String getXYZandTime() {
        /*
        while(true) {
            RawData = clientThread.getXYZandTime();
            if (RawData!=null)
                Log.d("The second test", String.valueOf(RawData));


        }
        */
        //}


        //this.setContentView(glView);
    }

    /* // 0920'15
    public static Point getP() {

        return p;
    }
    */


    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_gl, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
