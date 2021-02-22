package com.care.connect.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class CustomFontBold extends androidx.appcompat.widget.AppCompatTextView {

	public CustomFontBold(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CustomFontBold(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CustomFontBold(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
					"fonts/DroidSansBold.ttf");

			// Typeface.DEFAULT;
			setTypeface(tf);
		}
	}
}