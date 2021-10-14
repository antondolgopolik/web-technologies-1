package by.bsuir.lab1.classes;

public class Task9 {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add(new Ball(1, "Red"));
        basket.add(new Ball(2, "White"));
        basket.add(new Ball(3, "Blue"));
        basket.add(new Ball(4, "Green"));
        basket.add(new Ball(5, "Blue"));
        // Calculate weight
        double totalWeight = 0;
        for (Ball ball : basket.getBalls()) {
            totalWeight += ball.getWeight();
        }
        // Count blue balls
        long number = basket.getBalls().parallelStream()
                .filter(ball -> ball.getColor().equalsIgnoreCase("Blue"))
                .count();
        // Output
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Number of blue balls: " + number);
    }
}
