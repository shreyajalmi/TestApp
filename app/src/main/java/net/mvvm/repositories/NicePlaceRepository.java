package net.mvvm.repositories;

import androidx.lifecycle.MutableLiveData;

import net.mvvm.models.NicePlace;
import net.npautogroup.testapp.R;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlace();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public void setNicePlace() {
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Havasu Falls"));
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Panjim"));
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Mapusa"));
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Thivim"));
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Porvorim"));
        dataSet.add(new NicePlace(R.drawable.ic_launcher_background, "Karaswada"));
    }
}
