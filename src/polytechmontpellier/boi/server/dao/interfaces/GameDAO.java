package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;

import polytechmontpellier.boi.server.models.Game;

public interface GameDAO {
	
	public ArrayList<Game> getBySport(String sport);
	public ArrayList<Game> getFutureGames();

}
