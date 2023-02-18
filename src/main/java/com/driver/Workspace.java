package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);

        // The inboxCapacity is equal to the maximum value an integer can store.
        calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
   if (calendar.size()==0) return 0;
        int c=0;

        //LocalTime time_limit = 0;

        mycomparator mc = new mycomparator();

        // Sorting of meeting according to
        // their finish time.
        Collections.sort(calendar, mc);

        // Initially select first meeting.
        c++;
        LocalTime time_limit = calendar.get(0).getEndTime();
        for (int i = 1; i < calendar.size(); i++) {
            if (calendar.get(i).getStartTime().isAfter(time_limit)) {

                c++;

                // Update time limit
                time_limit = calendar.get(i).getEndTime();
            }
        }

        // Print final selected meetings.
        return  c;
    }

    }
    class mycomparator implements Comparator<Meeting> {
        @Override public int compare(Meeting o1, Meeting o2)
        {
            if (o1.getEndTime().isBefore(o2.getEndTime())) {

                // Return -1 if second object is
                // bigger than first
                return -1;
            }
            else if (o1.getEndTime().isAfter(o2.getEndTime()))

                // Return 1 if second object is
                // smaller than first
                return 1;

            return 0;
        }
}
