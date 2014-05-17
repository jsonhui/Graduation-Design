package com.bingoogol.frogcare.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bingoogol.frogcare.R;
import com.bingoogol.frogcare.ui.AdvanceToolActivity;
import com.bingoogol.frogcare.util.ToastUtil;

public class AttributionFragment extends Fragment implements OnClickListener {
	private static final String TAG = "AttributionFragment";
	private AdvanceToolCallback mAdvanceToolCallback;
	private EditText et_number;
	private TextView tv_result;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mAdvanceToolCallback = (AdvanceToolCallback) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement AdvanceToolCallback");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_attribution, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getView().findViewById(R.id.btn_back).setOnClickListener(this);
		getView().findViewById(R.id.btn_query).setOnClickListener(this);
		tv_result = (TextView) getView().findViewById(R.id.tv_result);
		et_number = (EditText) getView().findViewById(R.id.et_number);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_back) {
			mAdvanceToolCallback.changeFragment(AdvanceToolActivity.ADVANCE_TOOL);
		} else if (v.getId() == R.id.btn_query) {
			ToastUtil.makeText(getActivity(), et_number.getText().toString());
		}
	}
}
