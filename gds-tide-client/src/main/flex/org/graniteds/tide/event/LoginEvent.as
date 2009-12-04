package org.graniteds.tide.event
{
	import org.granite.tide.events.AbstractTideEvent;
	
	public class LoginEvent extends AbstractTideEvent
	{
        public var data:Object;
        
        public function LoginEvent(data:Object = null):void {
       	    super();
			trace('nakuha data =>'+data);
            this.data = data ;
        }

	}
}
