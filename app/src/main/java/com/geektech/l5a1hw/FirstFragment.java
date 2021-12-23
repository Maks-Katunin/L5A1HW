package com.geektech.l5a1hw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private Button button;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.button);
        editText = view.findViewById(R.id.edit_text);

        buttonClick();
    }

    private void buttonClick() {

        button.setOnClickListener(v -> {
            if (editText.length() != 0){
                Bundle bundle = new Bundle();
                bundle.putString("key", String.valueOf(editText.getText()));
                SecondFragment fragment = new SecondFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container1, fragment).commit();
            }else {
                Toast.makeText(getContext(), "Please edit text", Toast.LENGTH_SHORT).show();
            }


        });
    }
}