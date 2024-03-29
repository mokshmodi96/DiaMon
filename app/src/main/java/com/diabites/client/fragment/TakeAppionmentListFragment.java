package com.diabites.client.fragment;

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
import com.Network.ApiInterface;
import com.Network.getClient;
import com.diabites.DividerItemDecoration;
import com.diabites.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.diabites.client.CliendashMainActivity.user_id;


public class TakeAppionmentListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TakeappionmentListAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;

    private RecyclerView recyclerView;
    ApiInterface apiService;
    private OnFragmentInteractionListener mListener;

    public TakeAppionmentListFragment() {
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
    public static TakeAppionmentListFragment newInstance(String param1, String param2) {
        TakeAppionmentListFragment fragment = new TakeAppionmentListFragment();
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
        Call<ArrayList<doclogin>> add_complaint_user = apiService.DocList("fdoc_list",user_id);

        add_complaint_user.enqueue(new Callback<ArrayList<doclogin>>() {
            @Override
            public void onResponse(Call<ArrayList<doclogin>> call, Response<ArrayList<doclogin>> response) {
                if (response.body() != null) {
                    ArrayList<doclogin> login = response.body();

                    if(login.get(0).getStatus().equals("1"))
                    {
                        List<doclogin> postList = response.body();
                        Log.e("SIze of",""+postList.size() );
                        adapter=new TakeappionmentListAdapter(getActivity(),postList);
                        recyclerView.setAdapter(adapter);
                    }
                    else{

                        Toast.makeText(getActivity(),"No Docotr found for Appionment",Toast.LENGTH_SHORT).show();
                    }

//                    WorkerViewAdapter adapter = new WorkerViewAdapter(getActivity(), postList);
//                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<doclogin>> call, Throwable t) {
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
