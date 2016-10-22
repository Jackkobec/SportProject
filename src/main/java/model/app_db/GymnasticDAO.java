package model.app_db;

import model.roles.Gymnastic;

/**
 * GymnasticDAO
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public interface GymnasticDAO extends AppDBInterface {

    public Gymnastic addGymnastic(Gymnastic gymnastic);

    public Gymnastic findGymnastic(String GymnasticName);

    public Gymnastic removeGymnastic(String GymnasticName);
}
