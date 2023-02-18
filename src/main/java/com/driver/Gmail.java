package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Node>al;
    ArrayList<Node>al2;
    private int ind;
    private int ind2;
    public Gmail(String emailId, int inboxCapacity) {
        //....................
        super(emailId);
        // new Email(emailId);
            this.inboxCapacity= inboxCapacity;
        al=new ArrayList<>();
        al2=new ArrayList<>();
        ind=-1;
        ind2=-1;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
          Node t=new Node(date,sender,message);
          if(al.size()<inboxCapacity)
          {
              al.add(t);
              ind++;
          }
          else {
              al2.add(al.remove(0));
              al.add(t);
              //ind;
              ind2++;
          }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        for(int i=0;i<al.size();i++)
        {
            String d=al.get(i).message;
            if(d==message)
            {
                al2.add(al.remove(i));
                ind--;
                ind2++;
            }
        }

    }

    public String findLatestMessage(){
        if(ind==-1)
            return "";
        return al.get(ind).message;
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(ind==-1)
            return "";
        return al.get(0).message;
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int c=0;
        for(int i=0;i<al.size();i++)
        {
            Date d=al.get(i).date;

            if(d.after(start) ||d.equals(start))
            {
                if(d.before(end) || d.equals(end))
                    c++;
            }
        }
//        for(int i=0;i<al2.size();i++)
//        { Date d=al2.get(i).date;
//            if(d>= start && d<=end)
//                c++;
//        }
        return c;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return al.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return al2.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
     al2.clear();
     ind2=0;
    }

    public int getInboxCapacity() {
        return  inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
    public class Node{
        Date date;
        String sender;
        String message;
        public Node(Date date, String sender, String message)
        {
            this.date=date;
            this.sender=sender;
            this.message=message;

        }
    }

}
