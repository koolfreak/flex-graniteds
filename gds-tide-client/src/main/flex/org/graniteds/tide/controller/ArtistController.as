package org.graniteds.tide.controller
{
	import mx.collections.ArrayCollection;
	import mx.controls.List;
	import mx.logging.Log;
	import mx.logging.targets.TraceTarget;
	
	import org.granite.tide.events.TideResultEvent;
	import org.graniteds.tide.model.Artist;
	
	[Name("artistController")]
	[Bindable]
	public class ArtistController
	{
		[In]
		public var artistService:Object;
		
		[In]
        public var artistUI:Object;
		 
		[In] [Out]
		public var artists:ArrayCollection;
		
		public var workingArtist:Artist;
		
		public function init():void {
            var t:TraceTarget = new TraceTarget();
            t.filters = ["org.granite.*"];
            Log.addTarget(t);
        }
        
        //--------------------------------------------
		
		public function getAllArtists():void {
		  artistService.getAllArtists(getAllArtistsResult);
		}
		
		private function getAllArtistsResult(event:TideResultEvent):void {
			trace("getAllArtistsResult");
			artists = event.result as ArrayCollection;
			
			if(artists.length > 0)
			{
				(artistUI.artistsList as List).selectedIndex = 0;
				//artistUI.selectedArtist = artists.getItemAt(0);
			}
		}
		
		private function saveArtistResult(event:TideResultEvent):void {
		    
		    workingArtist = event.result as Artist;
		    
		    var s:int = artists.length;
		    for(var i:int = 0; i<s; i++)
		    {
		    	if(artists.getItemAt(i).id == workingArtist.id)
		    	{
		    		artists.setItemAt(workingArtist, i);
		    	}
		    }
		    
		    artistUI.transferMessage = "Modifications saved";
		}
		
		private function createArtistResult(event:TideResultEvent):void {
		    artists.addItem(event.result as Artist);
		    artistUI.transferMessage = "New artist added";
		}
		
		//--------------------------------------------
		// Using untyped (String-based) events, see : http://www.graniteds.org/confluence/display/DOC20/6.+Flex+3+Client+Framework
		
		[Observer('showArtists')]
		public function eventHandler():void {
			if(!artists) // Get the array only the first time
			{
				getAllArtists();
			}
		}
		
		[Observer('addArtist')]
		public function eventHandler2(nom:String):void {
			artistService.createArtist(nom, createArtistResult);
		}
		
		[Observer('saveArtist')]
		public function eventHandler3(c:Object, n:String):void {
			workingArtist = c as Artist; // modified artist
			
			artistService.saveArtist(workingArtist.id, n, saveArtistResult);
		}
	}
					
}
