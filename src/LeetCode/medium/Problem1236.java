package LeetCode.medium;

public class Problem1236 {
    //https://leetcode.com/problems/web-crawler/description/

}

//https://leetcode.com/problems/web-crawler/solutions/5170184/java-bfs-solution/
//15min
//Runtime
//7
//ms
//Beats
//63.37%
//of users with Java
//Memory
//48.52
//MB
//Beats
//88.61%
//of users with Java

/*class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        //bfs
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String hostName = findHostName(startUrl);
        q.add(startUrl);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (visited.contains(cur)) {
                    continue;
                }

                visited.add(cur);

                List<String> list = htmlParser.getUrls(cur);
                if (list != null) {
                    List<String> under = new ArrayList<>();
                    for (String url : list) {
                        if (url.contains(hostName))
                            under.add(url);
                    }
                    q.addAll(under);
                }

            }
        }
        return new ArrayList(visited);
    }

    private String findHostName(String url) {
        int idx = url.lastIndexOf('.'), idx2 = url.indexOf('/', idx);
        return idx2 < 0 ? url : url.substring(0, idx2);
    }
}*/
