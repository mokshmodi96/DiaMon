package com.diabites.client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.GetSet.commondata;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.diabites.CustomToast;
import com.diabites.R;
import com.diabites.Utils;
import com.diabites.doctor.DoctorMainActivity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientSignUp_Fragment extends Fragment implements OnClickListener {
	private static View view;
	private static EditText ed_firstname,ed_lastname,ed_email,ed_mobileno,ed_addess,ed_city,ed_pincode,ed_doc_reg,
	ed_doc_degree,ed_password,ed_cpassword;
	private static TextView login;
	private static Button signUpButton;
	private static CheckBox terms_conditions;
	private RadioGroup radioSexGroup;
	private RadioButton radioSexButton;
	ApiInterface apiService;

	public ClientSignUp_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.signup_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initialize all views
	private void initViews() {
	ed_firstname=view.findViewById(R.id.tv_firstname);
	ed_lastname=view.findViewById(R.id.tv_lastname);
	ed_email=view.findViewById(R.id.tv_email);
	ed_mobileno=view.findViewById(R.id.tv_mobile);


	ed_password=view.findViewById(R.id.tv_password);
	ed_cpassword=view.findViewById(R.id.tv_cpassword);
	radioSexGroup=view.findViewById(R.id.radioGroup);

		signUpButton = (Button) view.findViewById(R.id.signUpBtn);
		login = (TextView) view.findViewById(R.id.already_user);
		terms_conditions = (CheckBox) view.findViewById(R.id.terms_conditions);

		// Setting text selector over textviews
		@SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			login.setTextColor(csl);
			terms_conditions.setTextColor(csl);
		} catch (Exception e) {
		}
	}

	// Set Listeners
	private void setListeners() {
		signUpButton.setOnClickListener(this);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.signUpBtn:

			// Call checkValidation method
			checkValidation();
			break;

		case R.id.already_user:

			// Replace login fragment
			new ClientMainActivity().replaceLoginFragment();
			break;
		}

	}

	// Check Validation Method
	private void checkValidation() {

		// Get all edittext texts
		String firstname = ed_firstname.getText().toString();
		String lastname = ed_lastname.getText().toString();

		String email = ed_email.getText().toString();
		String mobileno = ed_mobileno.getText().toString();


		String password = ed_password.getText().toString();
		String cpassword = ed_cpassword.getText().toString();

		// Pattern match for email id
		Pattern p = Pattern.compile(Utils.regEx);
		Matcher m = p.matcher(email);
		int selectedId=radioSexGroup.getCheckedRadioButtonId();
		radioSexButton=(RadioButton)view.findViewById(selectedId);
String gender=radioSexButton.getText().toString();
		// Check if all strings are null or not
		if (firstname.equals("") || firstname.length() == 0
				|| lastname.equals("") || lastname.length() == 0
				|| mobileno.equals("") || mobileno.length() == 0
				|| password.equals("") || password.length() == 0
				|| cpassword.equals("")
				|| cpassword.length() == 0)

			new CustomToast().Show_Toast(getActivity(), view,
					"All fields are required.");

		// Check if email id valid or not
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");

		// Check if both password should be equal
		else if (!password.equals(cpassword))
			new CustomToast().Show_Toast(getActivity(), view,
					"Both password doesn't match.");

		// Make sure user should check Terms and Conditions checkbox
		else if (!terms_conditions.isChecked())
			new CustomToast().Show_Toast(getActivity(), view,
					"Please select Terms and Conditions.");

		// Else do signup or do your stuff
		else
		user_reg(email,password,firstname,lastname,mobileno,gender);

	}

	private void user_reg(String email, String password, String firstname, String lastname, String mobileno, String gender) {
		apiService = getClient.getC().create(ApiInterface.class);
		Call<ArrayList<commondata>> add_complaint_user = apiService.UserRegister("c_reg",email,password,firstname,lastname,mobileno,gender);

		add_complaint_user.enqueue(new Callback<ArrayList<commondata>>() {
			@Override
			public void onResponse(Call<ArrayList<commondata>> call, Response<ArrayList<commondata>> response) {
				if (response.body() != null) {
					ArrayList<commondata> login = response.body();
					Log.e("SIze of",""+login.get(0).getMsg() );
					Log.e("SIze of",""+login.size() );
					if(login.get(0).getStatus().equals("1"))
					{
						new CustomToast().Show_Toast(getActivity(), view,
								"User Register Successfully.");
						Intent i=new Intent(getActivity(),ClientMainActivity.class);
						startActivity(i);
						getActivity().finish();
					}
					else if(login.get(0).getStatus().equals("2"))
					{
						new CustomToast().Show_Toast(getActivity(), view,
								"User is already register with us");
					}
					else{
						new CustomToast().Show_Toast(getActivity(), view,
								"User Register error");
					}


				}
			}

			@Override
			public void onFailure(Call<ArrayList<commondata>> call, Throwable t) {
				Log.e("Hiiii",""+t);


			}
		});


	}
}
