package com.exam.view;

import android.graphics.*;
import android.media.*;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.*;
import android.util.*;
import android.widget.*;

import com.exam.*;
import com.exam.view.Lv1State.*;

public class Lv2State implements ICoinBlockViewState {
	
	Sprite flowerSprite = MediaAssets.getInstance().getSprite(R.drawable.samsung_test);
	Sprite evolve = MediaAssets.getInstance().getSprite(R.drawable.samsungevolve_sprites_4);
	MediaPlayer snd = MediaAssets.getInstance().getSoundPlayer(R.raw.smb_powerup_appears);
	MediaPlayer snd2 = MediaAssets.getInstance().getSoundPlayer(R.raw.smb_1_up);
	private int animStage = 0;
	private int[] heightModifier = { 8, -8, 6, -6, 4, -4, 2, -2 };		// here
	private int[] heightModifier2 = { 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] widthModifier = { 3, -3, 2, -2, 1, -1, 0, 0 };	// here
	Lv2OftenAnim lv2ofAnim;// here
	Lv2Animation lv2Anim; 
	Lv2ClickAnim lv2clAnim;
	CoinBlockView context;

	public Lv2State(CoinBlockView viewContext) {
		context = viewContext;
		
		
		setContentView(R.drawable.background2, "레벨2s냐 아직도 ㅋㅋㅋㅋㅋㅋㅋㅄ");
		
		lv2Anim = new Lv2Animation(); 
		viewContext.addAnimatable(lv2Anim); 
		snd2.seekTo(0);
		snd2.setOnSeekCompleteListener(new OnSeekCompleteListener() {
			public void onSeekComplete(MediaPlayer mp) {
				snd2.start(); 
			} 
		}); 
	}

	public void Draw(CoinBlockView viewContext, Bitmap canvas) {
		// Draw the brick at bottom
		//Sprite sp1 = MediaAssets.getInstance().getSprite(R.drawable.brick_disabled);
		//진동할때의 하단드로블
		SpriteHelper.DrawSprite(canvas, evolve, evolve.NextFrame(), SpriteHelper.DrawPosition.BottomCenter,0,
				-(int)(heightModifier2[animStage%8] * viewContext.getDensity()));
		
		
		animStage++;
		
		
		
		/*
		if (animStage >= heightModifier.length)
			viewContext.setState(new Lv2WaitState(viewContext));
			*/
		
		if(animStage > 60){			
			viewContext.setState(new Lv2WaitState(viewContext));			
		}
		
	}

	public boolean NeedRedraw() {
		return true; 
	}

	public void OnClick(CoinBlockView viewContext) {
		// TODO Auto-generated method stub 
	}

	private class Lv2WaitState implements ICoinBlockViewState {
		//Sprite sp = MediaAssets.getInstance().getSprite(R.drawable.samsung_test);
		//진동후의, 하단 드로블
		MediaPlayer snd = MediaAssets.getInstance().getSoundPlayer(R.raw.smb_powerup);
		CoinBlockView mViewContext;

		public Lv2WaitState(CoinBlockView viewContext) {
			mViewContext = viewContext;
			
			
			(new Handler()).postDelayed(new Runnable(){
				public void run() {
					if (mViewContext.getState().getClass() == Lv2WaitState.class)
					{
						//mViewContext.addAnimatable(lv2Anim);
				
						//mViewContext.setState(new OftenState(mViewContext, flowerSprite)); 
						
						//lv2Anim.Draw2(Bitmap.createBitmap(mViewContext.cwidth, mViewContext.cheight, Bitmap.Config.ARGB_8888));
						//mViewContext.scheduleRedraw();
						
					}
				}
			}, 5000);
			
			
		}

		public void OnClick(CoinBlockView viewContext) {


			//viewContext.removeAnimatable(lv2Anim);
			//viewContext.removeAnimatable(lv2ofAnim);
			viewContext.removeAnimatable(lv2clAnim);
			
			lv2clAnim = new Lv2ClickAnim();			
			viewContext.addAnimatable(lv2clAnim);
			
			
			snd.seekTo(0);
			snd.setOnSeekCompleteListener(new OnSeekCompleteListener() {
				public void onSeekComplete(MediaPlayer mp) {
					snd.start();
				}
			});
									
			 
		
			
			
						
			Setting.CliCount2++;			
			
			Setting.mPref.Ready();			
			Setting.mPref.WriteInt("clicount2", Setting.CliCount2);			
			Setting.mPref.CommitWrite();
			
			
		}

		public void Draw(CoinBlockView viewContext, Bitmap canvas) {
			SpriteHelper.DrawSprite(canvas, flowerSprite, 0, SpriteHelper.DrawPosition.BottomCenter);
		}

		public boolean NeedRedraw() {
			return false;
		}

