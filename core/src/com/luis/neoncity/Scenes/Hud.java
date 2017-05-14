package com.luis.neoncity.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.luis.neoncity.NeonCity;

/**
 * Created by Luis on 5/9/2017.
 */

public class Hud {
    private Viewport viewport;
    public Stage stage;

    //TODO: Create a GameManger class for global variables such as these
    private Integer funds;
    private Integer population;
    private String cityName;

    private Label fundsLabel;
    private Label popLabel;
    private Label nameLabel;

    public Hud(SpriteBatch sb) {
        //TODO: replace with global variables, loaded from files
        funds = 20000;
        population = 1000000;
        cityName = "Dallas";

        viewport = new FitViewport(NeonCity.V_WIDTH, NeonCity.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        BitmapFont font = new BitmapFont();
        font.getData().setScale(3f);
        Label.LabelStyle style = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        fundsLabel = new Label("$" + String.format("%07d", funds), style);
        popLabel = new Label(String.format("%08d", population), style);
        nameLabel = new Label(cityName, style);

        table.add(nameLabel).expandX().padTop(10);
        table.add(fundsLabel).expandX().padTop(10);
        table.add(popLabel).expandX().padTop(10);

        stage.addActor(table);
    }
}
