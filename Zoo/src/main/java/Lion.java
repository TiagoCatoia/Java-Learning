public final class Lion extends Animal implements Runner {

    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }
    @Override
    public void run(){
        System.out.println("Lion is running!");
    }
}
