package model.app_db;

import model.roles.Gymnastic;

/**
 * GymnasticDAOimplement
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class GymnasticDAOimplement implements GymnasticDAO {
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
