package hiredintech_topcoder.dynamic_programming.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayank.gupta on 11/04/17.
 * Problem :  https://community.topcoder.com/tc?module=ProblemDetail&rd=4371&pm=1170
 * Solution : Same as us : doesnt work for big deadly set test case. queue never ends. https://github.com/deviprasad742/javasamples/blob/master/project/src/topcoder/Escape.java
 * Another solution : https://github.com/jskonhovd/TopCoder/blob/master/Java/Escape.java
 */
public class Escape {

    private static final int DANGER = -1;
    private static final int HARMFUL = 1;

    private static class Point {
        int x,y;


        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int lowest(String[] harmful, String[] deadly) {
        int[][] map = new int[501][501];
        int[][] cost = new int[501][501];
        Queue<Point> queue = new LinkedList<>();

        int[] deltaX = new int[]{1,-1,0,0};
        int[] deltaY = new int[]{0,0,1,-1};

        /*Populate game with harmful and dangerous regions, first hamrful then dangerous so that it overrides as per question*/
        populateMap(cost,harmful,HARMFUL);
        populateMap(cost,deadly,DANGER);

        cost[0][0] = 0;
        queue.add(new Point(0,0));

        /* Return if 500,500 is a deadly point */
        if(cost[500][500] == DANGER)
            return -1;

        while(!queue.isEmpty()) {
            Point top = queue.peek();

            queue.remove();

            /*Verify that point is not outside the map*/
            if(top.x > 500 || top.y > 500) continue;

            /*if destination reached then add to life cost array*/
            if(top.x == 500 && top.y == 500) {
                return map[500][500];
            }

            /*Get all neighbouring steps that can be taken and add them to queue if not visited*/
            for(int i = 0; i < deltaX.length; i++) {
                int newX = top.x + deltaX[i];
                int newY = top.y + deltaY[i];
                if(newX < 0 || newX > 500 || newY < 0 || newY > 500)
                    continue;

                if(cost[newX][newY] == DANGER) continue;

                int newCost = map[top.x][top.y] + cost[newX][newY];

                if(map[newX][newY] == 0 || newCost < map[newX][newY]) {
                    Point p = new Point(newX,newY);
                    map[newX][newY] = newCost;
                    queue.add(p);
                }
                /* Need to add the node again to queue if this path has lower cost hence moved next two lines within
                upper condition
                else {
                    p.lifeCost = Math.min(p.lifeCost,top.lifeCost + map[newX][newY]);
                }
                */

            }
        }
        return -1;
    }


    private static void populateMap(int[][] map, String[] region, int attr) {
        for(int i = 0; i < region.length; i++) {
            String[] coordinates = region[i].split(" ");
            int startX = Integer.parseInt(coordinates[0]);
            int startY = Integer.parseInt(coordinates[1]);
            int endX = Integer.parseInt(coordinates[2]);
            int endY = Integer.parseInt(coordinates[3]);

            if( startX > endX ) {
                int temp = startX;
                startX = endX;
                endX = temp;
            }

            if(startY > endY) {
                int temp = startY;
                startY = endY;
                endY = startY;
            }

            for(int j = startX; j <= endX; j++) {
                for(int k = startY; k <= endY; k++) {
                    map[j][k] = attr;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] harmful = new String[]{"468 209 456 32",
                "71 260 306 427",
                "420 90 424 492",
                "374 253 54 253",
                "319 334 152 431",
                "38 93 204 84",
                "246 0 434 263",
                "12 18 118 461",
                "215 462 44 317",
                "447 214 28 475",
                "3 89 38 125",
                "157 108 138 264",
                "363 17 333 387",
                "457 362 396 324",
                "95 27 374 175",
                "381 196 265 302",
                "105 255 253 134",
                "0 308 453 55",
                "169 28 313 498",
                "103 247 165 376",
                "264 287 363 407",
                "185 255 110 415",
                "475 126 293 112",
                "285 200 66 484",
                "60 178 461 301",
                "347 352 470 479",
                "433 130 383 370",
                "405 378 117 377",
                "403 324 369 133",
                "12 63 174 309",
                "181 0 356 56",
                "473 380 315 378"};
        String[] danger = new String[]{"250 384 355 234",
                "28 155 470 4",
                "333 405 12 456",
                "329 221 239 215",
                "334 20 429 338",
                "85 42 188 388",
                "219 187 12 111",
                "467 453 358 133",
                "472 172 257 288",
                "412 246 431 86",
                "335 22 448 47",
                "150 14 149 11",
                "224 136 466 328",
                "369 209 184 262",
                "274 488 425 195",
                "55 82 279 253",
                "153 201 65 228",
                "208 230 132 223",
                "369 305 397 267",
                "200 145 98 198",
                "422 67 252 479",
                "231 252 401 190",
                "312 20 0 350",
                "406 72 207 294",
                "488 329 338 326",
                "117 264 497 447",
                "491 341 139 438",
                "40 413 329 290",
                "148 245 53 386",
                "147 70 186 131",
                "300 407 71 183",
                "300 186 251 198",
                "178 67 487 77",
                "98 158 55 433",
                "167 231 253 90",
                "268 406 81 271",
                "312 161 387 153",
                "33 442 25 412",
                "56 69 177 428",
                "5 92 61 247"};


//        String[] harmful = new String[]{"0 0 250 250","250 250 500 500"};
//        String[] danger = new String[]{"0 251 249 500","251 0 500 249"};
        System.out.println(lowest(harmful,danger));
    }

}
