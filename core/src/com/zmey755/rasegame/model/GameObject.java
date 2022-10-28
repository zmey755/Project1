package com.zmey755.rasegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

//данный класс является абстрактным - родительский  и по сути нельзя создать объект такого класса
//родительский класс для всех объектов ,которые будут в игре не считая интерфейса (кнопок итд итп)
//но и кнопки и интерфейс тоже возможно будем наследовать от гейм обжект
 abstract class GameObject {
     Rectangle bounds; //данный тип переменной помимо позиции содержит в себе ширину и высоту объекта
     Sprite object; //создадим обьект типа спрайт (не приватные) так как к ним нужен будет доступ из дочерних классов
    //поэтому в конструктор мы передаем 4 параметра координаты и ширину с высотой
     GameObject(Texture texture,float x, float y, float width, float height){
        // мы создали ограничивающую рамку для объектов
      bounds = new Rectangle(x,y,width,height);
      object = new Sprite(texture);
    }
    //создадим метод отрисовать ,передадим в его параметр отрисовщик
    public void draw(SpriteBatch butch){
    //сначала задаем нашему объекту размеры и координаты
        object.setBounds(bounds.getX(),bounds.getY(),bounds.getHeight(),bounds.getWidth());
        //теперь отрисовываем  наш объект
        object.draw(butch);
    }
}
