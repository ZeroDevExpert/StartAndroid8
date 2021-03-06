package zerodev.p0661_alertdialogoperations;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "MyLogs";
    final int DIALOG = 1;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected Dialog onCreateDialog(int id){
        if(id == DIALOG){
            Log.d(LOG_TAG,"Create");
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Title");
            adb.setMessage("Message");
            adb.setPositiveButton("OK",null);
            dialog = adb.create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    Log.d(LOG_TAG,"show");
                }
            });
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    Log.d(LOG_TAG,"Cancel");
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.d(LOG_TAG,"Dismiss");
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    void method1(){
        dialog.dismiss();
    }
    public void onclick(View v){
        showDialog(DIALOG);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        },2000);
    }
}
