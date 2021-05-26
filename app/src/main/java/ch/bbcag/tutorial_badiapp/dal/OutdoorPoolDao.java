package ch.bbcag.tutorial_badiapp.dal;

import java.util.ArrayList;
import java.util.List;

import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class OutdoorPoolDao {
    public static List<OutdoorPool> getAll() {
        List<OutdoorPool> availableOutdoorPools = new ArrayList<>();

        availableOutdoorPools.add(new OutdoorPool(71, "Schwimmbad", "Aarberg", "BE"));
        availableOutdoorPools.add(new OutdoorPool(27, "Schwimmbad Gruebi", "Adelboden", "BE"));
        availableOutdoorPools.add(new OutdoorPool(6, "Stadtberner Baeder", "Bern", "BE"));
        availableOutdoorPools.add(new OutdoorPool(55, "Zürichsee", "Zürich", "ZH"));

        return availableOutdoorPools;
    }
}
