package com.exam.view;

import android.graphics.Bitmap;

interface ICoinBlockViewState {
	public void Draw(CoinBlockView viewContext, Bitmap canvas);

	public void OnClick(CoinBlockView viewContext);

	public boolean NeedRedraw();

}
