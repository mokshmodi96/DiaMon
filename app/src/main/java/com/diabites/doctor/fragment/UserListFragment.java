package com.diabites.doctor.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.GetSet.doclogin;
import com.GetSet.userlogin;
import com.Network.ApiInterface;
import com.Network.getClient;
import com.diabites.DividerItemDecoration;
import com.diabites.R;
import com.diabites.client.fragment.DoctorListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.diabites.client.CliendashMainActivity.user_id;
import static com.diabites.doctor.DoctorDashMainActivity.doc_id;


public class UserListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    UserListAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;

    private RecyclerView recyclerView;
    ApiInterface apiService;
    private OnFragmentInteractionListener mListener;

    public UserListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserListFragment newInstance(String param1, String param2) {
        UserListFragment fragment = new UserListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_docotor_list, container, false);

        recyclerView =  v.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity());
        recyclerView.addItemDecoration(dividerItemDecoration);

        getdoctor_list();
        return  v;
    }

    private void getdoctor_list() {
        apiService = getClient.getC().create(ApiInterface.class);
        Call<ArrayList<userlogin>> add_complaint_user = apiService.UserListDoc("user_list_doc",doc_id);

        add_complaint_user.enqueue(new Callback<ArrayList<userlogin>>() {
            @Override
            public void onResponse(Call<ArrayList<userlogin>> call, Response<ArrayList<userlogin>> response) {
                if (response.body() != null) {
                    ArrayList<userlogin> login = response.body();
                    Log.e("demo",""+login.get(0).getStatus());
                    if(login.get(0).getStatus().equals("0"))
                    {
                        Toast.makeText(getActivity(),"No Client Found",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {


                        List<userlogin> postList = response.body();
                        adapter=new UserListAdapter(getActivity(),postList);
                        recyclerView.setAdapter(adapter);
                    }

//                    WorkerViewAdapter adapter = new WorkerViewAdapter(getActivity(), postList);
//                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<userlogin>> call, Throwable t) {
                Log.e("Hiiii",""+t);


            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
