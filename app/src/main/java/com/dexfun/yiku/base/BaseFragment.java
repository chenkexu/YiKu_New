package com.dexfun.yiku.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexfun.yiku.R;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Smile on 17/8/23.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        getData(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public abstract int getLayoutId();

    public abstract void initView(View view, Bundle savedInstanceState);

    public abstract void getData(View view, Bundle savedInstanceState);

    public void setTitle(View view, CharSequence title) {
        TextView rightText = view.findViewById(R.id.include_title);
        if (rightText != null) {
            rightText.setTextColor(getContext().getResources().getColor(R.color.black));
            rightText.setText(title);
        }
        View back = view.findViewById(R.id.include_left_btn);
        if (back != null) {
            back.setOnClickListener(v -> getActivity().onBackPressed());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
