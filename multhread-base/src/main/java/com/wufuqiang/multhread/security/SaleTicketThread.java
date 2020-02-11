package com.wufuqiang.multhread.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ author wufuqiang
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleTicketThread implements Runnable {

    private int ticket;
    private Object lock = new Object();

    private boolean flag = true;

    public SaleTicketThread(int ticket){
        this.ticket = ticket;
    }

    public SaleTicketThread(int ticket,boolean flag){
        this.ticket = ticket;
        this.flag = flag;
    }

    public void run() {
        if(flag){
            while(ticket >0 ){
                synchronized (lock){
                    sale();
                    ticket-=1;
                }
            }
        }else{
            while (ticket >0){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale2();
            }
        }

    }
    public void sale(){

        if(ticket > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s sale ticket %d",Thread.currentThread().getName(),ticket));
        }
    }

    public synchronized void sale2(){
        if(ticket > 0){
            System.out.println(String.format("%s sale ticket %d",Thread.currentThread().getName(),ticket));
            ticket-=1;
        }
    }
}
