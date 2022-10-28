package com.zmey755.rasegame.model;

import com.badlogic.gdx.graphics.Texture;
//Создали класс машинка с унаследованными параметрами от гейм обжект
public class Car extends GameObject {

    public Car(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }
}
