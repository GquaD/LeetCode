package LeetCode.medium;

import java.util.*;

public class Problem355 {
    //https://leetcode.com/problems/design-twitter/
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.getNewsFeed(1);
        twitter.follow(1,2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);


        Twitter twitter1 = new Twitter();
        twitter1.postTweet(1,1);
        twitter1.getNewsFeed(1);
        twitter1.follow(2,1);
        twitter1.getNewsFeed(2);
        twitter1.unfollow(2,1);
        twitter1.getNewsFeed(2);
    }

    //https://leetcode.com/problems/design-twitter/solutions/3254194/java-98-faster-solution-hashmap/
    //40 min
    //Runtime
    //9 ms
    //Beats
    //98.36%
    //Memory
    //40.5 MB
    //Beats
    //63.88%
    static class Twitter {

        int time;
        Map<Integer, List<Tweet>> mapUserTweets;
        Map<Integer, List<Integer>> mapFollow;

        public Twitter() {
            time = 0;
            mapUserTweets = new HashMap<>();
            mapFollow = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (mapUserTweets.containsKey(userId)) {
                mapUserTweets.get(userId).add(new Tweet(tweetId, time++));
            } else {
                List<Tweet> list = new ArrayList<>();
                list.add(new Tweet(tweetId, time++));
                mapUserTweets.put(userId, list);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> followees = mapFollow.getOrDefault(userId, new ArrayList<>());
            List<Tweet> listTweets = new ArrayList<>();
            listTweets.addAll(mapUserTweets.getOrDefault(userId, new ArrayList<>()));
            for (int id : followees)
                listTweets.addAll(mapUserTweets.getOrDefault(id, new ArrayList<>()));
            Collections.sort(listTweets, (t1, t2) -> t2.time - t1.time);
            Set<Integer> result = new LinkedHashSet<>();
            for (int i = 0; i < Math.min(listTweets.size(), 10); i++)
                result.add(listTweets.get(i).id);
            return new ArrayList<>(result);
        }

        public void follow(int followerId, int followeeId) {
            if (mapFollow.containsKey(followerId)) {
                mapFollow.get(followerId).add(followeeId);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(followeeId);
                mapFollow.put(followerId, list);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (mapFollow.containsKey(followerId)) {
                mapFollow.get(followerId).remove(new Integer(followeeId));
            }
        }
    }

    static class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }
    }
}
