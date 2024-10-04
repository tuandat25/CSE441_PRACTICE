package com.tuandat.btth.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<String>> items;

    public MyViewModel() {
        items = new MutableLiveData<>();
        items.setValue(new ArrayList<>());
    }

    public LiveData<List<String>> getItems() {
        return items;
    }

    public void addItem(String newItem) {
        List<String> currentItems = items.getValue();
        if (currentItems != null) {
            currentItems.add(newItem);
            items.setValue(currentItems); // Cập nhật LiveData
        }
    }
}