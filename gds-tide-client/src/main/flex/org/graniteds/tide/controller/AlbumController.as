package org.graniteds.tide.controller
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.logging.Log;
	import mx.logging.targets.TraceTarget;
	
	import org.granite.tide.events.TideFaultEvent;
	import org.granite.tide.events.TideResultEvent;
	import org.granite.tide.events.TideUIEvent;
	import org.granite.tide.events.TideValidatorEvent;
	import org.granite.tide.validators.InvalidValue;
	import org.graniteds.tide.event.LoggedInEvent;
	import org.graniteds.tide.model.Album;
	
	[Name("albumController")]
	[Bindable]
	public class AlbumController
	{
		[In]
		// The In annotation link identity to the tide context
		public var albumService:Object;

		// Inclusion of Album class in order to get it included in the SWF
		// Check http://www.graniteds.org/confluence/display/DOC/9.+Troubleshooting for more details
		private var album:Album;
        
		[In]
        public var albumUI:Object;
		[In]
		public var manageAlbumUI:Object;
		
		// [Out] annotation allow to use albums = event.result instead of tideContext.albums = event.result 
		[In] [Out]
		public var albums:ArrayCollection;
		
		public function init():void {
            var t:TraceTarget = new TraceTarget();
            t.filters = ["org.granite.*"];
            Log.addTarget(t);            
        }
        
		// Using typed events, see : http://www.graniteds.org/confluence/display/DOC20/6.+Flex+3+Client+Framework
		[Observer]
		public function eventHandler(event:LoggedInEvent):void 
		{
			albumService.getAllAlbums(getAllAlbumsResult);
		}
			
		public function getAllAlbums():void {
		  	albumService.getAllAlbums(getAllAlbumsResult);
		}
		
		private function getAllAlbumsResult(event:TideResultEvent):void {
		  albums = event.result as ArrayCollection;
		}
		
		[Observer('saveAlbumEvent')]
		public function saveAlbumEvent():void {
			albumService.save(manageAlbumUI._newAlbum,saveAlbumResult, saveAlbumFault);
		}
		
		private function saveAlbumResult(event:TideResultEvent):void {
		    Alert.show("everything is ok");
			getAllAlbums();
			manageAlbumUI.dispatchEvent(new TideUIEvent('backToHome'));
		}
		
		[Observer('editAlbumEvent')]
		public function editAlbumEvent(album:Album):void
		{
			albumService.getTrackAlbum(album.id,editResultHandler);
		}
		
		private function editResultHandler(e:TideResultEvent):void
		{
			manageAlbumUI._newAlbum = e.result as Album;
		}
		
		private function saveAlbumFault(event:TideFaultEvent):void {
		    Alert.show(event.fault.faultString);
		}
		
		[Observer('deleteAlbumEvent')]
		public function deleteAlbumEvent(album:Album):void
		{
			albumService.remove(album,deleteResult,deleteFault);
		}
		
		private function deleteResult(e:TideResultEvent):void
		{
			getAllAlbums();
		}
		
		private function deleteFault(e:TideFaultEvent):void
		{
			Alert.show(e.fault.faultString);
		}
		
		private function validationHandler(event:TideValidatorEvent):void {
		    var invalidValues:Array = event.invalidValues;
		    for each (var iv:Object in invalidValues) {
		        var invalidValue:InvalidValue = iv as InvalidValue;
		        Alert.show(
		            "Invalid property: " + invalidValue.path +
		            " on object " + invalidValue.bean
		        );
		    }
		}
		
	}
					
}
