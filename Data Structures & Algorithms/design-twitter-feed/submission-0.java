class Twitter {
    private int time = 0;
    class Tweet{
        int id;
        int time;
        Tweet next;

        Tweet(int id){
            this.id = id;
          this.time = Twitter.this.time++;
            this.next = null;
        }
    }
    private Map<Integer,Set<Integer>>follows;
    private Map<Integer,Tweet> tweets;
    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweets.get(userId);
        tweets.put(userId,tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet>maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        if(tweets.containsKey(userId)){
            maxHeap.offer(tweets.get(userId));
        }
        if(follows.containsKey(userId)){
            for(int followee : follows.get(userId)){
                if(tweets.containsKey(followee)){
                    maxHeap.offer(tweets.get(followee));
                }
            }
        }
       while(!maxHeap.isEmpty() && result.size()<10){
        Tweet curr = maxHeap.poll();
        result.add(curr.id);

        if(curr.next != null){
            maxHeap.offer(curr.next);
        }
       }
       return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        follows.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }
}
