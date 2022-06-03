package net.mvvm.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.mvvm.models.NicePlace;
import net.mvvm.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mutableLiveData;
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mutableLiveData = mRepo.getNicePlaces();
    }

    public void addNewValue(final NicePlace nicePlace) {
        mIsUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlace = mutableLiveData.getValue();
                currentPlace.add(nicePlace);
                mutableLiveData.postValue(currentPlace);
                mIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mutableLiveData;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
