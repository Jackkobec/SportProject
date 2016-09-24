package model.app_db;

import model.roles.Gymnastic;

/**
 * GymnasticDAOinplement
 */
public class GymnasticDAOinplement implements GymnasticDAO {
    private AppDB appDB;

    @Override
    public Gymnastic addGymnastic(Gymnastic gymnastic) {
        return appDB.addGymnastic(gymnastic);
    }

    @Override
    public Gymnastic findGymnastic(String GymnasticName) {
        return null;
    }

    @Override
    public Gymnastic removeGymnastic(String GymnasticName) {
        return null;
    }
}
