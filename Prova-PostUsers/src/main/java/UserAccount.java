public class UserAccount {
    private final String email;
    private final String userName;
    private final String[] posts;
    private int countPosts;
    private final Post[] timeline;
    private int countTimeline;
    private int countOldestTimeline;
    private final UserAccount[] followers;
    private int countFollowers;
    private final UserAccount[] blockedFollowers;
    private int countBlockedFollowers;
    private final int POSTS_CAPACITY = 10000;
    private final int TIMILINE_CAPACITY = 10;
    private final int FOLLOWERS_CAPACITY = 10000;

    public UserAccount(String userName, String email) {
        this.userName = userName;
        this.email = email;
        posts = new String[POSTS_CAPACITY];
        timeline = new Post[TIMILINE_CAPACITY];
        followers = new UserAccount[FOLLOWERS_CAPACITY];
        blockedFollowers = new UserAccount[FOLLOWERS_CAPACITY];
    }

    public void publish(Post newPost) {
        if (countPosts < POSTS_CAPACITY) {
            posts[countPosts++] = newPost.getQuote();
            for (UserAccount follower: followers) {
                if (follower == null) break;
                if (!isBlocked(follower)) {
                    follower.updateTimeline(newPost, follower);
                }
            }
        }
    }

    public void blockFollower(UserAccount follower) {
        if (countBlockedFollowers < FOLLOWERS_CAPACITY) {
            blockedFollowers[countBlockedFollowers++] = follower;
        }
    }

    private boolean isBlocked(UserAccount follower) {
        for (UserAccount blockedFollower: follower.blockedFollowers) {
            if (blockedFollower == null) break;
            if (userName.equals(blockedFollower.getUserName())) return true;
        }
        return false;
    }

    public void acceptFollower(UserAccount newFollower) {
        if (countFollowers < FOLLOWERS_CAPACITY) {
            followers[countFollowers++] = newFollower;
        }
    }

    public void updateTimeline(Post newPost, UserAccount follower) {
        if (follower.countTimeline == TIMILINE_CAPACITY) {
            if (follower.countOldestTimeline == TIMILINE_CAPACITY) {
                follower.countOldestTimeline = 0;
            }
            follower.timeline[follower.countOldestTimeline++] = newPost;
        } else {
            follower.timeline[follower.countTimeline++] = newPost;
        }
    }

    public void delete(int postInx) {
        String aux = posts[countPosts - 1];
        posts[countPosts - 1] = posts[postInx];
        posts[postInx] = aux;
        countPosts--;
    }

    public void clapPost(int postInx) {
        if (countTimeline > 0) {
            timeline[postInx].clap();
        }
    }

    public void booPost(int postInx) {
        if (countTimeline > 0) {
            timeline[postInx].boo();
        }
    }

    public String showTimeline() {
        StringBuilder builder = new StringBuilder();
        builder.append("Timeline: \n");
        for (Post post: timeline) {
            if (post == null) break;
            builder.append(post.show()).append("\n");
        }
        return builder.toString();
    }

    public String showMyPosts() {
        StringBuilder builder = new StringBuilder();
        builder.append("My posts: \n");
        for (int i = 0; i < countPosts; i++) {
            if (posts[i] == null) break;
            builder.append(posts[i]).append("\n");
        }
        return builder.toString();
    }

    public String showMyFriends() {
        StringBuilder builder = new StringBuilder();
        builder.append("List of followers: \n");
        for (UserAccount follower: followers) {
            if (follower == null) break;
            builder.append(follower.getUserName()).append("\n");
        }
        return builder.toString();
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
