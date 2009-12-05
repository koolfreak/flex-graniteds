package org.graniteds.tide.controller
{
	import org.granite.tide.events.TideUIEvent;
	import org.graniteds.tide.model.Album;
	

	[Name("mainUIController")]
	[Bindable]
	public class MainUIController
	{
		[In]
		public var mainUI:Object;
		[In]
		public var manageAlbumUI:Object;
		
		
		[Observer('addAlbum')]
		public function addAlbum():void
		{
			this.mainUI.mainUIStack.selectedIndex = 1;
			manageAlbumUI._newAlbum = new Album();
		}
		
		[Observer('backToHome')]
		public function backToHome():void
		{
			this.mainUI.mainUIStack.selectedIndex = 0;
			manageAlbumUI.currentState = '';
		}
		
		[Observer('editAlbum')]
		public function editAlbum(album:Album):void
		{
			this.mainUI.mainUIStack.selectedIndex = 1;
			manageAlbumUI.dispatchEvent(new TideUIEvent('editAlbumEvent',album));
		}
		
	}
}