void main() {
    Animal lion = new Lion("Alan");
    Animal owl = new Owl("Robin");
    Animal wolf = new Wolf("Magnus");
    Zoo zoo = new Zoo(new Animal[]{lion, wolf, owl});

    for (Animal animal: zoo.getAnimals()) {
        animal.makeSound();
        if (animal instanceof Runner runnerElement) {
            runnerElement.run();
        }
    }
}