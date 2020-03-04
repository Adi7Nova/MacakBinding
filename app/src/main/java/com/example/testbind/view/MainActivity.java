package com.example.testbind.view;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.testbind.models.login;
import com.example.testbind.R;
import com.example.testbind.databinding.ActivityMainBinding;
import com.example.testbind.viewModel.LoginViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        binding.setVm(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<login>() {
            @Override
            public void onChanged(login login) {
                if (TextUtils.isEmpty(Objects.requireNonNull(login).getUser())) {
                    binding.ema.requestFocus();
                }
                else {
                    binding.datesr.setText(login.getUser());
                    binding.datepass.setText(login.getPasswd());
                }
            }
        });
    }
}