		@Override
		public void OnEvolve(CoinBlockView coinBlockView) {
			
			//coinBlockView.setState(new InitState(coinBlockView));	
			
		}

		@Override
		public void OnOften(CoinBlockView coinBlockView) {


			coinBlockView.removeAnimatable(lv2ofAnim);
			lv2ofAnim = new Lv2OftenAnim();			
			coinBlockView.addAnimatable(lv2ofAnim);
			
			
		}

		@Override
		public void OnInit(CoinBlockView coinBlockView) {

			
			coinBlockView.removeAnimatable(lv2Anim);	
			coinBlockView.removeAnimatable(lv2ofAnim);
			coinBlockView.removeAnimatable(lv2clAnim);
			
			
		}



	}

	private class Lv2Animation implements IAnimatable {
		
		//진동할때 올라오고, 상단에 남는 드로블
		
		private int flowerRaise = 4;
		private int animstage = 0;
		

		public boolean AnimationFinished() {
			return false;
		}

		public void Draw(Bitmap canvas) {
			
			/*
			
			
			SpriteHelper.DrawSprite(canvas, flowerSprite, flowerSprite.NextFrame(),
							SpriteHelper.DrawPosition.BottomCenter, 0, -(int) (flowerRaise * 4 * context.getDensity()));
			
	
			// Draw the flower
			if (flowerRaise < 8) {
				flowerRaise++;
			}
			*/
			
			
			
			/*
			// Draw the brick at bottom
			SpriteHelper.DrawSprite(canvas, flowerSprite, 0, SpriteHelper.DrawPosition.BottomCenter, 0,
							- (int)(heightModifier2[animStage] * context.getDensity()));
			
			
			if (animstage < 3) {
				animstage++;
			}
			
			
			
			if (animStage >= heightModifier.length) {
				context.setState(new DisabledState(context));
			}
			
			*/
			
			
		}
		

		
		
	}
	
	

	

	@Override
	public void OnEvolve(CoinBlockView coinBlockView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnOften(CoinBlockView coinBlockView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnInit(CoinBlockView coinBlockView) {
		// TODO Auto-generated method stub
		
	}
	
	
	private class Lv2OftenAnim implements IAnimatable {
		

		private int blockVib = 0;
		
		
		
		public boolean AnimationFinished() {
			return false;
		}

		public void Draw(Bitmap canvas) {
			
			
			// Draw the brick at bottom
			//Sprite sp1 = MediaAssets.getInstance().getSprite(R.drawable.brick_disabled);
			//진동할때의 하단드로블
			SpriteHelper.DrawSprite(canvas, flowerSprite, 0, SpriteHelper.DrawPosition.BottomCenter,
					-(int)(widthModifier[blockVib] * context.getDensity()),0);
			

						if (blockVib < 7) { 
							blockVib++;
						}
						
			
			Log.v("tag4", "blockVib"+Integer.toString(blockVib));
			
			/*
			if (blockVib >= 7){
				context.setState(new Lv0WaitState(context));
				Log.v("tag4", "blockVib >= heightModifier.length)"+Integer.toString(blockVib));
			}
			
			*/
			
			
			
			
		}

		
	}
	
	
	private class Lv2ClickAnim implements IAnimatable {
		

		private int spriteVib = 0;
		
		
		
		public boolean AnimationFinished() {
			return false;
		}

		public void Draw(Bitmap canvas) {
			
			/*
			// Draw the brick at bottom
			//Sprite sp1 = MediaAssets.getInstance().getSprite(R.drawable.mushroom);
			//진동할때의 하단드로블
			SpriteHelper.DrawSprite(canvas, flowerSprite, 0, SpriteHelper.DrawPosition.BottomCenter,
					-(int)(widthModifier[spriteVib] * context.getDensity()), -32 * (int)context.getDensity() );
			

						
						
		
			*/
			
			SpriteHelper.DrawSprite(canvas, evolve, evolve.NextFrame(), SpriteHelper.DrawPosition.BottomCenter,0,
					-(int)(heightModifier[spriteVib] * context.getDensity()));
			
		
			if (spriteVib < 7) { 
				spriteVib++;
			}
			
			
		}

		
	}
	
	public void setContentView(int drawbleid, String txt) {
		
		
		coinBlockIntroActivity instance = coinBlockIntroActivity.getInstance();	
		
		instance.setContentView(R.layout.main);		
		
		
		//set time
		TextView time = (TextView)instance.findViewById(R.id.time0);
		time.setText(Long.toString(instance.second));
		
		//set newstate's background img
		LinearLayout a = (LinearLayout)instance.findViewById(R.id.mainlinear);			
		a.setBackgroundResource(drawbleid);
		
		//set newstate's text
		TextView statetxt = (TextView)instance.findViewById(R.id.welcome);		
		statetxt.setText(txt);
		
    }
	
	
	
	
	


}
