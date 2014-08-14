package com.hesham.fibonacci.fibonaccinumbers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Hesham on 8/11/2014.
 */
public class GeneralDialogFragment extends DialogFragment{

    public GeneralDialogFragment() {

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String title = bundle.getString("title");
        String message = bundle.getString("message");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        //null should be your on click listener
        alertDialogBuilder.setPositiveButton("OK", null);
        return alertDialogBuilder.create();
    }


}