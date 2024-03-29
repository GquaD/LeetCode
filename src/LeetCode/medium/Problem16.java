package LeetCode.medium;

import java.util.*;

public class Problem16 {
    //https://leetcode.com/problems/3sum-closest/
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{789,-138,-217,-331,318,-173,44,-967,-843,159,348,-214,489,-533,-667,-34,290,711,867,-690,537,-815,811,-845,-95,957,-800,452,77,-760,-569,-982,731,68,-817,-38,-927,-850,272,-265,-145,189,-749,-550,184,715,-510,-450,-696,-677,-447,496,386,-285,417,-782,627,355,-688,116,-818,1,-29,804,553,286,-634,388,288,-917,-984,633,-188,704,360,188,303,569,-426,-287,831,-503,677,-229,719,182,101,-530,-958,420,-271,-758,865,-861,880,616,207,-523,-502,795,-55,-176,195,-638,-578,643,234,-500,-410,901,-297,274,-748,548,-70,660,-655,470,-463,405,64,4,-768,-196,-18,48,199,-903,-906,758,425,-83,436,-193,-764,-902,827,594,-963,-293,676,103,308,205,-856,344,34,67,-73,-11,-804,998,-361,-221,884,40,-139,387,716,-484,-433,-761,478,347,-746,210,697,964,-467,510,-787,-954,501,-102,-278,-516,-552,-251,-935,-144,538,646,-656,-870,-75,324,-25,429,104,-13,-149,-313,-707,289,351,893,-698,636,967,-825,-514,-790,-101,532,-7,-853,738,180,-521,-978,-866,499,58,822,-744,603,-750,-799,-412,682,43,-961,444,837,690,917,-697,-67,476,-496,163,-72,-687,235,-538,859,-575,655,-678,-703,-66,-596,-831,583,373,-943,-864,-617,423,823,85,969,362,374,-654,-397,955,394,397,-543,529,150,558,-292,-886,-968,251,519,-395,679,-279,-326,-983,-940,-636,960,462,-859,409,-965,-669,506,83,-342,254,449,505,897,666,-266,912,900,-301,-320,680,-498,-366,-378,396,-780,-203,-376,277,122,736,-733,846,-501,-869,484,-683,-879,243,-146,309,725,-468,-839,161,-476,-628,343,-668,54,-151,410,-454,-876,-593,-239,-318,805,-922,-422,570,735,-307,-622,-48,-590,-747,-890,-896,197,264,634,330,325,611,869,896,-157,806,73,526,-303,-803,729,-741,-653,-112,-327,756,-705,84,-224,-19,250,72,442,903,428,866,-84,-517,-513,878,630,702,-615,-594,-572,170,-411,164,-582,-947,891,-629,95,-959,201,-371,-465,493,381,-727,-348,-663,15,100,109,-739,-448,-944,508,-143,-860,-435,706,-387,-854,129,-124,839,518,8,699,776,341,-966,350,860,599,-315,753,582,542,653,940,-820,-724,215,-728,796,-255,-186,550,-155,-114,609,1000,671,241,7,-915,194,-808,-632,-245,-699,-47,245,863,368,894,-937,282,5,-587,-863,345,479,700,-482,-333,-999,-767,149,383,885,769,-347,281,972,279,-184,604,-269,-722,187,-671,755,389,-365,261,-322,641,-418,933,-210,-489,545,401,-77,-219,766,807,262,-830,915,411,868,-238,-50,415,-642,-986,-98,311,158,485,-338,-428,416,982,81,-985,-233,50,-973,329,169,-788,820,225,543,841,294,698,810,-807,949,708,521,-32,742,-490,333,730,808,-248,976,-874,128,-421,575,-350,253,-430,-990,-399,-713,-192,649,-263,-528,211,-718,115,-755,-135,456,-694,-709,873,-877,-172,-413,315,413,258,-772,96,-216,223,498,709,-795,-107,902,209,-65,451,-167,956,792,307,-61,565,-941,-908,-607,-956,913,302,727,988,-128,202,119,-329,11,-21,39,473,204,978,-970,-897,692,455,-299,-280,-471,480,-913,-778,-23,-918,-810,-849,-480,802,-598,-439,118,-600,751,-919,-742,125,648,-682,640,-566,-570,-97,628,144,424,20,-606,-1000,-469,55,-199,139,105,459,-425,-666,-934,-554,-834,-355,-725,614,441,393,-675,-562,717,126,247,535,-783,-220,-651,525,-154,813,733,-537,357,481,467,-323,33,-226,504,-352,157,26,-241,-579,-250,-991,300,-745,312,991,779,-497,-180,-316,160,-90,-828,817,240,-893,684,203,-337,-244,16,560,-268,861,-122,192,-94,372,-951,457,631,304,-390,-868,97,-393,488,-762,625,-603,954,596,-925,-522,989,377,857,-479,-867,78,-178,667,378,835,832,-74,644,-720,-855,-546,82,-60,465,-610,-737,-878,-456,517,-82,826,-125,759,851,833,593,854,587,598,754,651,588,-444,-892,213,-542,-394,454,198,-353,-24,-85,-548,872,531,911,293,-78,-416,931,-345,-723,-916,-624,-589,-17,332,-773,801,513,-519,-43,673,-536,-127,-156,-133,668,371,-277,-113,-659,-243,768,237,615,-325,-120,-457,-103,-400,705,-79,124,580,-664,-765,-8,909,942,-91,472,562,486,-895,999,763,840,-367,-2,-379,647,930,571,694,130,-290,379,-763,-693,59,-436,36,-474,877,620,29,392,-252,696,527,231,-701,-821,546,-621,-201,131,-232,760,-332,-527,269,-375,747,-359,-948,-551,147,-213,886,45,65,-240,-202,941,-340,675,608,821,-118,-685,-159,-836,275,380,419,176,-604,990,271,515,-721,-174,183,-626,-204,117,-591,-738,445,579,-829,447,114,992,458,-242,-774,-670,-802,-160,292,-950,260,-464,-714,-770,-209}, 6960));
        System.out.println(threeSumClosest(new int[]{-1, 1, 1, -4}, 2));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 2));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    //https://leetcode.com/problems/3sum-closest/discuss/2633830/Java-Slowest-Solution-or-Map
    //1.5 hours
    //Runtime: 1886 ms, faster than 5.02% of Java online submissions for 3Sum Closest.
    //Memory Usage: 118.4 MB, less than 5.92% of Java online submissions for 3Sum Closest.
    static int threeSumClosest(int[] n, int target) {
        int sum = 0, len = n.length, minDiff = Integer.MAX_VALUE;
        Map<Integer, My> map = new HashMap<>();
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int temp = n[i] + n[j];
                if (!map.containsKey(temp)) {
                    map.put(temp, new My(i, j));
                }
            }
        }
        for (int num : map.keySet()) {
            My my = map.get(num);
            for (int i = 2; i < len; i++) {
                if (i != my.one && i != my.two) {
                    int temp = num + n[i];
                    int diff = Math.abs(target - temp);
                    if (minDiff > diff ) {
                        minDiff = diff;
                        sum = temp;
                    }
                    if (diff == 0) {
                        return target;
                    }
                }
            }
        }
        return sum;
    }
    static class My {
        int one;
        int two;
        public My(int one, int two) {
            this.one = one;
            this.two = two;
        }
    }


    //not all cases covered
    static int threeSumClosest2(int[] n, int target) {
        int one = 0, two = 1, three = 2; //indices
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        while (one < two && two < three && three < n.length) {
            int temp = n[one] + n[two] + n[three];
            int diff = Math.abs(target - temp);
            if (minDiff > diff) {
                minDiff = diff;
                sum = temp;
            }
            if (diff == 0) {
                return target;
            }
            //
            if (three + 1 < n.length) {
                three++;
                temp = n[one] + n[two] + n[three];
                diff = Math.abs(target - temp);
                if (minDiff > diff) {
                    minDiff = diff;
                    sum = temp;
                }
                if (diff == 0) {
                    return target;
                }
            }
            ///
            two++;
            if (two + 1 < n.length && two + 1 < three) {
                temp = n[one] + n[two] + n[three];
                diff = Math.abs(target - temp);
                if (minDiff > diff) {
                    minDiff = diff;
                    sum = temp;
                }
                if (diff == 0) {
                    return target;
                }
            }
            ///
            one++;
        }
        return sum;
    }

    //time exceeded
    static int threeSumClosest1(int[] n, int target) {
        int sum = 0, len = n.length, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int temp = n[i] + n[j] + n[k];
                    int diff = Math.abs(target - temp);
                    if (minDiff > diff) {
                        minDiff = diff;
                        sum = temp;
                    }
                    if (diff == 0) {
                        return target;
                    }
                }
            }
        }
        return sum;
    }
}
