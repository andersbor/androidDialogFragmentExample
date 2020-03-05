package dk.easj.anbo.dialogfragmentexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    private static final String TITLE = "title";
    private static final String POSITIVE_BUTTON_TEXT = "positiveButtonText";
    private static final String NEGATIVE_BUTTON_TEXT = "negativeButtonText";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @return A new instance of fragment MyDialogFragment.
     */
    public static MyDialogFragment newInstance(String title, String positiveButtonText, String negativeButtonText) {
        MyDialogFragment fragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        bundle.putString(POSITIVE_BUTTON_TEXT, positiveButtonText);
        bundle.putString(NEGATIVE_BUTTON_TEXT, negativeButtonText);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(TITLE);
        String positiveButtonText = getArguments().getString(POSITIVE_BUTTON_TEXT);
        String negativeButtonText = getArguments().getString(NEGATIVE_BUTTON_TEXT);
        final MainActivity enclosingActivity = (MainActivity) getActivity();
        // Builder pattern used!
        // http://www.javaworld.com/article/2074938/core-java/too-many-parameters-in-java-methods-part-3-builder-pattern.html
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int whichWasClicked) {
                                enclosingActivity.doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichWasClicked) {
                        enclosingActivity.doNegativeClick();
                    }
                })
                .create();
    }
}
