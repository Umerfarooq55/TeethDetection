package com.google.firebase.samples.apps.mlkit.models;

import android.app.Activity;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;
import android.view.Display;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by tohamy on 9/24/15.
 */
public class ImageUtils {
    public static String FRESCO_RES = "res://com.tohamy.smile/";
    public static String FRESCO_FILE = "file://";

    public static void requestImageResize(int width, int height, Uri uri, SimpleDraweeView view){
        Log.d("requestImageResize", String.valueOf(width));
        Log.d("requestImageResize", String.valueOf(height));
        Log.d("requestImageResize", String.valueOf(uri));
        Log.d("requestImageResize", String.valueOf(view));
        ResizeOptions imageResizeOption = new ResizeOptions(width, height);
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(imageResizeOption)
                .setAutoRotateEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
        AbstractDraweeController controller =
                Fresco.newDraweeControllerBuilder()
                        .setOldController(view.getController())
                        .setImageRequest(imageRequest)
                        .setAutoPlayAnimations(true)
                        .build();
        try {
            view.setController(controller);
        }catch(Exception e){
            Log.d("requestImageResize", String.valueOf(e.getMessage()));
            e.printStackTrace();
        }
    }




    public static Point getScreenSize(Activity activity){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}
