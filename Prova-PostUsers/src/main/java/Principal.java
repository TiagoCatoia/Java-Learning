public class Principal {
    public static void main(String[] args) {
        UserAccount user1 = new UserAccount("Tiago", "tiagocsz@gmail.com");
        UserAccount user2 = new UserAccount("Pedro", "predao07@gmail.com");
        UserAccount user3 = new UserAccount("Ana", "aninha123@gmail.com");

        Post post1 = new Post(user1, "Meu Primeiro post!");
        Post post2 = new Post(user1, "Meu Segundo post!");
        Post post3 = new Post(user1, "Meu Terceiro post!");
        Post post4 = new Post(user1, "Meu Quarto post!");
        Post post5 = new Post(user2, "MUITO FRIO HOJE");
        Post post6 = new Post(user3, "Bom dia");
        Post post7 = new Post(user3, "Boa tarde");
        Post post8 = new Post(user3, "Boa noite");

        user1.acceptFollower(user2);
        user1.acceptFollower(user3);
        user2.acceptFollower(user1);
        user2.acceptFollower(user3);
        user3.acceptFollower(user1);
        user3.acceptFollower(user2);
//        user1.blockFollower(user3);
        user1.blockFollower(user2);

        user1.publish(post1);
        user1.publish(post2);
        user1.publish(post3);
        user1.publish(post4);
        user2.publish(post5);
        user3.publish(post6);
        user3.publish(post7);
        user3.publish(post8);

        user1.clapPost(0);
        user1.clapPost(0);
        user1.clapPost(0);
        user1.booPost(0);
        user1.booPost(0);
        user1.booPost(0);

        user1.delete(0);


        System.out.println(user1.showMyPosts());
        System.out.println(user1.showTimeline());
        System.out.println(user1.showMyFriends());
    }
}
