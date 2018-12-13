package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;

import com.codecool.snake.entities.enemies.Enemy;
import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Point2D;

public class Laser extends GameEntity implements Animatable, Interactable {

    private Point2D heading;;

    public Laser() {
        double direction;
        setImage(Globals.getInstance().getImage("Laser"));
        Vec2d snakeHeadPosition = SnakeHead.getHeadPosition();
        setX(snakeHeadPosition.x);
        setY(snakeHeadPosition.y);
        direction = SnakeHead.getDirection();

        setRotate(direction);

        int speed = 4;
        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof Enemy){
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return ("Enemy destroyed!");
    }
}