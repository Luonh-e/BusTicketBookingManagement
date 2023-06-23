package com.example.finalproject.myticket;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalproject.R;
import com.example.finalproject.authentication.LoginActivity;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpcomingTicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginRequiredFragment extends Fragment {

    private Button btnLogin;
    private boolean isLoggedIn;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        isLoggedIn = intent.getBooleanExtra("LOGGED_IN", false);
                        if (isLoggedIn)
                            getActivity().finish();
                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_required_fragment, container, false);

        // Get reference to the ImageView in the layout
        CircleImageView profileImage = view.findViewById(R.id.profile_image);

        // Change the color of the image
        profileImage.setColorFilter(ContextCompat.getColor(getContext(), R.color.maincolor2));

        btnLogin = (Button) view.findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        return view;
    }


}