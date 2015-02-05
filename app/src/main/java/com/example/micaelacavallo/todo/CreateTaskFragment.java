package com.example.micaelacavallo.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
* Created by micaela.cavallo on 05/02/2015.
*/
public class CreateTaskFragment extends Fragment {

    Button mButtonDone;
    EditText mEditTextTitle;

    public CreateTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_task, container, false);
        prepareViews(rootView);
        textWatcherEditTextTitle();
        listenerButtonDone();
        return rootView;
    }

    private void listenerButtonDone() {
        mButtonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Intent intent = new Intent();
                intent.putExtra(Intent.EXTRA_TEXT, mEditTextTitle.getText().toString());
                activity.setResult(Activity.RESULT_OK, intent);
                activity.finish();
            }
        });
    }

    private void textWatcherEditTextTitle() {
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s))
                {
                    mButtonDone.setEnabled(true);

                }
                else
                {
                    mButtonDone.setEnabled(false);
                }

            }
        });

    }

    private void prepareViews(View rootView) {
        mButtonDone = (Button)rootView.findViewById(R.id.button_done);
        mEditTextTitle = (EditText)rootView.findViewById(R.id.edit_text_task_title);
    }
}
