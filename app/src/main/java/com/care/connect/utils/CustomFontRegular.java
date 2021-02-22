package com.care.connect.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class CustomFontRegular extends androidx.appcompat.widget.AppCompatTextView {

	public CustomFontRegular(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CustomFontRegular(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CustomFontRegular(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (!isInEditMode()) {
//			PrintMsg.setprint(getContext(),"FONT>>>"+Typeface.createFromAsset(getContext().getAssets(),
//					"fonts/DroidSans.ttf"));
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
					"fonts/DroidSans.ttf");

			// Typeface.DEFAULT;
			setTypeface(tf);
		}
	}
}