package com.finalProject.myWeather.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalProject.myWeather.R;


public class ShowRoundDialogFragment extends BottomActivity {


    TextView locdetect, share,refresh;
    private CheckRefreshClickListener mCheckAutoDetectListener;
    private CheckRefreshClickListener mCheckShareListener;
    private CheckRefreshClickListener mCheckRefresh;
    public static ShowRoundDialogFragment newInstance() {
        return new ShowRoundDialogFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCheckShareListener = (CheckRefreshClickListener) context;
        mCheckAutoDetectListener=(CheckRefreshClickListener)context;
        mCheckRefresh=(CheckRefreshClickListener)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_round_dialog, container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        locdetect = getView().findViewById(R.id.locationup);
        share = getView().findViewById(R.id.share);
        refresh=getView().findViewById(R.id.refresh);
        locdetect.setOnClickListener(v -> mCheckAutoDetectListener.onUpdateClick());
        share.setOnClickListener(v -> mCheckShareListener.onShareClick());
        refresh.setOnClickListener(v->mCheckRefresh.onRefresh());
        super.onViewCreated(view, savedInstanceState);
    }
}


interface CheckRefreshClickListener {
    void onUpdateClick();
    void onShareClick();
    void onRefresh();
}