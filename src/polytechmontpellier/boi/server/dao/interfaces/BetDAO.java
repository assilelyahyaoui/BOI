package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;

import polytechmontpellier.boi.server.models.Bet;

public interface BetDAO {

	public ArrayList<Bet> getSharpBets(String sharpPseudo);
}
