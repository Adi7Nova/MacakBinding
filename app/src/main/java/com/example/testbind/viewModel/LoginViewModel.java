package com.example.testbind.viewModel;

import android.view.View;

import com.example.testbind.models.login;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<login> userData;
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> passwd = new MutableLiveData<>();
    public MutableLiveData<login> getUser() {
        if (userData == null) {
            userData = new MutableLiveData<>();
        }
        return userData;
    }
    public void onClick(View view) {
        login loginUser = new login(email.getValue(), passwd.getValue());
        userData.setValue(loginUser);
    }
}
