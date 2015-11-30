package android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.adapter.CListUserAdapter;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by asus on 30/11/2015.
 */
public class CFragmentListAthletes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentManager mFragmentManager;

    private OnItemClickedListener mListener;

    public CFragmentListAthletes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CFragmentListAthletes newInstance(String param1, String param2) {
        CFragmentListAthletes fragment = new CFragmentListAthletes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.list_athletes, container, false);

        ListView listView = (ListView)view.findViewById(R.id.list);
        listView.setAdapter(new CListUserAdapter(getActivity(), CUtils.getSharedPreferenceCoach(getActivity()).getAthletes()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClicked(position);
            }
        });

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnItemClickedListener {
        // TODO: Update argument type and name
        void onItemClicked(int position);
    }


}
