package com.eq.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wq.photo.widget.PickConfig;
import com.yalantis.ucrop.UCrop;

public class AlbumFragment extends Fragment {
    private Button button4;

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);
        button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void click1() {
        int chose_mode = PickConfig.MODE_SINGLE_PICK;
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setCompressionQuality(100);
        new PickConfig.Builder(getActivity())
                .setFragment(AlbumFragment.this)
                .isneedcrop(false)
                .actionBarcolor(Color.parseColor("#E91E63"))
                .statusBarcolor(Color.parseColor("#D81B60"))
                .isneedcamera(true)
                .isSqureCrop(false)
                .setUropOptions(options)
                .maxPickSize(10)
                .spanCount(3)
                .pickMode(chose_mode).build();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == PickConfig.PICK_REQUEST_CODE) {
            //在data中返回 选择的图片列表
            Toast.makeText(getActivity().getApplicationContext(), "选择完成", Toast.LENGTH_LONG).show();
        }
    }
}
