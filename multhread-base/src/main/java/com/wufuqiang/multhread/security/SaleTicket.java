package com.wufuqiang.multhread.security;

/**
 * @ author wufuqiang
 **/
public class SaleTicket {
    public static void main(String[] args) {
        SaleTicketThread r1 = new SaleTicketThread(100);
        for(int i = 0 ;i < 3;i++){

            if(i == 1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r1.setFlag(false);
                new Thread(r1,"线程"+i).start();
            }else{
                new Thread(r1,"线程"+i).start();
            }
        }
    }
}
