package org.graniteds.tide.controller
{
	import mx.controls.Alert;
	
	import org.granite.tide.spring.Identity;
	import org.graniteds.tide.event.LoggedInEvent;
	
	[Name("mainController")]
	[Bindable]
	public class MainController {

		[In]
        public var mainAppUI:Object;
        
        [In]
		public var identity:Identity;

		[Observer] // typed event
		public function eventHandler(event:LoggedInEvent):void {
		   	this.mainAppUI.bodyStack.selectedIndex = main.ALBUM;
		}
		
		[Observer('showArtists')] // untyped (String-based) event
		public function eventHandler2():void {
		   	this.mainAppUI.bodyStack.selectedIndex = main.ARTIST;
		}
	    
		[Observer('logOut')]
		public function logoutHandler():void
		{
			identity.logout();
			this.mainAppUI.bodyStack.selectedIndex = main.LOGIN;
		}
		
	}
}
