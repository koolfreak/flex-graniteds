package org.graniteds.tide.event
{
	import org.granite.tide.events.AbstractTideEvent;
	
	public class LoggedInEvent extends AbstractTideEvent
	{
        public var data:Object;
        
        public function LoggedInEvent(data:Object = null):void {
       	    super();
            this.data = data ;
        }

	}
}
