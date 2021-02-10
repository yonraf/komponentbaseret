package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;

	private Enemy enemy;
	private Player player;
	private ArrayList<Bullet> bullets;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {

		bullets = new ArrayList<Bullet>();
		sr = new ShapeRenderer();


		player = new Player();
		enemy = new Enemy(bullets);
		
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		enemy.update(dt);

		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update(dt);
			if(bullets.get(i).shouldRemove()) {
				bullets.remove(i);
				i--;
			}
		}

		
	}
	
	public void draw() {
		player.draw(sr);
		enemy.draw(sr);

		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(sr);
		}
	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));

		enemy.setLeft(MathUtils.randomBoolean(0.25f));
		enemy.setRight(MathUtils.randomBoolean(0.25f));
		enemy.setUp(MathUtils.randomBoolean(0.25f));
	}
	
	public void dispose() {}
	
}









