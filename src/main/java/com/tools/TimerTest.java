package com.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        TimerTask printTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(">>>>>>> start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(">>>>>>> end");
            }
        };

        Date date = Calendar.getInstance().getTime();

        Timer timer = new Timer();
//        timer.schedule(printTask, date, 3000);
        timer.scheduleAtFixedRate(printTask, date, 3000);

    }

}
