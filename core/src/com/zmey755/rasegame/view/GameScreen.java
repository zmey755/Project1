package com.zmey755.rasegame.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zmey755.rasegame.model.Car;

//свернуть лишние методы это ктрл+шифт+минус размернуть плюс
//имплементировать добавили методы чтобы наш класс геймскрин стал скрином экрана крч
public class GameScreen implements Screen {
    //чтобы отрисовать объект нужна текстура и отрисовщик
    //создали текстуру
    private Texture carTexture;
    //создали отрисовщик
    private SpriteBatch batch;
    //создадим машинку
    private Car car;
    @Override
    public void show() {
    //инициализируем отрисовщик создав экземпляр класса спрайтбатч
        batch = new SpriteBatch();
        //путь к файлу относительный из папки асетс строчка .интернал нам об этом говорит
        carTexture = new Texture(Gdx.files.internal("car.jpg"));
        car = new Car(carTexture,0,0,200,100);
    }

    //рендер время между кадрами в секундах
    @Override
    public void render(float delta) {
    //для начала следует очищать экран
       Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();//начало работы отрисовщика
        car.draw(batch);
        batch.end();//конец работы отрисовщика
    }

    //при изменении экрана игры перерисовывается подстраиваясь под экран
    @Override
    public void resize(int width, int height) {

    }

    //если свернуть игру вызываается этот метод
    @Override
    public void pause() {

    }
    //резюме при разворачивании игры
    @Override
    public void resume() {

    }

    //при переходе между окнами игры
    @Override
    public void hide() {

    }

    //освобождает ресурсы устройства при закрытии игры
    @Override
    public void dispose() {
     carTexture.dispose();
     batch.dispose();
    }
}
