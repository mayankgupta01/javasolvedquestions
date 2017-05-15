package facebook.arrays_n_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mayank.gupta on 10/05/17.
 */
public class MeetingScheduleBetter {

    public int findMinRooms(Interval[] intervals) {

        if(intervals.length == 0 || intervals == null)
            return 0;

        if(intervals.length == 1)
            return 1;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start <= o2.start)
                    return -1;
                else
                    return 1;
            }
        });

        int count = 1;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        pQueue.offer(intervals[0].end);

        for(int i=1; i < intervals.length; i++ ) {

                if(intervals[i].start < pQueue.peek()) {
                    count++;

                }else{
                    pQueue.poll();
                }

            pQueue.offer(intervals[i].end);
        }

      /*  pQueue.offer(40);
        pQueue.offer(10);
        pQueue.offer(20);

        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());*/

        return count;
    }

    public static void main(String[] args) {
        /*
        Interval i0 = new Interval(1,3);
        Interval i1 = new Interval(2,4);
        Interval i2 = new Interval(3,4);
        Interval i3 = new Interval(3,5);
        Interval i4 = new Interval(5,6);

        Interval[] intervals = new Interval[]{i0,i2,i1,i4,i3};*/

      /*  Interval i0 = new Interval(1,4);
        Interval i1 = new Interval(4,6);
        Interval i2 = new Interval(4,5);

        Interval[] intervals = new Interval[]{i0,i2,i1};
*/

        Interval i0 = new Interval(1,4);
        Interval i1 = new Interval(2,3);
        Interval i2 = new Interval(4,5);

        Interval[] intervals = new Interval[]{i0,i2,i1};
        MeetingScheduleBetter msb = new MeetingScheduleBetter();
        System.out.println(msb.findMinRooms(intervals));
    }
}

class Interval {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
