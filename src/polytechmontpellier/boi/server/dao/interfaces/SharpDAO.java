package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import polytechmontpellier.boi.server.models.*;

public interface SharpDAO {

	public List<Sharp> findAllFollowedSharps(String sharpPseudo);
}
