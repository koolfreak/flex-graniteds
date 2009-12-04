package org.graniteds.tide.event
{
	import org.granite.tide.events.AbstractTideEvent;
	
	public class RemoteExceptionEvent extends AbstractTideEvent
	{
        public var data:Object;
        
        public function RemoteExceptionEvent(data:Object = null):void {
       	    super();
            this.data = data;
        }

	}
}
