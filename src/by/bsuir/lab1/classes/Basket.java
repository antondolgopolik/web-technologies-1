package by.bsuir.lab1.classes;

import java.util.LinkedList;
import java.util.List;

public class Basket {
    private final List<Ball> balls = new LinkedList<>();

    public void add(Ball ball) {
        balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
