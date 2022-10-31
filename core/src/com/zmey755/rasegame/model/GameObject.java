package com.zmey755.rasegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

//данный класс является абстрактным - родительский  и по сути нельзя создать объект такого класса
//родительский класс для всех объектов ,которые будут в игре не считая интерфейса (кнопок итд итп)
//но и кнопки и интерфейс тоже возможно будем наследовать от гейм обжект
 abstract class GameObject {
     Polygon bounds; //данный тип переменной помимо позиции содержит в себе ширину и высоту объекта
     Sprite object; //создадим обьект типа спрайт (не приватные) так как к ним нужен будет доступ из дочерних классов
    //поэтому в конструктор мы передаем 4 параметра координаты и ширину с высотой
     GameObject(Texture texture,float x, float y, float width, float height){
         // мы создали ограничивающую рамку для объектов
         object = new Sprite(texture);
         object.setSize(width, height);//укажем размеры для нашего спрайта
         object.setOrigin(width/2f,height/2f);//указываем центр поворота для нашего объекта
         object.setPosition(x, y);//указываем позицию нашего объекта так как в начале он в нулевой позиции

         bounds = new Polygon(new float[]{0f,0f,width,0f,width,height,0f,height});//вершины полигона в массиве
         bounds.setPosition(x, y);//указываем позицию нашего полигона так как в начале он в нулевой позиции
         bounds.setOrigin(width/2f,height/2f);//указываем центр поворота для нашего полигона

    }
    //создадим метод отрисовать ,передадим в его параметр отрисовщик
    public void draw(SpriteBatch butch){
        object.setPosition(bounds.getX(), bounds.getY());//прежде чем отрисовать зададим позицию нашего объекта
        object.setRotation(bounds.getRotation());//далее ставим поворот, тоже берем от нашего полигона
        object.draw(butch);
    }
    //укажем геттер для полигона
    public Polygon getBounds() {
        return bounds;
    }
}
