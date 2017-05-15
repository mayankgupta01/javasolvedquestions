package facebook.arrays_n_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by mayank.gupta on 10/05/17.
 *
 * Solution : http://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
 */
public class MeetingSchedule {

    public int findMinRooms(int[] startTime, int[] endTime) {

        if(startTime.length == 1)
            return 1;

        Map<Integer,ArrayList<Integer>> roomMap = new HashMap<>();
        ArrayList<Integer> mList = new ArrayList<>();
        mList.add(0);
        roomMap.put(1,mList);
        int roomCount = 1;
        for(int i=1; i < startTime.length; i++) {
            boolean canUseRoom = true;
            for(Map.Entry<Integer,ArrayList<Integer>> entry : roomMap.entrySet()) {
                for(int mIndex : entry.getValue()) {
                    if(startTime[i] < endTime[mIndex] && endTime[i] > startTime[mIndex]) {
                        canUseRoom = false;
                        break;
                    }
                }
                if(canUseRoom) {
                    entry.getValue().add(i);
                    break;
                }
            }
            if(!canUseRoom) {
                roomCount++;
                ArrayList<Integer> meetingList = new ArrayList<>();
                meetingList.add(i);
                roomMap.put(roomCount, meetingList);
            }
        }

        return roomCount;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1,2,3,4};
        int[] end = new int[]{3,3,4,5};

        MeetingSchedule ms = new MeetingSchedule();
        System.out.println(ms.findMinRooms(start,end));


    }
}
