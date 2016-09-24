package model.app_db;

import model.roles.Gymnastic;

/**
 * GymnasticDAO
 */
public interface GymnasticDAO extends AppDBInterface {

    public Gymnastic addGymnastic(Gymnastic gymnastic);

    public Gymnastic findGymnastic(String GymnasticName);

    public Gymnastic removeGymnastic(String GymnasticName);
}
