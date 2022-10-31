package com.zmey755.rasegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zmey755.rasegame.control.CarController;

//Создали класс машинка с унаследованными параметрами от гейм обжект
public class Car extends GameObject {
    private CarController carController;//обьявляем экземпляр класса кар контроллер
    public Car(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width,height);
        carController = new CarController(bounds);//передаем полигон в кар контроллер
    }

    @Override
    public void draw(SpriteBatch butch) {
        super.draw(butch);
        carController.handle();
    }
}
