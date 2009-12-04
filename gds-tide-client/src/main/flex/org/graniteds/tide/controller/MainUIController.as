package org.graniteds.tide.controller
{
	import org.granite.tide.spring.Identity;

	[Name("mainUIController")]
	[Bindable]
	public class MainUIController
	{
		[In]
		public var mainUI:Object;
		[In]
		public var identity:Identity;
		
		[Observer('addAlbum')]
		public function addAlbum():void
		{
			this.mainUI.mainUIStack.selectedIndex = 1;
		}
		
		[Observer('backToHome')]
		public function backToHome():void
		{
			this.mainUI.mainUIStack.selectedIndex = 0;
		}
		
	}
}