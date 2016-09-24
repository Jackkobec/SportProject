package model.app_db.factory;

import model.app_db.AppDB;
import model.roles.Gymnastic;

import java.util.ArrayList;
import java.util.List;

/**
 * DefaultData
 */
public class DefaultData {
    private AppDB appDB;

    public DefaultData() {
    }

    public DefaultData(AppDB appDB) {
        this.appDB = appDB;
    }

    public AppDB getAppDB() {
        return appDB;
    }

    public void setAppDB(AppDB appDB) {
        this.appDB = appDB;
    }

    public List<Gymnastic> createListOfDefaultGymnastics() {
        List<Gymnastic> defaultGymnastics = new ArrayList();

        Gymnastic otgimaniya = new Gymnastic("Отжимания", 1.7, null, 0.0, 0);
        Gymnastic brysiya = new Gymnastic("Брусья", 4, null, 0.0, 0);
        Gymnastic podtyagivaniya = new Gymnastic("Подтягивания", 5.5, null, 0.0, 0);
        Gymnastic prisedaniya = new Gymnastic("Приседания", 4, null, 0.0, 0);
        Gymnastic podyemyNog = new Gymnastic("Подъемы ног", 4, null, 0.0, 0);
        Gymnastic borcovskiyMostic = new Gymnastic("Борцовский мостик", 4, null, 0.0, 0);

        defaultGymnastics.add(otgimaniya);
        defaultGymnastics.add(brysiya);
        defaultGymnastics.add(podtyagivaniya);
        defaultGymnastics.add(prisedaniya);
        defaultGymnastics.add(podyemyNog);
        defaultGymnastics.add(borcovskiyMostic);

        return defaultGymnastics;
    }


}
