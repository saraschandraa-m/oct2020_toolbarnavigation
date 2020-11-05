package com.nexstacks.toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);

        TextView tvSubject = view1.findViewById(R.id.tv_mail_subject);
        TextView tvUser = view1.findViewById(R.id.tv_user);
        TextView tvContent = view1.findViewById(R.id.tv_mail_content);


        Bundle data = getArguments();

        String subject = data.getString("SUBJECT");
        String user = data.getString("USER");
        String content = data.getString("CONTENT");
        boolean showBack = data.getBoolean("BACK");

        Button btnMoveToLogout = view1.findViewById(R.id.btn_move_logout);

        tvSubject.setText(subject);
        tvUser.setText(user);
        tvContent.setText(content);

        SideNavigationActivity activity = (SideNavigationActivity) getActivity();

        if (activity.getSupportActionBar() != null) {
            if(showBack){
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }else{
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }

        btnMoveToLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new LogoutFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
