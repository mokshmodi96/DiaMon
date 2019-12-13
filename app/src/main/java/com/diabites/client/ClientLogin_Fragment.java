package com.diabites.client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.GetSet.doclogin;
import com.GetSet.userlogin;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.diabites.CustomToast;
import com.diabites.R;
import com.diabites.Utils;
import com.diabites.doctor.ForgotPassword_Fragment;
import com.diabites.doctor.SignUp_Fragment;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientLogin_Fragment extends Fragment implements OnClickListener {
	private static View view;

	private static EditText emailid, password;
	private static Button loginButton;
	private static TextView forgotPassword, signUp;
	private static CheckBox show_hide_password;
	private static LinearLayout loginLayout;
	private static Animation shakeAnimation;
	private static FragmentManager fragmentManager;
	ApiInterface apiService;

	public ClientLogin_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.client_login_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initiate Views
	private void initViews() {
		fragmentManager = getActivity().getSupportFragmentManager();

		emailid = (EditText) view.findViewById(R.id.login_emailid);
		password = (EditText) view.findViewById(R.id.login_password);
		loginButton = (Button) view.findViewById(R.id.loginBtn);
		forgotPassword = (TextView) view.findViewById(R.id.forgot_password);
		signUp = (TextView) view.findViewById(R.id.createAccount);
		show_hide_password = (CheckBox) view
				.findViewById(R.id.show_hide_password);
		loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);

		// Load ShakeAnimation
		shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
				R.anim.shake);

		// Setting text selector over textviews
		@SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			forgotPassword.setTextColor(csl);
			show_hide_password.setTextColor(csl);
			signUp.setTextColor(csl);
		} catch (Exception e) {
		}
	}

	// Set Listeners
	private void setListeners() {
		loginButton.setOnClickListener(this);
		forgotPassword.setOnClickListener(this);
		signUp.setOnClickListener(this);

		// Set check listener over checkbox for showing and hiding password
		show_hide_password
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton button,
							boolean isChecked) {

						// If it is checkec then show password else hide
						// password
						if (isChecked) {

							show_hide_password.setText(R.string.hide_pwd);// change
																			// checkbox
																			// text

							password.setInputType(InputType.TYPE_CLASS_TEXT);
							password.setTransformationMethod(HideReturnsTransformationMethod
									.getInstance());// show password
						} else {
							show_hide_password.setText(R.string.show_pwd);// change
																			// checkbox
																			// text

							password.setInputType(InputType.TYPE_CLASS_TEXT
									| InputType.TYPE_TEXT_VARIATION_PASSWORD);
							password.setTransformationMethod(PasswordTransformationMethod
									.getInstance());// hide password

						}

					}
				});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginBtn:
			checkValidation();
			break;

		case R.id.forgot_password:

			// Replace forgot password fragment with animation
			fragmentManager
					.beginTransaction()
					.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
					.replace(R.id.frameContainer,
							new ClientForgotPassword_Fragment(),
							Utils.ForgotPassword_Fragment).commit();
			break;
		case R.id.createAccount:

			// Replace signup frgament with animation
			fragmentManager
					.beginTransaction()
					.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
					.replace(R.id.frameContainer, new ClientSignUp_Fragment(),
							Utils.SignUp_Fragment).commit();
			break;
		}

	}

	// Check Validation before login
	private void checkValidation() {
		// Get email id and password
		String getEmailId = emailid.getText().toString();
		String getPassword = password.getText().toString();

		// Check patter for email id
		Pattern p = Pattern.compile(Utils.regEx);

		Matcher m = p.matcher(getEmailId);

		// Check for both field is empty or not
		if (getEmailId.equals("") || getEmailId.length() == 0
				|| getPassword.equals("") || getPassword.length() == 0) {
			loginLayout.startAnimation(shakeAnimation);
			new CustomToast().Show_Toast(getActivity(), view,
					"Enter both credentials.");

		}
		// Check if email id is valid or not
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");
		// Else do login and do your stuff
		else
			user_login(getEmailId,getPassword);

	}

	private void user_login(String getEmailId, String getPassword) {

		apiService = getClient.getC().create(ApiInterface.class);
		Call<ArrayList<userlogin>> add_complaint_user = apiService.UserLogin("c_login",getEmailId,getPassword);

		add_complaint_user.enqueue(new Callback<ArrayList<userlogin>>() {
			@Override
			public void onResponse(Call<ArrayList<userlogin>> call, Response<ArrayList<userlogin>> response) {
				if (response.body() != null) {
					ArrayList<userlogin> login = response.body();
					Log.e("SIze of",""+login.size() );
					Log.e("SIze of",""+login.get(0).getStatus() );
					if(login.get(0).getStatus().equals("0"))
					{
						new CustomToast().Show_Toast(getActivity(), view,
								"Username and Password is wrong");
					}
					else if(login.get(0).getStatus().equals("2")){

						new CustomToast().Show_Toast(getActivity(), view,
								"User is not verify by the admin");

					}
					else{
						new UserPrefManager(getActivity()).saveLoginDetails(login.get(0).getU_id(),login.get(0).getU_fname(),
								login.get(0).getU_lname(),login.get(0).getU_email(),login.get(0).getU_phone_no(),
								login.get(0).getU_gender(),login.get(0).getU_pic(),login.get(0).getU_status());


						Intent i=new Intent(getActivity(),CliendashMainActivity.class);
						startActivity(i);
						getActivity().finish();

					}



				}
			}

			@Override
			public void onFailure(Call<ArrayList<userlogin>> call, Throwable t) {
				Log.e("Hiiii",""+t);


			}
		});
	}
}
