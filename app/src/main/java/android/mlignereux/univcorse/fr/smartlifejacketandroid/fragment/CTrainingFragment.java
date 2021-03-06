package android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment;

import android.content.Intent;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.activity.CNewTrainingActivity;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CAthlete;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CCoach;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CTrainingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CTrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CTrainingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private CUser mUser;

    public CTrainingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CTrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CTrainingFragment newInstance(String param1, String param2) {
        CTrainingFragment fragment = new CTrainingFragment();
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

        mUser = CUtils.getSharedPreferenceUser(getActivity());
        if (mUser.getStatus().equals(CUser.Status.ATHLETE))
            mUser=CUtils.getSharedPreferenceAthlete(getActivity());
        else{
            mUser=CUtils.getSharedPreferenceCoach(getActivity());
        }
        FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        if(mUser.getStatus().equals(CUser.Status.COACH)){

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), CNewTrainingActivity.class);
                    if (mUser.getStatus().equals(CUser.Status.ATHLETE))
                        CUtils.setSharedPreferencesAthlete(getActivity(), (CAthlete)mUser);
                    else{
                        CUtils.setSharedPreferencesCoach(getActivity(), (CCoach) mUser);
                    }
                    startActivity(intent);
                }
            });
        }else fab.hide();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
