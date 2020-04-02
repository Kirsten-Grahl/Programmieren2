package ufogame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;

public class Game implements ITickableListener, IKeyboardListener{
	
	//Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	private int score = 0;
	
	
	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		//frameWork.setBackground(new Background("01Vorlesung\\assets\\space14.jpg"));
		ship = new Ship(screenWidth/2, 4 * screenHeight / 5, screenWidth / 20, screenWidth / 20, 
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);
		
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 10, 1, 
				"01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);
		
		for(int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i-1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}
		
		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
		//frameWork.removeTick(this); für Game Over
	}
	
	public void shoot() {
		//create a projectile
	
		Projectile projectile = new Projectile(ship.getX(), ship.getY(), 
				ship.getWidth()/2, ship.getWidth()/2, 3, "01Vorlesung\\assets\\projectile06.png");
		projectiles.add(projectile);
		frameWork.addGameObject(projectile);
		
		
	//	for(int i = 0; i < 1000; i++) {
	//		projectiles.add(projectile);
	//	}
	//	for(Projectile p : projectiles) {
	//		System.out.println(p.getImagePath());
	//	}
		
		//Variante Array
		//projectiles[0] =projectile;
		
		//projectiles.get(0).getWidth();
		//Variante Array
		//projectiles[0].getWidth();
		
		//projectiles.size(); //statt length
		//Variante Array
		//projectiles.length()
	}
	
	public boolean checkCollision() {
		
	
		for(Ufo ufo: ufos) {
			for(Projectile pro: projectiles) {
			
			if((ufo.getX() < pro.getX() + pro.getWidth()) 
					&& (ufo.getY() < pro.getY() + pro.getHeight()) 
					&& (ufo.getX() + ufo.getWidth() > pro.getX()) 
					&&(ufo.getY() + ufo.getHeight() > pro.getY()) ){
			frameWork.removeGameObject(pro);
			projectiles.remove(pro);
			frameWork.removeGameObject(ufo);
			ufos.remove(ufo);
			score += 1;
			System.out.println(score);
			return true;
		}
			}
		}
		
		return false;
		
	}

	@Override
	public void tick(long elapsedTime) {
		//Das ist unsere GameLoop
		for(Ufo ufo : ufos) {
			ufo.move();
		
		}
		
		if(ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size()-1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() -1));
		}
		
		for(Projectile p: projectiles) {
            p.move();
        }
		
		//check size of list
		if(projectiles.size() > 0) {
			
		//Entfernt ein Projektil aus allen Listen (GameFrame und ArrayList), 
		//wenn das Projektil aus dem Bildschirm herausfliegt
		if(projectiles.get(0).getY() < 0) {
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
			
		}
		}
		
		checkCollision();
		
		
		
	}
     
		
	@Override
	public int[] getKeys() {
		int [] keys =  {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}
	

}

//Aufgabe1)
//Entfernt die Projektile aus allen Listen, wenn das Projektil aus dem Bildschirm herausfliegt.

//Aufgabe2)
//Schreibe eine Methode boolean checkCollision(), die prüft, ob ein Projektil mit dem Ufo kollidiert

//Aufgabe3)
//Wenn es eine Kollision gab, dann erhöhe den Spielstand.
