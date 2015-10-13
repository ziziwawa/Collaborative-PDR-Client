package com.example.ben.test0913;

/**
 * Created by Ben on 7/12/15.
 */
public class FrameLimiter {

    private long interval;
    private long startTime;
    private long endTime;
    private long timeForOneFrame;

    /** Limits an unlimited loop.
     * You should select a value above 25FPS!
     * @param FPS the target value of frames per second
     */
    public FrameLimiter(int FPS){
        interval = 100/FPS;
        startTime = System.currentTimeMillis();
    }

    /** Calling this method stops the current thread until enough time elapsed to reach the target FPS.
     */
    public void limit(){
        endTime = System.currentTimeMillis();
        timeForOneFrame = endTime - startTime;

        if (timeForOneFrame < interval)
            try {
                Thread.sleep(interval - timeForOneFrame);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        startTime = System.currentTimeMillis();
    }

    /** Returns the current FPS measured against the time between two calls of limit().
     * This method just works in combination with limit()!
     * @return the current FPS.
     */
    public int getFPS(){
        if(timeForOneFrame <= 0){
            return 0;
        }else{
            return (int) (1000/timeForOneFrame);
        }
    }
}