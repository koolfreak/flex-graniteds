package org.graniteds.tide.exception {
	import mx.messaging.messages.ErrorMessage;
	
	import org.granite.tide.BaseContext;
	import org.granite.tide.IExceptionHandler;
	
	
    public class SecurityExceptionHandler implements IExceptionHandler {
        
        public static const SECURITY:String = "Server.Security."; 
        
        public function accepts(emsg:ErrorMessage):Boolean {
            return emsg.faultCode.search(SECURITY) == 0;
        }
		
        public function handle(context:BaseContext, emsg:ErrorMessage):void {
            // Ignore for now
        }
    }
}
