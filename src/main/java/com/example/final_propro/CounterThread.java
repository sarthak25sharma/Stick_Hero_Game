package com.example.final_propro;

public class CounterThread extends Thread{


    public void run(){

        while(true) {
            if(HelloController.count_flag) {
                System.out.println("hello");
                System.out.println(HelloController.count_flag);
                System.out.println(HelloController.move_count);
                HelloController.move_count++;

                //Admin.getInstance().move_update(HelloC,HelloController.move_count);
                HelloController.write_flag=true;
                HelloController.count_flag = false;
            }
            else{
                System.out.println("hello");
                System.out.println(HelloController.count_flag);
                System.out.println( HelloController.move_count);
            }
        }
    }
}
