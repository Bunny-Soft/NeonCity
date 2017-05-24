package com.luis.neoncity.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.luis.neoncity.Input.TiledMapStage;
import com.luis.neoncity.NeonCity;
import com.luis.neoncity.Scenes.Hud;
import com.luis.neoncity.Tools.City;
import com.luis.neoncity.Tools.TileAndSpriteRenderer;

/**
 * Created by Luis on 5/9/2017.
 */

public class PlayScreen implements Screen {
    private NeonCity game;
    public City city;

    private Viewport gamePort;
    private Hud hud;
    public Stage stage;
    public SpriteBatch spriteBatch;
    public  OrthographicCamera gameCam;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private long startTime = System.currentTimeMillis();
    private boolean taxesCollected;
    private int month;

    public PlayScreen(NeonCity game, SpriteBatch sb, City city, String mapName) {
        this.game = game;
        this.city = city;
        spriteBatch = sb;

        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(NeonCity.V_WIDTH, NeonCity.V_HEIGHT, gameCam);

        //creates a hud object
        hud = new Hud(sb, city);

        //loads the selected map
        mapLoader = new TmxMapLoader();

        if(mapName.equals("islandTest"))
            map = mapLoader.load("islandTest.tmx");
        else if(mapName.equals("TestMap"))
            map = mapLoader.load("TestMap.tmx");
        else if(mapName.equals("SimpleTest"))
            map = mapLoader.load("SimpleTest.tmx");
        else
            map = mapLoader.load("SimpleTest.tmx");


        renderer = new TileAndSpriteRenderer(map, city);
        //the stage does not render the tile map, must render sprites with custom render, this renderer does not render the stage

        gameCam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);

        stage = new TiledMapStage(gamePort, map, city, hud);

        //set to true so taxes are not collected on year 0
        taxesCollected = true;
        //allows multiple objects to be input processors
        InputMultiplexer im = new InputMultiplexer(hud.stage, stage,hud );
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void show() {

    }

    public void update(float dt) {
        //updates the camera
        gameCam.update();
        renderer.setView(gameCam);

        //updates the current month, one month is 5 seconds
        month = (int)(System.currentTimeMillis()-startTime)/5000;

        //updates labels
        hud.timeLabel.setText(String.format("%1d-%4d" , (month/12), month%12+1));
        hud.fundsLabel.setText("$" + String.format("%07d", city.getFunds()));
        hud.popLabel.setText("" + String.format("%07d", city.getPopulation()));

        hud.powLabel.setText(String.format("%04d", city.getPower()));
        hud.hapLabel.setText("" + city.getHappiness());
        hud.polLabel.setText(String.format("%03d", city.getPollution()));

        //collects taxes every 12 months
        //12 months is 60 seconds
        if(month%12 == 0 && !taxesCollected) {
            taxesCollected = true;
            city.collectTaxes();
        }
        else if(month%12 == 1 && taxesCollected)
            taxesCollected = false;

        if(city.getPopulation() >= 2500)
            hud.endLabel.setText("YOU WIN!");
        if(city.getHappiness() <= 0)
            hud.endLabel.setText("YOU LOSE!");
    }

    @Override
    public void render(float delta) {
        //on every render, update values
        update(delta);

        //sets the background color to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //renders the tiles and buildings before the HUD
        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        //renders the hud, on top of everything else
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
