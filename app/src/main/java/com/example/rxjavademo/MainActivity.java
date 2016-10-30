package com.example.rxjavademo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rxjavademo.bean.GetSubject;
import com.example.rxjavademo.bean.Subject;
import com.example.rxjavademo.http.ApiManager;
import com.example.rxjavademo.listener.HttpOnNextListener;
import com.example.rxjavademo.subcribe.ProgressSubscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements HttpOnNextListener<List<Subject>> {
    private static final String TAG = "MainActivity";
    private static final int PHOTO_REQUEST_CUT = 3;

    @BindView(R.id.iv_show)
    ImageView mTvShow;
    @BindView(R.id.begin)
    Button mBegin;
    @BindView(R.id.open)
    Button mOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @Override
    public void onNext(List<Subject> subjects) {


    }

    @OnClick({R.id.begin, R.id.open})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.begin:
                ApiManager api = ApiManager.getInstance();
                api.doHttpRequest(new GetSubject(new ProgressSubscriber(this, this), true));
                break;
            case R.id.open:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                intent.setType("image/*");
//                intent.putExtra("crop", "true");
//                intent.putExtra("aspectX",1);
//                intent.putExtra("aspectY",1);
//                intent.putExtra("outputY", 80);
//                intent.putExtra("outputX", 80);
//                intent.putExtra("return-data",true);
                startActivityForResult(intent, 11);
                break;
        }
    }

    /*
 65      * 剪切图片
 66      */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 11 && resultCode == Activity.RESULT_OK) {
            System.out.println("data2-->" + data);
            Uri uri = data.getData();
            crop(uri);
        } else if (requestCode == PHOTO_REQUEST_CUT && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            mTvShow.setImageBitmap(bitmap);

        }

    }

}
