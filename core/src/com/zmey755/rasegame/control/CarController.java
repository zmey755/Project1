package com.zmey755.rasegame.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.zmey755.rasegame.view.GameScreen;

//Данный класс будет отвечать за логику движения машинки
public class CarController {
    private Polygon carBounds;
    public CarController(Polygon carBounds){
     this.carBounds = carBounds;
    }
    //метод поведения машинки

private float carSpeed,speedVelosity= 10f,speedMax = 10f;
    private float rotationSpeed = 30f;//За одну секунду поворот будет происходить на 30 градусов

public void handle(){
    //все что связано со скоростью
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        carSpeed +=speedVelosity * GameScreen.deltacff;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            carSpeed -=speedVelosity * GameScreen.deltacff;
        else downSpeed();

    carSpeed = sliceSpeed();//ограничение скорости


//все что связано с поворотом


    if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltacff);
    else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltacff);

    // все изменения в нашей игре должны происходить относительно времени deltacff между кадров
        //изменение скорости зависит от времени между кадров
    carBounds.setPosition(carBounds.getX()+ MathUtils.cosDeg(carBounds.getRotation()+90) * carSpeed * GameScreen.deltacff,
            carBounds.getY()+ MathUtils.sinDeg(carBounds.getRotation()+90) * carSpeed * GameScreen.deltacff);
}
private void downSpeed(){ //гасим скорость
if(carSpeed > speedVelosity * GameScreen.deltacff)
    carSpeed -= speedVelosity * GameScreen.deltacff;

  else  if (carSpeed < -speedVelosity * GameScreen.deltacff)
        carSpeed += speedVelosity * GameScreen.deltacff;


 else
     carSpeed = 0f;
}
private float sliceSpeed(){//ограничиваем скорость
if (carSpeed >speedMax)
    return speedMax;
if (carSpeed < -speedMax)
    return -speedMax;
return carSpeed;
}
}
