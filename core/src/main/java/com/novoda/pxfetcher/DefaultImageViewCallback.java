package com.novoda.pxfetcher;

import android.widget.ImageView;

import com.novoda.pxfetcher.task.Failure;
import com.novoda.pxfetcher.task.Success;

import java.lang.ref.WeakReference;

public class DefaultImageViewCallback implements BitmapLoader.Callback {

    private final WeakReference<ImageView> imageViewWeakReference;
    private final int placeholderResourceId;
    private final int errorResourceId;
    private final ImageSetter imageSetter;

    public DefaultImageViewCallback(ImageView imageView, int placeholderResourceId, int errorResourceId, ImageSetter imageSetter) {
        this.imageViewWeakReference = new WeakReference<ImageView>(imageView);
        this.placeholderResourceId = placeholderResourceId;
        this.errorResourceId = errorResourceId;
        this.imageSetter = imageSetter;
    }

    @Override
    public void onStart() {
        ImageView imageView = imageViewWeakReference.get();
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(placeholderResourceId);
    }

    @Override
    public void onResult(Success ok) {
        ImageView imageView = imageViewWeakReference.get();
        if (imageView == null) {
            return;
        }
        if (ok instanceof MemoryRetriever.Success) {
            imageView.setImageBitmap(ok.getBitmap());
        } else {
            imageSetter.setBitmap(imageView, ok.getBitmap());
        }
    }

    @Override
    public void onResult(Failure ko) {
        ImageView imageView = imageViewWeakReference.get();
        if (imageView == null) {
            return;
        }

        imageView.setImageResource(errorResourceId);
    }

}
