package com.hemalatha.enum_mus;

public enum DrawableColor {


	red {
		public void draw(){}
	},
	blue {
		public void draw(){}
	},
	green {
		public void draw(){}
	};

	public abstract void draw();

	public void convertFromColorToDrawableColor(Color color){
		DrawableColor.valueOf(color.name()).draw();
	}

	public void useColorAndMapFunction(){

	}

}
