package com.geektech.l5a1hw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FifthFragment extends Fragment {
    private TextView textView;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.tv_text);
        button = view.findViewById(R.id.button);

        showToast();
        loadData();
        buttonClick();
    }

    private void showToast() {
        Toast.makeText(getContext(), "FifthFragment", Toast.LENGTH_SHORT).show();
    }

    private void buttonClick() {
        button.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, new FirstFragment()).commit();
        });
    }

    private void loadData() {
        if (getArguments() != null) {
            textView.setText(getArguments().getString("key"));
        }
    }
}